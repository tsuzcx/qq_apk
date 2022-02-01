package com.tencent.map.sdk.a;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class fe
  implements Closeable
{
  private static final char[] a = ")]}'\n".toCharArray();
  private static final fi m = new fi();
  public boolean b = false;
  private final Reader c;
  private final char[] d = new char[1024];
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private long j;
  private int k;
  private String l;
  private int[] n = new int[32];
  private int o = 0;
  
  static
  {
    ek.a = new fe.1();
  }
  
  public fe(Reader paramReader)
  {
    int[] arrayOfInt = this.n;
    int i1 = this.o;
    this.o = (i1 + 1);
    arrayOfInt[i1] = 6;
    if (paramReader != null)
    {
      this.c = paramReader;
      return;
    }
    throw new NullPointerException("in == null");
  }
  
  private int a(boolean paramBoolean)
  {
    Object localObject = this.d;
    int i1 = this.e;
    int i2 = this.f;
    for (;;)
    {
      int i4 = i1;
      int i3 = i2;
      if (i1 == i2)
      {
        this.e = i1;
        if (b(1))
        {
          i4 = this.e;
          i3 = this.f;
        }
        else
        {
          if (!paramBoolean) {
            return -1;
          }
          localObject = new StringBuilder("End of input at line ");
          ((StringBuilder)localObject).append(this.g + 1);
          ((StringBuilder)localObject).append(" column ");
          ((StringBuilder)localObject).append(s());
          throw new EOFException(((StringBuilder)localObject).toString());
        }
      }
      i1 = i4 + 1;
      i2 = localObject[i4];
      if (i2 == 10)
      {
        this.g += 1;
        this.h = i1;
      }
      else if ((i2 != 32) && (i2 != 13) && (i2 != 9))
      {
        if (i2 == 47)
        {
          this.e = i1;
          if (i1 == i3)
          {
            this.e -= 1;
            boolean bool = b(2);
            this.e += 1;
            if (!bool) {
              return i2;
            }
          }
          t();
          i1 = this.e;
          i3 = localObject[i1];
          if (i3 != 42)
          {
            if (i3 != 47) {
              return i2;
            }
            this.e = (i1 + 1);
            u();
            i1 = this.e;
            i2 = this.f;
            continue;
          }
          this.e = (i1 + 1);
          if (a("*/"))
          {
            i1 = this.e + 2;
            i2 = this.f;
            continue;
          }
          throw b("Unterminated comment");
        }
        if (i2 == 35)
        {
          this.e = i1;
          t();
          u();
          i1 = this.e;
          i2 = this.f;
          continue;
        }
        this.e = i1;
        return i2;
      }
      i2 = i3;
    }
  }
  
  private void a(int paramInt)
  {
    int i1 = this.o;
    int[] arrayOfInt1 = this.n;
    if (i1 == arrayOfInt1.length)
    {
      int[] arrayOfInt2 = new int[i1 * 2];
      System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, i1);
      this.n = arrayOfInt2;
    }
    arrayOfInt1 = this.n;
    i1 = this.o;
    this.o = (i1 + 1);
    arrayOfInt1[i1] = paramInt;
  }
  
  private boolean a(char paramChar)
  {
    if ((paramChar != '\t') && (paramChar != '\n') && (paramChar != '\f') && (paramChar != '\r') && (paramChar != ' '))
    {
      if (paramChar != '#')
      {
        if (paramChar == ',') {
          break label110;
        }
        if ((paramChar != '/') && (paramChar != '='))
        {
          if ((paramChar == '{') || (paramChar == '}') || (paramChar == ':')) {
            break label110;
          }
          if (paramChar == ';') {}
        }
      }
      switch (paramChar)
      {
      default: 
        return true;
      case '\\': 
        t();
      }
    }
    label110:
    return false;
  }
  
  private boolean a(String paramString)
  {
    for (;;)
    {
      int i2 = this.e;
      int i3 = paramString.length();
      int i4 = this.f;
      int i1 = 0;
      if ((i2 + i3 > i4) && (!b(paramString.length()))) {
        return false;
      }
      char[] arrayOfChar = this.d;
      i2 = this.e;
      if (arrayOfChar[i2] == '\n')
      {
        this.g += 1;
        this.h = (i2 + 1);
      }
      else
      {
        for (;;)
        {
          if (i1 >= paramString.length()) {
            break label131;
          }
          if (this.d[(this.e + i1)] != paramString.charAt(i1)) {
            break;
          }
          i1 += 1;
        }
      }
      this.e += 1;
    }
    label131:
    return true;
  }
  
  private IOException b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" at line ");
    localStringBuilder.append(this.g + 1);
    localStringBuilder.append(" column ");
    localStringBuilder.append(s());
    throw new fh(localStringBuilder.toString());
  }
  
  private String b(char paramChar)
  {
    char[] arrayOfChar = this.d;
    Object localObject1 = null;
    int i1 = 0;
    label258:
    for (;;)
    {
      char c2 = this.e;
      int i2 = this.f;
      char c3;
      for (char c1 = c2; c1 < i2; c1 = c3)
      {
        c3 = c1 + '\001';
        c1 = arrayOfChar[c1];
        if (c1 == paramChar)
        {
          this.e = c3;
          if (localObject1 == null) {
            return m.a(arrayOfChar, c2, c3 - c2 - 1, i1);
          }
          ((StringBuilder)localObject1).append(arrayOfChar, c2, c3 - c2 - 1);
          return ((StringBuilder)localObject1).toString();
        }
        if (c1 == '\\')
        {
          this.e = c3;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new StringBuilder();
          }
          ((StringBuilder)localObject2).append(arrayOfChar, c2, c3 - c2 - 1);
          ((StringBuilder)localObject2).append(v());
          localObject1 = localObject2;
          break label258;
        }
        if (c1 == '\n')
        {
          i1 = i1 * 31 + c1;
          this.g += 1;
          this.h = c3;
        }
        else
        {
          i1 = i1 * 31 + c1;
        }
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuilder();
      }
      ((StringBuilder)localObject2).append(arrayOfChar, c2, c1 - c2);
      this.e = c1;
      if (!b(1)) {
        break;
      }
      localObject1 = localObject2;
    }
    localObject1 = b("Unterminated string");
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  private boolean b(int paramInt)
  {
    char[] arrayOfChar = this.d;
    int i2 = this.h;
    int i1 = this.e;
    this.h = (i2 - i1);
    i2 = this.f;
    if (i2 != i1)
    {
      this.f = (i2 - i1);
      System.arraycopy(arrayOfChar, i1, arrayOfChar, 0, this.f);
    }
    else
    {
      this.f = 0;
    }
    this.e = 0;
    do
    {
      Reader localReader = this.c;
      i1 = this.f;
      i1 = localReader.read(arrayOfChar, i1, arrayOfChar.length - i1);
      if (i1 == -1) {
        break;
      }
      this.f += i1;
      i1 = paramInt;
      if (this.g == 0)
      {
        i2 = this.h;
        i1 = paramInt;
        if (i2 == 0)
        {
          i1 = paramInt;
          if (this.f > 0)
          {
            i1 = paramInt;
            if (arrayOfChar[0] == 65279)
            {
              this.e += 1;
              this.h = (i2 + 1);
              i1 = paramInt + 1;
            }
          }
        }
      }
      paramInt = i1;
    } while (this.f < i1);
    return true;
    return false;
  }
  
  private void c(char paramChar)
  {
    Object localObject = this.d;
    label88:
    do
    {
      char c1 = this.e;
      char c3 = this.f;
      for (;;)
      {
        if (c1 >= c3) {
          break label88;
        }
        char c2 = c1 + '\001';
        c1 = localObject[c1];
        if (c1 == paramChar)
        {
          this.e = c2;
          return;
        }
        if (c1 == '\\')
        {
          this.e = c2;
          v();
          break;
        }
        if (c1 == '\n')
        {
          this.g += 1;
          this.h = c2;
        }
        c1 = c2;
      }
      this.e = c1;
    } while (b(1));
    localObject = b("Unterminated string");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private int g()
  {
    Object localObject = this.n;
    int i2 = this.o;
    int i1 = localObject[(i2 - 1)];
    if (i1 == 1)
    {
      localObject[(i2 - 1)] = 2;
    }
    else if (i1 == 2)
    {
      i2 = a(true);
      if (i2 != 44)
      {
        if (i2 != 59)
        {
          if (i2 == 93)
          {
            this.i = 4;
            return 4;
          }
          throw b("Unterminated array");
        }
        t();
      }
    }
    else
    {
      if ((i1 == 3) || (i1 == 5)) {
        break label501;
      }
      if (i1 == 4)
      {
        localObject[(i2 - 1)] = 5;
        i2 = a(true);
        if (i2 != 58) {
          if (i2 == 61)
          {
            t();
            if ((this.e < this.f) || (b(1)))
            {
              localObject = this.d;
              i2 = this.e;
              if (localObject[i2] == '>') {
                this.e = (i2 + 1);
              }
            }
          }
          else
          {
            throw b("Expected ':'");
          }
        }
      }
      else if (i1 == 6)
      {
        if (this.b) {
          w();
        }
        this.n[(this.o - 1)] = 7;
      }
      else if (i1 == 7)
      {
        if (a(false) == -1)
        {
          this.i = 17;
          return 17;
        }
        t();
        this.e -= 1;
      }
      else
      {
        if (i1 == 8) {
          break label491;
        }
      }
    }
    i2 = a(true);
    if (i2 != 34)
    {
      if (i2 != 39)
      {
        if ((i2 != 44) && (i2 != 59)) {
          if (i2 != 91)
          {
            if (i2 != 93)
            {
              if (i2 != 123)
              {
                this.e -= 1;
                if (this.o == 1) {
                  t();
                }
                i1 = p();
                if (i1 != 0) {
                  return i1;
                }
                i1 = q();
                if (i1 != 0) {
                  return i1;
                }
                if (a(this.d[this.e]))
                {
                  t();
                  this.i = 10;
                  return 10;
                }
                throw b("Expected value");
              }
              this.i = 1;
              return 1;
            }
            if (i1 == 1)
            {
              this.i = 4;
              return 4;
            }
          }
          else
          {
            this.i = 3;
            return 3;
          }
        }
        if ((i1 != 1) && (i1 != 2)) {
          throw b("Unexpected value");
        }
        t();
        this.e -= 1;
        this.i = 7;
        return 7;
      }
      t();
      this.i = 8;
      return 8;
    }
    if (this.o == 1) {
      t();
    }
    this.i = 9;
    return 9;
    label491:
    throw new IllegalStateException("JsonReader is closed");
    label501:
    this.n[(this.o - 1)] = 4;
    if (i1 == 5)
    {
      i2 = a(true);
      if (i2 != 44)
      {
        if (i2 != 59)
        {
          if (i2 == 125)
          {
            this.i = 2;
            return 2;
          }
          throw b("Unterminated object");
        }
        t();
      }
    }
    i2 = a(true);
    if (i2 != 34)
    {
      if (i2 != 39)
      {
        if (i2 != 125)
        {
          t();
          this.e -= 1;
          if (a((char)i2))
          {
            this.i = 14;
            return 14;
          }
          throw b("Expected name");
        }
        if (i1 != 5)
        {
          this.i = 2;
          return 2;
        }
        throw b("Expected name");
      }
      t();
      this.i = 12;
      return 12;
    }
    this.i = 13;
    return 13;
  }
  
  private int p()
  {
    int i1 = this.d[this.e];
    String str1;
    String str2;
    if ((i1 != 116) && (i1 != 84))
    {
      if ((i1 != 102) && (i1 != 70))
      {
        if ((i1 != 110) && (i1 != 78)) {
          return 0;
        }
        i1 = 7;
        str1 = "null";
        str2 = "NULL";
      }
      else
      {
        i1 = 6;
        str1 = "false";
        str2 = "FALSE";
      }
    }
    else
    {
      i1 = 5;
      str1 = "true";
      str2 = "TRUE";
    }
    int i3 = str1.length();
    int i2 = 1;
    while (i2 < i3)
    {
      if ((this.e + i2 >= this.f) && (!b(i2 + 1))) {
        return 0;
      }
      int i4 = this.d[(this.e + i2)];
      if ((i4 != str1.charAt(i2)) && (i4 != str2.charAt(i2))) {
        return 0;
      }
      i2 += 1;
    }
    if (((this.e + i3 < this.f) || (b(i3 + 1))) && (a(this.d[(this.e + i3)]))) {
      return 0;
    }
    this.e += i3;
    this.i = i1;
    return i1;
  }
  
  private int q()
  {
    char[] arrayOfChar = this.d;
    int i8 = this.e;
    int i3 = this.f;
    int i5 = 0;
    int i1 = 0;
    int i2 = 1;
    long l1 = 0L;
    int i4 = 0;
    for (;;)
    {
      int i7 = i8;
      int i6 = i3;
      if (i8 + i5 == i3)
      {
        if (i5 == arrayOfChar.length) {
          return 0;
        }
        if (b(i5 + 1))
        {
          i7 = this.e;
          i6 = this.f;
        }
      }
      else
      {
        char c1 = arrayOfChar[(i7 + i5)];
        if (c1 == '+') {
          break label445;
        }
        if ((c1 == 'E') || (c1 == 'e')) {
          break label425;
        }
        if (c1 == '-') {
          break label403;
        }
        if (c1 == '.') {
          break label391;
        }
        if ((c1 >= '0') && (c1 <= '9'))
        {
          if ((i1 != 1) && (i1 != 0))
          {
            long l2;
            if (i1 == 2)
            {
              if (l1 == 0L) {
                return 0;
              }
              l2 = 10L * l1 - (c1 - '0');
              if ((l1 <= -922337203685477580L) && ((l1 != -922337203685477580L) || (l2 >= l1))) {
                i3 = 0;
              } else {
                i3 = 1;
              }
              i3 &= i2;
            }
            else
            {
              if (i1 == 3)
              {
                i1 = 4;
                break label453;
              }
              if (i1 == 5) {
                break label264;
              }
              i3 = i2;
              l2 = l1;
              if (i1 == 6) {
                break label264;
              }
            }
            i2 = i3;
            l1 = l2;
            break label453;
            label264:
            i1 = 7;
            break label453;
          }
          l1 = -(c1 - '0');
          i1 = 2;
          break label453;
        }
        if (a(c1)) {
          return 0;
        }
      }
      if ((i1 == 2) && (i2 != 0) && ((l1 != -9223372036854775808L) || (i4 != 0)))
      {
        if (i4 == 0) {
          l1 = -l1;
        }
        this.j = l1;
        this.e += i5;
        this.i = 15;
        return 15;
      }
      if ((i1 != 2) && (i1 != 4) && (i1 != 7)) {
        return 0;
      }
      this.k = i5;
      this.i = 16;
      return 16;
      label391:
      if (i1 == 2)
      {
        i1 = 3;
      }
      else
      {
        return 0;
        label403:
        if (i1 == 0)
        {
          i1 = 1;
          i4 = 1;
        }
        else if (i1 != 5)
        {
          return 0;
          label425:
          if ((i1 != 2) && (i1 != 4)) {
            return 0;
          }
          i1 = 5;
          break label453;
          label445:
          if (i1 != 5) {
            break;
          }
        }
        else
        {
          i1 = 6;
        }
      }
      label453:
      i5 += 1;
      i8 = i7;
      i3 = i6;
    }
    return 0;
  }
  
  private String r()
  {
    int i2 = 0;
    Object localObject1 = null;
    label150:
    label172:
    label175:
    Object localObject2;
    do
    {
      i1 = 0;
      do
      {
        for (;;)
        {
          int i3 = this.e;
          if (i3 + i1 >= this.f) {
            break label150;
          }
          i3 = this.d[(i3 + i1)];
          if ((i3 == 9) || (i3 == 10) || (i3 == 12) || (i3 == 13) || (i3 == 32)) {
            break label172;
          }
          if (i3 == 35) {
            break;
          }
          if (i3 == 44) {
            break label172;
          }
          if ((i3 == 47) || (i3 == 61)) {
            break;
          }
          if ((i3 == 123) || (i3 == 125) || (i3 == 58)) {
            break label172;
          }
          if (i3 == 59) {
            break;
          }
          switch (i3)
          {
          default: 
            i1 += 1;
          }
        }
        t();
        break;
        if (i1 >= this.d.length) {
          break label175;
        }
      } while (b(i1 + 1));
      break;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuilder();
      }
      ((StringBuilder)localObject2).append(this.d, this.e, i1);
      this.e += i1;
      localObject1 = localObject2;
    } while (b(1));
    localObject1 = localObject2;
    int i1 = i2;
    if (localObject1 == null)
    {
      localObject1 = new String(this.d, this.e, i1);
    }
    else
    {
      ((StringBuilder)localObject1).append(this.d, this.e, i1);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    this.e += i1;
    return localObject1;
  }
  
  private int s()
  {
    return this.e - this.h + 1;
  }
  
  private void t()
  {
    if (this.b) {
      return;
    }
    throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
  }
  
  private void u()
  {
    int i1;
    do
    {
      if ((this.e >= this.f) && (!b(1))) {
        break;
      }
      char[] arrayOfChar = this.d;
      i1 = this.e;
      this.e = (i1 + 1);
      i1 = arrayOfChar[i1];
      if (i1 == 10)
      {
        this.g += 1;
        this.h = this.e;
        return;
      }
    } while (i1 != 13);
  }
  
  private char v()
  {
    if ((this.e == this.f) && (!b(1))) {
      throw b("Unterminated escape sequence");
    }
    Object localObject = this.d;
    int i1 = this.e;
    this.e = (i1 + 1);
    char c1 = localObject[i1];
    if (c1 != '\n')
    {
      if (c1 != 'b')
      {
        if (c1 != 'f')
        {
          if (c1 != 'n')
          {
            if (c1 != 'r')
            {
              if (c1 != 't')
              {
                if (c1 != 'u') {
                  return c1;
                }
                if ((this.e + 4 > this.f) && (!b(4))) {
                  throw b("Unterminated escape sequence");
                }
                c1 = '\000';
                int i2 = this.e;
                int i3;
                for (i1 = i2;; i1 = i3 + 1)
                {
                  i3 = i1;
                  if (i3 >= i2 + 4) {
                    break label286;
                  }
                  i1 = this.d[i3];
                  int i4 = (char)(c1 << '\004');
                  if ((i1 >= 48) && (i1 <= 57))
                  {
                    i1 -= 48;
                    c1 = (char)(i4 + i1);
                  }
                  else
                  {
                    if ((i1 >= 97) && (i1 <= 102)) {
                      i1 -= 97;
                    }
                    for (;;)
                    {
                      i1 += 10;
                      break;
                      if ((i1 < 65) || (i1 > 70)) {
                        break label240;
                      }
                      i1 -= 65;
                    }
                  }
                }
                label240:
                localObject = new StringBuilder("\\u");
                ((StringBuilder)localObject).append(new String(this.d, this.e, 4));
                throw new NumberFormatException(((StringBuilder)localObject).toString());
                label286:
                this.e += 4;
                return c1;
              }
              return '\t';
            }
            return '\r';
          }
          return '\n';
        }
        return '\f';
      }
      return '\b';
    }
    this.g += 1;
    this.h = this.e;
    return c1;
  }
  
  private void w()
  {
    a(true);
    this.e -= 1;
    int i1 = this.e;
    char[] arrayOfChar = a;
    if ((i1 + arrayOfChar.length > this.f) && (!b(arrayOfChar.length))) {
      return;
    }
    i1 = 0;
    for (;;)
    {
      arrayOfChar = a;
      if (i1 >= arrayOfChar.length) {
        break;
      }
      if (this.d[(this.e + i1)] != arrayOfChar[i1]) {
        return;
      }
      i1 += 1;
    }
    this.e += arrayOfChar.length;
  }
  
  public void a()
  {
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = g();
    }
    if (i1 == 3)
    {
      a(1);
      this.i = 0;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("Expected BEGIN_ARRAY but was ");
    localStringBuilder.append(f());
    localStringBuilder.append(" at line ");
    localStringBuilder.append(this.g + 1);
    localStringBuilder.append(" column ");
    localStringBuilder.append(s());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void b()
  {
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = g();
    }
    if (i1 == 4)
    {
      this.o -= 1;
      this.i = 0;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("Expected END_ARRAY but was ");
    localStringBuilder.append(f());
    localStringBuilder.append(" at line ");
    localStringBuilder.append(this.g + 1);
    localStringBuilder.append(" column ");
    localStringBuilder.append(s());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void c()
  {
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = g();
    }
    if (i1 == 1)
    {
      a(3);
      this.i = 0;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("Expected BEGIN_OBJECT but was ");
    localStringBuilder.append(f());
    localStringBuilder.append(" at line ");
    localStringBuilder.append(this.g + 1);
    localStringBuilder.append(" column ");
    localStringBuilder.append(s());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void close()
  {
    this.i = 0;
    this.n[0] = 8;
    this.o = 1;
    this.c.close();
  }
  
  public void d()
  {
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = g();
    }
    if (i1 == 2)
    {
      this.o -= 1;
      this.i = 0;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("Expected END_OBJECT but was ");
    localStringBuilder.append(f());
    localStringBuilder.append(" at line ");
    localStringBuilder.append(this.g + 1);
    localStringBuilder.append(" column ");
    localStringBuilder.append(s());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public boolean e()
  {
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = g();
    }
    return (i1 != 2) && (i1 != 4);
  }
  
  public ff f()
  {
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = g();
    }
    switch (i1)
    {
    default: 
      throw new AssertionError();
    case 17: 
      return ff.j;
    case 15: 
    case 16: 
      return ff.g;
    case 12: 
    case 13: 
    case 14: 
      return ff.e;
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      return ff.f;
    case 7: 
      return ff.i;
    case 5: 
    case 6: 
      return ff.h;
    case 4: 
      return ff.b;
    case 3: 
      return ff.a;
    case 2: 
      return ff.d;
    }
    return ff.c;
  }
  
  public String h()
  {
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = g();
    }
    if (i1 == 14)
    {
      localObject = r();
    }
    else if (i1 == 12)
    {
      localObject = b('\'');
    }
    else
    {
      if (i1 != 13) {
        break label66;
      }
      localObject = b('"');
    }
    this.i = 0;
    return localObject;
    label66:
    Object localObject = new StringBuilder("Expected a name but was ");
    ((StringBuilder)localObject).append(f());
    ((StringBuilder)localObject).append(" at line ");
    ((StringBuilder)localObject).append(this.g + 1);
    ((StringBuilder)localObject).append(" column ");
    ((StringBuilder)localObject).append(s());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public String i()
  {
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = g();
    }
    if (i1 == 10)
    {
      localObject = r();
    }
    else if (i1 == 8)
    {
      localObject = b('\'');
    }
    else if (i1 == 9)
    {
      localObject = b('"');
    }
    else if (i1 == 11)
    {
      localObject = this.l;
      this.l = null;
    }
    else if (i1 == 15)
    {
      localObject = Long.toString(this.j);
    }
    else
    {
      if (i1 != 16) {
        break label144;
      }
      localObject = new String(this.d, this.e, this.k);
      this.e += this.k;
    }
    this.i = 0;
    return localObject;
    label144:
    Object localObject = new StringBuilder("Expected a string but was ");
    ((StringBuilder)localObject).append(f());
    ((StringBuilder)localObject).append(" at line ");
    ((StringBuilder)localObject).append(this.g + 1);
    ((StringBuilder)localObject).append(" column ");
    ((StringBuilder)localObject).append(s());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public boolean j()
  {
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = g();
    }
    if (i1 == 5)
    {
      this.i = 0;
      return true;
    }
    if (i1 == 6)
    {
      this.i = 0;
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder("Expected a boolean but was ");
    localStringBuilder.append(f());
    localStringBuilder.append(" at line ");
    localStringBuilder.append(this.g + 1);
    localStringBuilder.append(" column ");
    localStringBuilder.append(s());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void k()
  {
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = g();
    }
    if (i1 == 7)
    {
      this.i = 0;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("Expected null but was ");
    localStringBuilder.append(f());
    localStringBuilder.append(" at line ");
    localStringBuilder.append(this.g + 1);
    localStringBuilder.append(" column ");
    localStringBuilder.append(s());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public double l()
  {
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = g();
    }
    if (i1 == 15)
    {
      this.i = 0;
      return this.j;
    }
    StringBuilder localStringBuilder;
    if (i1 == 16)
    {
      this.l = new String(this.d, this.e, this.k);
      this.e += this.k;
    }
    else if ((i1 != 8) && (i1 != 9))
    {
      if (i1 == 10)
      {
        this.l = r();
      }
      else if (i1 != 11)
      {
        localStringBuilder = new StringBuilder("Expected a double but was ");
        localStringBuilder.append(f());
        localStringBuilder.append(" at line ");
        localStringBuilder.append(this.g + 1);
        localStringBuilder.append(" column ");
        localStringBuilder.append(s());
        throw new IllegalStateException(localStringBuilder.toString());
      }
    }
    else
    {
      char c1;
      if (i1 == 8) {
        c1 = '\'';
      } else {
        c1 = '"';
      }
      this.l = b(c1);
    }
    this.i = 11;
    double d1 = Double.parseDouble(this.l);
    if ((!this.b) && ((Double.isNaN(d1)) || (Double.isInfinite(d1))))
    {
      localStringBuilder = new StringBuilder("JSON forbids NaN and infinities: ");
      localStringBuilder.append(d1);
      localStringBuilder.append(" at line ");
      localStringBuilder.append(this.g + 1);
      localStringBuilder.append(" column ");
      localStringBuilder.append(s());
      throw new fh(localStringBuilder.toString());
    }
    this.l = null;
    this.i = 0;
    return d1;
  }
  
  public long m()
  {
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = g();
    }
    if (i1 == 15)
    {
      this.i = 0;
      return this.j;
    }
    if (i1 == 16)
    {
      this.l = new String(this.d, this.e, this.k);
      this.e += this.k;
    }
    else
    {
      if ((i1 != 8) && (i1 != 9))
      {
        localStringBuilder = new StringBuilder("Expected a long but was ");
        localStringBuilder.append(f());
        localStringBuilder.append(" at line ");
        localStringBuilder.append(this.g + 1);
        localStringBuilder.append(" column ");
        localStringBuilder.append(s());
        throw new IllegalStateException(localStringBuilder.toString());
      }
      char c1;
      if (i1 == 8) {
        c1 = '\'';
      } else {
        c1 = '"';
      }
      this.l = b(c1);
    }
    try
    {
      l1 = Long.parseLong(this.l);
      this.i = 0;
      return l1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l1;
      label216:
      double d1;
      break label216;
    }
    this.i = 11;
    d1 = Double.parseDouble(this.l);
    l1 = d1;
    if (l1 == d1)
    {
      this.l = null;
      this.i = 0;
      return l1;
    }
    StringBuilder localStringBuilder = new StringBuilder("Expected a long but was ");
    localStringBuilder.append(this.l);
    localStringBuilder.append(" at line ");
    localStringBuilder.append(this.g + 1);
    localStringBuilder.append(" column ");
    localStringBuilder.append(s());
    throw new NumberFormatException(localStringBuilder.toString());
  }
  
  public int n()
  {
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = g();
    }
    if (i1 == 15)
    {
      long l1 = this.j;
      i1 = (int)l1;
      if (l1 == i1)
      {
        this.i = 0;
        return i1;
      }
      localStringBuilder = new StringBuilder("Expected an int but was ");
      localStringBuilder.append(this.j);
      localStringBuilder.append(" at line ");
      localStringBuilder.append(this.g + 1);
      localStringBuilder.append(" column ");
      localStringBuilder.append(s());
      throw new NumberFormatException(localStringBuilder.toString());
    }
    if (i1 == 16)
    {
      this.l = new String(this.d, this.e, this.k);
      this.e += this.k;
    }
    else
    {
      if ((i1 != 8) && (i1 != 9))
      {
        localStringBuilder = new StringBuilder("Expected an int but was ");
        localStringBuilder.append(f());
        localStringBuilder.append(" at line ");
        localStringBuilder.append(this.g + 1);
        localStringBuilder.append(" column ");
        localStringBuilder.append(s());
        throw new IllegalStateException(localStringBuilder.toString());
      }
      char c1;
      if (i1 == 8) {
        c1 = '\'';
      } else {
        c1 = '"';
      }
      this.l = b(c1);
    }
    try
    {
      i1 = Integer.parseInt(this.l);
      this.i = 0;
      return i1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label307:
      double d1;
      break label307;
    }
    this.i = 11;
    d1 = Double.parseDouble(this.l);
    i1 = (int)d1;
    if (i1 == d1)
    {
      this.l = null;
      this.i = 0;
      return i1;
    }
    StringBuilder localStringBuilder = new StringBuilder("Expected an int but was ");
    localStringBuilder.append(this.l);
    localStringBuilder.append(" at line ");
    localStringBuilder.append(this.g + 1);
    localStringBuilder.append(" column ");
    localStringBuilder.append(s());
    throw new NumberFormatException(localStringBuilder.toString());
  }
  
  public void o()
  {
    int i2 = 0;
    int i1;
    label323:
    label338:
    label355:
    do
    {
      i1 = this.i;
      int i3 = i1;
      if (i1 == 0) {
        i3 = g();
      }
      if (i3 == 3) {
        a(1);
      }
      for (;;)
      {
        i1 = i2 + 1;
        break label355;
        if (i3 != 1) {
          break;
        }
        a(3);
      }
      if (i3 == 4) {}
      for (this.o -= 1;; this.o -= 1)
      {
        i1 = i2 - 1;
        break label355;
        if (i3 != 2) {
          break;
        }
      }
      if ((i3 != 14) && (i3 != 10))
      {
        if ((i3 != 8) && (i3 != 12))
        {
          if ((i3 != 9) && (i3 != 13))
          {
            i1 = i2;
            if (i3 == 16)
            {
              this.e += this.k;
              i1 = i2;
            }
          }
          else
          {
            c('"');
            i1 = i2;
          }
        }
        else
        {
          c('\'');
          i1 = i2;
        }
      }
      else
      {
        do
        {
          i1 = 0;
          for (;;)
          {
            i3 = this.e;
            if (i3 + i1 >= this.f) {
              break label338;
            }
            i3 = this.d[(i3 + i1)];
            if ((i3 == 9) || (i3 == 10) || (i3 == 12) || (i3 == 13) || (i3 == 32)) {
              break label323;
            }
            if (i3 == 35) {
              break;
            }
            if (i3 == 44) {
              break label323;
            }
            if ((i3 == 47) || (i3 == 61)) {
              break;
            }
            if ((i3 == 123) || (i3 == 125) || (i3 == 58)) {
              break label323;
            }
            if (i3 == 59) {
              break;
            }
            switch (i3)
            {
            default: 
              i1 += 1;
            }
          }
          t();
          this.e += i1;
          i1 = i2;
          break;
          this.e = (i3 + i1);
        } while (b(1));
        i1 = i2;
      }
      this.i = 0;
      i2 = i1;
    } while (i1 != 0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append(" at line ");
    localStringBuilder.append(this.g + 1);
    localStringBuilder.append(" column ");
    localStringBuilder.append(s());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.fe
 * JD-Core Version:    0.7.0.1
 */