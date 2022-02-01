package com.huawei.secure.android.common.ssl.hostname;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;

public class a
{
  private final String a;
  private final int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private char[] g;
  
  public a(X500Principal paramX500Principal)
  {
    this.a = paramX500Principal.getName("RFC2253");
    this.b = this.a.length();
  }
  
  private int a(int paramInt)
  {
    int i = paramInt + 1;
    if (i < this.b)
    {
      paramInt = this.g[paramInt];
      if ((paramInt >= 48) && (paramInt <= 57))
      {
        paramInt -= 48;
      }
      else if ((paramInt >= 97) && (paramInt <= 102))
      {
        paramInt -= 87;
      }
      else
      {
        if ((paramInt < 65) || (paramInt > 70)) {
          break label182;
        }
        paramInt -= 55;
      }
      i = this.g[i];
      if ((i >= 48) && (i <= 57))
      {
        i -= 48;
      }
      else if ((i >= 97) && (i <= 102))
      {
        i -= 87;
      }
      else
      {
        if ((i < 65) || (i > 70)) {
          break label146;
        }
        i -= 55;
      }
      return (paramInt << 4) + i;
      label146:
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Malformed DN: ");
      localStringBuilder.append(this.a);
      throw new IllegalStateException(localStringBuilder.toString());
      label182:
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Malformed DN: ");
      localStringBuilder.append(this.a);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Malformed DN: ");
    localStringBuilder.append(this.a);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private String a()
  {
    int i = this.c;
    this.d = i;
    this.e = i;
    label179:
    do
    {
      for (;;)
      {
        i = this.c;
        if (i >= this.b)
        {
          arrayOfChar = this.g;
          i = this.d;
          return new String(arrayOfChar, i, this.e - i);
        }
        arrayOfChar = this.g;
        j = arrayOfChar[i];
        if (j == 32) {
          break label179;
        }
        if (j == 59) {
          break;
        }
        if (j != 92)
        {
          if ((j == 43) || (j == 44)) {
            break;
          }
          j = this.e;
          this.e = (j + 1);
          arrayOfChar[j] = arrayOfChar[i];
          this.c = (i + 1);
        }
        else
        {
          i = this.e;
          this.e = (i + 1);
          arrayOfChar[i] = b();
          this.c += 1;
        }
      }
      arrayOfChar = this.g;
      i = this.d;
      return new String(arrayOfChar, i, this.e - i);
      int j = this.e;
      this.f = j;
      this.c = (i + 1);
      this.e = (j + 1);
      arrayOfChar[j] = ' ';
      for (;;)
      {
        i = this.c;
        if (i >= this.b) {
          break;
        }
        arrayOfChar = this.g;
        if (arrayOfChar[i] != ' ') {
          break;
        }
        j = this.e;
        this.e = (j + 1);
        arrayOfChar[j] = ' ';
        this.c = (i + 1);
      }
      i = this.c;
      if (i == this.b) {
        break;
      }
      arrayOfChar = this.g;
    } while ((arrayOfChar[i] != ',') && (arrayOfChar[i] != '+') && (arrayOfChar[i] != ';'));
    char[] arrayOfChar = this.g;
    i = this.d;
    return new String(arrayOfChar, i, this.f - i);
  }
  
  private char b()
  {
    this.c += 1;
    int i = this.c;
    if (i != this.b)
    {
      localObject = this.g;
      int j = localObject[i];
      if ((j != 32) && (j != 37) && (j != 92) && (j != 95) && (j != 34) && (j != 35)) {
        switch (j)
        {
        default: 
          switch (j)
          {
          default: 
            return c();
          }
          break;
        }
      }
      return localObject[i];
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unexpected end of DN: ");
    ((StringBuilder)localObject).append(this.a);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  private char c()
  {
    int i = a(this.c);
    this.c += 1;
    if (i < 128) {
      return (char)i;
    }
    if ((i >= 192) && (i <= 247))
    {
      int j;
      if (i <= 223)
      {
        i &= 0x1F;
        j = 1;
      }
      else if (i <= 239)
      {
        j = 2;
        i &= 0xF;
      }
      else
      {
        j = 3;
        i &= 0x7;
      }
      int k = 0;
      while (k < j)
      {
        this.c += 1;
        int m = this.c;
        if (m != this.b)
        {
          if (this.g[m] != '\\') {
            return '?';
          }
          this.c = (m + 1);
          m = a(this.c);
          this.c += 1;
          if ((m & 0xC0) != 128) {
            return '?';
          }
          i = (i << 6) + (m & 0x3F);
          k += 1;
        }
        else
        {
          return '?';
        }
      }
      return (char)i;
    }
    return '?';
  }
  
  private String d()
  {
    int i = this.c;
    if (i + 4 < this.b)
    {
      this.d = i;
      for (this.c = (i + 1);; this.c += 1)
      {
        i = this.c;
        if (i == this.b) {
          break;
        }
        localObject = this.g;
        if ((localObject[i] == '+') || (localObject[i] == ',') || (localObject[i] == ';')) {
          break;
        }
        if (localObject[i] == ' ')
        {
          this.e = i;
          for (this.c = (i + 1);; this.c = (i + 1))
          {
            i = this.c;
            if ((i >= this.b) || (this.g[i] != ' ')) {
              break;
            }
          }
        }
        if ((localObject[i] >= 'A') && (localObject[i] <= 'F')) {
          localObject[i] = ((char)(localObject[i] + ' '));
        }
      }
      this.e = this.c;
      i = this.e;
      int j = this.d;
      int k = i - j;
      if ((k >= 5) && ((k & 0x1) != 0))
      {
        localObject = new byte[k / 2];
        i = 0;
        j += 1;
        while (i < localObject.length)
        {
          localObject[i] = ((byte)a(j));
          j += 2;
          i += 1;
        }
        return new String(this.g, this.d, k);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unexpected end of DN: ");
      ((StringBuilder)localObject).append(this.a);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unexpected end of DN: ");
    ((StringBuilder)localObject).append(this.a);
    localObject = new IllegalStateException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private String e()
  {
    for (;;)
    {
      i = this.c;
      if ((i >= this.b) || (this.g[i] != ' ')) {
        break;
      }
      this.c = (i + 1);
    }
    int i = this.c;
    if (i == this.b) {
      return null;
    }
    this.d = i;
    for (this.c = (i + 1);; this.c = (i + 1))
    {
      i = this.c;
      if (i >= this.b) {
        break;
      }
      localObject = this.g;
      if ((localObject[i] == '=') || (localObject[i] == ' ')) {
        break;
      }
    }
    i = this.c;
    if (i < this.b)
    {
      this.e = i;
      if (this.g[i] == ' ')
      {
        for (;;)
        {
          i = this.c;
          if (i >= this.b) {
            break;
          }
          localObject = this.g;
          if ((localObject[i] == '=') || (localObject[i] != ' ')) {
            break;
          }
          this.c = (i + 1);
        }
        localObject = this.g;
        i = this.c;
        if ((localObject[i] != '=') || (i == this.b))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Unexpected end of DN: ");
          ((StringBuilder)localObject).append(this.a);
          throw new IllegalStateException(((StringBuilder)localObject).toString());
        }
      }
      for (this.c += 1;; this.c = (i + 1))
      {
        i = this.c;
        if ((i >= this.b) || (this.g[i] != ' ')) {
          break;
        }
      }
      i = this.e;
      int j = this.d;
      if (i - j > 4)
      {
        localObject = this.g;
        if ((localObject[(j + 3)] == '.') && ((localObject[j] == 'O') || (localObject[j] == 'o')))
        {
          localObject = this.g;
          i = this.d + 1;
          if ((localObject[i] == 'I') || (localObject[i] == 'i'))
          {
            localObject = this.g;
            i = this.d + 2;
            if ((localObject[i] == 'D') || (localObject[i] == 'd')) {
              this.d += 4;
            }
          }
        }
      }
      localObject = this.g;
      i = this.d;
      return new String((char[])localObject, i, this.e - i);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unexpected end of DN: ");
    ((StringBuilder)localObject).append(this.a);
    localObject = new IllegalStateException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private String f()
  {
    this.c += 1;
    this.d = this.c;
    for (this.e = this.d;; this.e += 1)
    {
      int i = this.c;
      if (i == this.b) {
        break;
      }
      localObject = this.g;
      if (localObject[i] == '"')
      {
        for (this.c = (i + 1);; this.c = (i + 1))
        {
          i = this.c;
          if ((i >= this.b) || (this.g[i] != ' ')) {
            break;
          }
        }
        localObject = this.g;
        i = this.d;
        return new String((char[])localObject, i, this.e - i);
      }
      if (localObject[i] == '\\') {
        localObject[this.e] = b();
      } else {
        localObject[this.e] = localObject[i];
      }
      this.c += 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unexpected end of DN: ");
    ((StringBuilder)localObject).append(this.a);
    localObject = new IllegalStateException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public String a(String paramString)
  {
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.g = this.a.toCharArray();
    Object localObject1 = e();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      return null;
    }
    do
    {
      int i = this.c;
      if (i == this.b) {
        return null;
      }
      i = this.g[i];
      if (i != 34)
      {
        if (i != 35)
        {
          if ((i != 43) && (i != 44) && (i != 59)) {
            localObject1 = a();
          } else {
            localObject1 = "";
          }
        }
        else {
          localObject1 = d();
        }
      }
      else {
        localObject1 = f();
      }
      if (paramString.equalsIgnoreCase((String)localObject2)) {
        return localObject1;
      }
      i = this.c;
      if (i >= this.b) {
        return null;
      }
      localObject1 = this.g;
      if ((localObject1[i] != ',') && (localObject1[i] != ';') && (localObject1[i] != '+'))
      {
        paramString = new StringBuilder();
        paramString.append("Malformed DN: ");
        paramString.append(this.a);
        throw new IllegalStateException(paramString.toString());
      }
      this.c += 1;
      localObject2 = e();
    } while (localObject2 != null);
    paramString = new StringBuilder();
    paramString.append("Malformed DN: ");
    paramString.append(this.a);
    paramString = new IllegalStateException(paramString.toString());
    for (;;)
    {
      throw paramString;
    }
  }
  
  public List<String> b(String paramString)
  {
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.g = this.a.toCharArray();
    Object localObject1 = Collections.emptyList();
    Object localObject4 = e();
    Object localObject2 = localObject1;
    Object localObject3 = localObject4;
    if (localObject4 == null) {
      return localObject1;
    }
    for (;;)
    {
      int i = this.c;
      if (i >= this.b) {
        break label332;
      }
      i = this.g[i];
      if (i != 34)
      {
        if (i != 35)
        {
          if ((i != 43) && (i != 44) && (i != 59)) {
            localObject1 = a();
          } else {
            localObject1 = "";
          }
        }
        else {
          localObject1 = d();
        }
      }
      else {
        localObject1 = f();
      }
      localObject4 = localObject2;
      if (paramString.equalsIgnoreCase((String)localObject3))
      {
        localObject3 = localObject2;
        if (localObject2.isEmpty()) {
          localObject3 = new ArrayList();
        }
        ((List)localObject3).add(localObject1);
        localObject4 = localObject3;
      }
      i = this.c;
      if (i >= this.b) {
        return localObject4;
      }
      localObject1 = this.g;
      if ((localObject1[i] != ',') && (localObject1[i] != ';') && (localObject1[i] != '+'))
      {
        paramString = new StringBuilder();
        paramString.append("Malformed DN: ");
        paramString.append(this.a);
        throw new IllegalStateException(paramString.toString());
      }
      this.c += 1;
      localObject3 = e();
      if (localObject3 == null) {
        break;
      }
      localObject2 = localObject4;
    }
    paramString = new StringBuilder();
    paramString.append("Malformed DN: ");
    paramString.append(this.a);
    throw new IllegalStateException(paramString.toString());
    label332:
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.hostname.a
 * JD-Core Version:    0.7.0.1
 */