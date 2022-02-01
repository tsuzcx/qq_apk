package com.huawei.secure.android.common.ssl.hostname;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;

public class a
{
  private final String W;
  private int X;
  private int Y;
  private char[] Z;
  private int end;
  private final int length;
  private int pos;
  
  public a(X500Principal paramX500Principal)
  {
    this.W = paramX500Principal.getName("RFC2253");
    this.length = this.W.length();
  }
  
  private int a(int paramInt)
  {
    if (paramInt + 1 >= this.length) {
      throw new IllegalStateException("Malformed DN: " + this.W);
    }
    int i = this.Z[paramInt];
    if ((i >= 48) && (i <= 57))
    {
      i -= 48;
      paramInt = this.Z[(paramInt + 1)];
      if ((paramInt < 48) || (paramInt > 57)) {
        break label166;
      }
      paramInt -= 48;
    }
    for (;;)
    {
      return (i << 4) + paramInt;
      if ((i >= 97) && (i <= 102))
      {
        i -= 87;
        break;
      }
      if ((i >= 65) && (i <= 70))
      {
        i -= 55;
        break;
      }
      throw new IllegalStateException("Malformed DN: " + this.W);
      label166:
      if ((paramInt >= 97) && (paramInt <= 102))
      {
        paramInt -= 87;
      }
      else
      {
        if ((paramInt < 65) || (paramInt > 70)) {
          break label206;
        }
        paramInt -= 55;
      }
    }
    label206:
    throw new IllegalStateException("Malformed DN: " + this.W);
  }
  
  private String e()
  {
    while ((this.pos < this.length) && (this.Z[this.pos] == ' ')) {
      this.pos += 1;
    }
    if (this.pos == this.length) {
      return null;
    }
    this.X = this.pos;
    for (this.pos += 1; (this.pos < this.length) && (this.Z[this.pos] != '=') && (this.Z[this.pos] != ' '); this.pos += 1) {}
    if (this.pos >= this.length) {
      throw new IllegalStateException("Unexpected end of DN: " + this.W);
    }
    this.end = this.pos;
    if (this.Z[this.pos] == ' ')
    {
      while ((this.pos < this.length) && (this.Z[this.pos] != '=') && (this.Z[this.pos] == ' ')) {
        this.pos += 1;
      }
      if ((this.Z[this.pos] != '=') || (this.pos == this.length)) {
        throw new IllegalStateException("Unexpected end of DN: " + this.W);
      }
    }
    for (this.pos += 1; (this.pos < this.length) && (this.Z[this.pos] == ' '); this.pos += 1) {}
    if ((this.end - this.X > 4) && (this.Z[(this.X + 3)] == '.') && ((this.Z[this.X] == 'O') || (this.Z[this.X] == 'o')) && ((this.Z[(this.X + 1)] == 'I') || (this.Z[(this.X + 1)] == 'i')) && ((this.Z[(this.X + 2)] == 'D') || (this.Z[(this.X + 2)] == 'd'))) {
      this.X += 4;
    }
    return new String(this.Z, this.X, this.end - this.X);
  }
  
  private String f()
  {
    this.pos += 1;
    this.X = this.pos;
    this.end = this.X;
    if (this.pos == this.length) {
      throw new IllegalStateException("Unexpected end of DN: " + this.W);
    }
    if (this.Z[this.pos] == '"') {
      for (this.pos += 1; (this.pos < this.length) && (this.Z[this.pos] == ' '); this.pos += 1) {}
    }
    if (this.Z[this.pos] == '\\') {
      this.Z[this.end] = i();
    }
    for (;;)
    {
      this.pos += 1;
      this.end += 1;
      break;
      this.Z[this.end] = this.Z[this.pos];
    }
    return new String(this.Z, this.X, this.end - this.X);
  }
  
  private String g()
  {
    if (this.pos + 4 >= this.length) {
      throw new IllegalStateException("Unexpected end of DN: " + this.W);
    }
    this.X = this.pos;
    int k;
    for (this.pos += 1;; this.pos += 1)
    {
      if ((this.pos == this.length) || (this.Z[this.pos] == '+') || (this.Z[this.pos] == ',') || (this.Z[this.pos] == ';')) {
        this.end = this.pos;
      }
      for (;;)
      {
        k = this.end - this.X;
        if ((k >= 5) && ((k & 0x1) != 0)) {
          break label307;
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.W);
        if (this.Z[this.pos] != ' ') {
          break;
        }
        this.end = this.pos;
        for (this.pos += 1; (this.pos < this.length) && (this.Z[this.pos] == ' '); this.pos += 1) {}
      }
      if ((this.Z[this.pos] >= 'A') && (this.Z[this.pos] <= 'F'))
      {
        localObject = this.Z;
        i = this.pos;
        localObject[i] = ((char)(localObject[i] + ' '));
      }
    }
    label307:
    Object localObject = new byte[k / 2];
    int i = 0;
    int j = this.X + 1;
    while (i < localObject.length)
    {
      localObject[i] = ((byte)a(j));
      j += 2;
      i += 1;
    }
    return new String(this.Z, this.X, k);
  }
  
  private String h()
  {
    this.X = this.pos;
    this.end = this.pos;
    do
    {
      for (;;)
      {
        if (this.pos >= this.length) {
          return new String(this.Z, this.X, this.end - this.X);
        }
        switch (this.Z[this.pos])
        {
        default: 
          arrayOfChar = this.Z;
          i = this.end;
          this.end = (i + 1);
          arrayOfChar[i] = this.Z[this.pos];
          this.pos += 1;
          break;
        case '+': 
        case ',': 
        case ';': 
          return new String(this.Z, this.X, this.end - this.X);
        case '\\': 
          arrayOfChar = this.Z;
          i = this.end;
          this.end = (i + 1);
          arrayOfChar[i] = i();
          this.pos += 1;
        }
      }
      this.Y = this.end;
      this.pos += 1;
      char[] arrayOfChar = this.Z;
      int i = this.end;
      this.end = (i + 1);
      arrayOfChar[i] = ' ';
      while ((this.pos < this.length) && (this.Z[this.pos] == ' '))
      {
        arrayOfChar = this.Z;
        i = this.end;
        this.end = (i + 1);
        arrayOfChar[i] = ' ';
        this.pos += 1;
      }
    } while ((this.pos != this.length) && (this.Z[this.pos] != ',') && (this.Z[this.pos] != '+') && (this.Z[this.pos] != ';'));
    return new String(this.Z, this.X, this.Y - this.X);
  }
  
  private char i()
  {
    this.pos += 1;
    if (this.pos == this.length) {
      throw new IllegalStateException("Unexpected end of DN: " + this.W);
    }
    switch (this.Z[this.pos])
    {
    default: 
      return j();
    }
    return this.Z[this.pos];
  }
  
  private char j()
  {
    int i = a(this.pos);
    this.pos += 1;
    if (i < 128) {
      return (char)i;
    }
    if ((i >= 192) && (i <= 247))
    {
      int j;
      int m;
      int k;
      if (i <= 223)
      {
        j = 1;
        i &= 0x1F;
        m = 0;
        k = i;
        i = m;
      }
      for (;;)
      {
        if (i >= j) {
          break label198;
        }
        this.pos += 1;
        if ((this.pos == this.length) || (this.Z[this.pos] != '\\'))
        {
          return '?';
          if (i <= 239)
          {
            j = 2;
            i &= 0xF;
            break;
          }
          j = 3;
          i &= 0x7;
          break;
        }
        this.pos += 1;
        m = a(this.pos);
        this.pos += 1;
        if ((m & 0xC0) != 128) {
          return '?';
        }
        k = (k << 6) + (m & 0x3F);
        i += 1;
      }
      label198:
      return (char)k;
    }
    return '?';
  }
  
  public List<String> a(String paramString)
  {
    this.pos = 0;
    this.X = 0;
    this.end = 0;
    this.Y = 0;
    this.Z = this.W.toCharArray();
    Object localObject1 = Collections.emptyList();
    Object localObject3 = e();
    if (localObject3 == null) {
      return localObject1;
    }
    Object localObject2 = localObject1;
    String str;
    if (this.pos < this.length)
    {
      str = "";
      switch (this.Z[this.pos])
      {
      default: 
        str = h();
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (paramString.equalsIgnoreCase((String)localObject3))
      {
        localObject2 = localObject1;
        if (((List)localObject1).isEmpty()) {
          localObject2 = new ArrayList();
        }
        ((List)localObject2).add(str);
      }
      if (this.pos < this.length) {
        break;
      }
      return localObject2;
      str = f();
      continue;
      str = g();
    }
    if ((this.Z[this.pos] == ',') || (this.Z[this.pos] == ';')) {}
    while (this.Z[this.pos] == '+')
    {
      this.pos += 1;
      str = e();
      localObject1 = localObject2;
      localObject3 = str;
      if (str != null) {
        break;
      }
      throw new IllegalStateException("Malformed DN: " + this.W);
    }
    throw new IllegalStateException("Malformed DN: " + this.W);
  }
  
  public String findMostSpecific(String paramString)
  {
    this.pos = 0;
    this.X = 0;
    this.end = 0;
    this.Y = 0;
    this.Z = this.W.toCharArray();
    String str1 = e();
    String str2 = str1;
    if (str1 == null)
    {
      str1 = null;
      return str1;
    }
    str1 = "";
    if (this.pos == this.length) {
      return null;
    }
    switch (this.Z[this.pos])
    {
    default: 
      str1 = h();
    }
    while (!paramString.equalsIgnoreCase(str2))
    {
      if (this.pos < this.length) {
        break label162;
      }
      return null;
      str1 = f();
      continue;
      str1 = g();
    }
    label162:
    if ((this.Z[this.pos] == ',') || (this.Z[this.pos] == ';')) {}
    while (this.Z[this.pos] == '+')
    {
      this.pos += 1;
      str1 = e();
      str2 = str1;
      if (str1 != null) {
        break;
      }
      throw new IllegalStateException("Malformed DN: " + this.W);
    }
    throw new IllegalStateException("Malformed DN: " + this.W);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.hostname.a
 * JD-Core Version:    0.7.0.1
 */