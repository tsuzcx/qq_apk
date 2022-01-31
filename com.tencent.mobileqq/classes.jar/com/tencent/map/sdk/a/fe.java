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
    if (paramReader == null) {
      throw new NullPointerException("in == null");
    }
    this.c = paramReader;
  }
  
  private int a(boolean paramBoolean)
  {
    char[] arrayOfChar = this.d;
    int i1 = this.e;
    int i2 = this.f;
    for (;;)
    {
      int i3 = i2;
      int i4 = i1;
      if (i1 == i2)
      {
        this.e = i1;
        if (b(1))
        {
          i4 = this.e;
          i3 = this.f;
        }
      }
      else
      {
        i1 = i4 + 1;
        i2 = arrayOfChar[i4];
        if (i2 == 10)
        {
          this.g += 1;
          this.h = i1;
          i2 = i3;
          continue;
        }
        if ((i2 == 32) || (i2 == 13) || (i2 == 9)) {
          break label352;
        }
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
          switch (arrayOfChar[this.e])
          {
          default: 
            return i2;
          case '*': 
            this.e += 1;
            if (!a("*/")) {
              throw b("Unterminated comment");
            }
            i1 = this.e + 2;
            i2 = this.f;
            break;
          case '/': 
            this.e += 1;
            u();
            i1 = this.e;
            i2 = this.f;
            break;
          }
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
      if (paramBoolean) {
        throw new EOFException("End of input at line " + (this.g + 1) + " column " + s());
      }
      return -1;
      label352:
      i2 = i3;
    }
  }
  
  private void a(int paramInt)
  {
    if (this.o == this.n.length)
    {
      arrayOfInt = new int[this.o * 2];
      System.arraycopy(this.n, 0, arrayOfInt, 0, this.o);
      this.n = arrayOfInt;
    }
    int[] arrayOfInt = this.n;
    int i1 = this.o;
    this.o = (i1 + 1);
    arrayOfInt[i1] = paramInt;
  }
  
  private boolean a(char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return true;
    case '#': 
    case '/': 
    case ';': 
    case '=': 
    case '\\': 
      t();
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    for (;;)
    {
      if (this.e + paramString.length() > this.f)
      {
        bool1 = bool2;
        if (!b(paramString.length())) {
          return bool1;
        }
      }
      if (this.d[this.e] != '\n') {
        break;
      }
      this.g += 1;
      this.h = (this.e + 1);
      this.e += 1;
    }
    int i1 = 0;
    for (;;)
    {
      if (i1 >= paramString.length()) {
        break label116;
      }
      if (this.d[(this.e + i1)] != paramString.charAt(i1)) {
        break;
      }
      i1 += 1;
    }
    label116:
    boolean bool1 = true;
    return bool1;
  }
  
  private IOException b(String paramString)
  {
    throw new fh(paramString + " at line " + (this.g + 1) + " column " + s());
  }
  
  private String b(char paramChar)
  {
    char[] arrayOfChar = this.d;
    Object localObject1 = null;
    int i1 = 0;
    label212:
    do
    {
      char c3 = this.e;
      int i2 = this.f;
      char c1 = c3;
      for (;;)
      {
        if (c1 >= i2) {
          break label212;
        }
        char c2 = c1 + '\001';
        c1 = arrayOfChar[c1];
        if (c1 == paramChar)
        {
          this.e = c2;
          if (localObject1 == null) {
            return m.a(arrayOfChar, c3, c2 - c3 - 1, i1);
          }
          localObject1.append(arrayOfChar, c3, c2 - c3 - 1);
          return localObject1.toString();
        }
        if (c1 == '\\')
        {
          this.e = c2;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new StringBuilder();
          }
          ((StringBuilder)localObject2).append(arrayOfChar, c3, c2 - c3 - 1);
          ((StringBuilder)localObject2).append(v());
          localObject1 = localObject2;
          break;
        }
        if (c1 == '\n')
        {
          i1 = i1 * 31 + c1;
          this.g += 1;
          this.h = c2;
          c1 = c2;
        }
        else
        {
          i1 = i1 * 31 + c1;
          c1 = c2;
        }
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuilder();
      }
      ((StringBuilder)localObject2).append(arrayOfChar, c3, c1 - c3);
      this.e = c1;
      localObject1 = localObject2;
    } while (b(1));
    throw b("Unterminated string");
  }
  
  private boolean b(int paramInt)
  {
    boolean bool2 = false;
    char[] arrayOfChar = this.d;
    this.h -= this.e;
    if (this.f != this.e)
    {
      this.f -= this.e;
      System.arraycopy(arrayOfChar, this.e, arrayOfChar, 0, this.f);
    }
    for (;;)
    {
      this.e = 0;
      int i1;
      do
      {
        i1 = this.c.read(arrayOfChar, this.f, arrayOfChar.length - this.f);
        bool1 = bool2;
        if (i1 == -1) {
          break;
        }
        this.f = (i1 + this.f);
        i1 = paramInt;
        if (this.g == 0)
        {
          i1 = paramInt;
          if (this.h == 0)
          {
            i1 = paramInt;
            if (this.f > 0)
            {
              i1 = paramInt;
              if (arrayOfChar[0] == 65279)
              {
                this.e += 1;
                this.h += 1;
                i1 = paramInt + 1;
              }
            }
          }
        }
        paramInt = i1;
      } while (this.f < i1);
      boolean bool1 = true;
      return bool1;
      this.f = 0;
    }
  }
  
  private void c(char paramChar)
  {
    char[] arrayOfChar = this.d;
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
        c1 = arrayOfChar[c1];
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
    throw b("Unterminated string");
  }
  
  private int g()
  {
    int i1 = this.n[(this.o - 1)];
    if (i1 == 1)
    {
      this.n[(this.o - 1)] = 2;
      switch (a(true))
      {
      default: 
        this.e -= 1;
        if (this.o == 1) {
          t();
        }
        i1 = p();
        if (i1 == 0) {
          break;
        }
      }
    }
    int i2;
    do
    {
      return i1;
      if (i1 == 2)
      {
        switch (a(true))
        {
        case 44: 
        default: 
          throw b("Unterminated array");
        case 93: 
          this.i = 4;
          return 4;
        }
        t();
        break;
      }
      if ((i1 == 3) || (i1 == 5))
      {
        this.n[(this.o - 1)] = 4;
        if (i1 == 5) {
          switch (a(true))
          {
          default: 
            throw b("Unterminated object");
          case 125: 
            this.i = 2;
            return 2;
          case 59: 
            t();
          }
        }
        i2 = a(true);
        switch (i2)
        {
        default: 
          t();
          this.e -= 1;
          if (a((char)i2))
          {
            this.i = 14;
            return 14;
          }
          break;
        case 34: 
          this.i = 13;
          return 13;
        case 39: 
          t();
          this.i = 12;
          return 12;
        case 125: 
          if (i1 != 5)
          {
            this.i = 2;
            return 2;
          }
          throw b("Expected name");
        }
        throw b("Expected name");
      }
      if (i1 == 4)
      {
        this.n[(this.o - 1)] = 5;
        switch (a(true))
        {
        case 58: 
        case 59: 
        case 60: 
        default: 
          throw b("Expected ':'");
        }
        t();
        if (((this.e >= this.f) && (!b(1))) || (this.d[this.e] != '>')) {
          break;
        }
        this.e += 1;
        break;
      }
      if (i1 == 6)
      {
        if (this.b) {
          w();
        }
        this.n[(this.o - 1)] = 7;
        break;
      }
      if (i1 == 7)
      {
        if (a(false) == -1)
        {
          this.i = 17;
          return 17;
        }
        t();
        this.e -= 1;
        break;
      }
      if (i1 != 8) {
        break;
      }
      throw new IllegalStateException("JsonReader is closed");
      if (i1 == 1)
      {
        this.i = 4;
        return 4;
      }
      if ((i1 == 1) || (i1 == 2))
      {
        t();
        this.e -= 1;
        this.i = 7;
        return 7;
      }
      throw b("Unexpected value");
      t();
      this.i = 8;
      return 8;
      if (this.o == 1) {
        t();
      }
      this.i = 9;
      return 9;
      this.i = 3;
      return 3;
      this.i = 1;
      return 1;
      i2 = q();
      i1 = i2;
    } while (i2 != 0);
    if (!a(this.d[this.e])) {
      throw b("Expected value");
    }
    t();
    this.i = 10;
    return 10;
  }
  
  private int p()
  {
    int i1 = this.d[this.e];
    String str2;
    String str1;
    int i3;
    int i2;
    if ((i1 == 116) || (i1 == 84))
    {
      str2 = "true";
      str1 = "TRUE";
      i1 = 5;
      i3 = str2.length();
      i2 = 1;
    }
    for (;;)
    {
      if (i2 >= i3) {
        break label168;
      }
      if ((this.e + i2 >= this.f) && (!b(i2 + 1)))
      {
        return 0;
        if ((i1 == 102) || (i1 == 70))
        {
          str2 = "false";
          str1 = "FALSE";
          i1 = 6;
          break;
        }
        if ((i1 == 110) || (i1 == 78))
        {
          str2 = "null";
          str1 = "NULL";
          i1 = 7;
          break;
        }
        return 0;
      }
      int i4 = this.d[(this.e + i2)];
      if ((i4 != str2.charAt(i2)) && (i4 != str1.charAt(i2))) {
        return 0;
      }
      i2 += 1;
    }
    label168:
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
    int i7 = this.e;
    int i5 = this.f;
    long l1 = 0L;
    int i1 = 0;
    int i2 = 1;
    int i3 = 0;
    int i4 = 0;
    int i8 = i5;
    int i6 = i8;
    i5 = i7;
    char c1;
    if (i7 + i4 == i8)
    {
      if (i4 == arrayOfChar.length) {
        return 0;
      }
      if (b(i4 + 1))
      {
        i5 = this.e;
        i6 = this.f;
      }
    }
    else
    {
      c1 = arrayOfChar[(i5 + i4)];
      switch (c1)
      {
      default: 
        if ((c1 < '0') || (c1 > '9'))
        {
          if (!a(c1)) {
            break label460;
          }
          return 0;
        }
        break;
      case '-': 
        if (i3 == 0)
        {
          i1 = 1;
          i3 = 1;
        }
        break;
      }
    }
    for (;;)
    {
      int i9 = i4 + 1;
      i4 = i3;
      i8 = i6;
      i7 = i5;
      i3 = i1;
      i1 = i4;
      i4 = i9;
      break;
      if (i3 == 5)
      {
        i7 = 6;
        i3 = i1;
        i1 = i7;
      }
      else
      {
        return 0;
        if (i3 == 5)
        {
          i7 = 6;
          i3 = i1;
          i1 = i7;
        }
        else
        {
          return 0;
          if ((i3 == 2) || (i3 == 4))
          {
            i7 = 5;
            i3 = i1;
            i1 = i7;
          }
          else
          {
            return 0;
            if (i3 == 2)
            {
              i7 = 3;
              i3 = i1;
              i1 = i7;
            }
            else
            {
              return 0;
              if ((i3 == 1) || (i3 == 0))
              {
                l1 = -(c1 - '0');
                i7 = 2;
                i3 = i1;
                i1 = i7;
              }
              else
              {
                if (i3 == 2)
                {
                  if (l1 == 0L) {
                    return 0;
                  }
                  long l2 = 10L * l1 - (c1 - '0');
                  if ((l1 > -922337203685477580L) || ((l1 == -922337203685477580L) && (l2 < l1))) {}
                  for (i8 = 1;; i8 = 0)
                  {
                    i7 = i1;
                    l1 = l2;
                    i2 = i8 & i2;
                    i1 = i3;
                    i3 = i7;
                    break;
                  }
                }
                if (i3 == 3)
                {
                  i7 = 4;
                  i3 = i1;
                  i1 = i7;
                }
                else if ((i3 == 5) || (i3 == 6))
                {
                  i7 = 7;
                  i3 = i1;
                  i1 = i7;
                  continue;
                  label460:
                  if ((i3 == 2) && (i2 != 0) && ((l1 != -9223372036854775808L) || (i1 != 0)))
                  {
                    if (i1 != 0) {}
                    for (;;)
                    {
                      this.j = l1;
                      this.e += i4;
                      this.i = 15;
                      return 15;
                      l1 = -l1;
                    }
                  }
                  if ((i3 == 2) || (i3 == 4) || (i3 == 7))
                  {
                    this.k = i4;
                    this.i = 16;
                    return 16;
                  }
                  return 0;
                }
                else
                {
                  i7 = i1;
                  i1 = i3;
                  i3 = i7;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private String r()
  {
    Object localObject1 = null;
    int i1 = 0;
    for (;;)
    {
      Object localObject2;
      int i2;
      if (this.e + i1 < this.f)
      {
        localObject2 = localObject1;
        i2 = i1;
        switch (this.d[(this.e + i1)])
        {
        default: 
          i1 += 1;
          break;
        case '#': 
        case '/': 
        case ';': 
        case '=': 
        case '\\': 
          t();
          i2 = i1;
          localObject2 = localObject1;
        case '\t': 
        case '\n': 
        case '\f': 
        case '\r': 
        case ' ': 
        case ',': 
        case ':': 
        case '[': 
        case ']': 
        case '{': 
        case '}': 
          label188:
          if (localObject2 != null) {}
          break;
        }
      }
      else
      {
        for (localObject1 = new String(this.d, this.e, i2);; localObject1 = ((StringBuilder)localObject2).toString())
        {
          this.e = (i2 + this.e);
          return localObject1;
          if (i1 < this.d.length)
          {
            localObject2 = localObject1;
            i2 = i1;
            if (!b(i1 + 1)) {
              break label188;
            }
            break;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new StringBuilder();
          }
          ((StringBuilder)localObject2).append(this.d, this.e, i1);
          this.e = (i1 + this.e);
          if (b(1)) {
            break label327;
          }
          i2 = 0;
          break label188;
          ((StringBuilder)localObject2).append(this.d, this.e, i2);
        }
        label327:
        i1 = 0;
        localObject1 = localObject2;
      }
    }
  }
  
  private int s()
  {
    return this.e - this.h + 1;
  }
  
  private void t()
  {
    if (!this.b) {
      throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
    }
  }
  
  private void u()
  {
    int i1;
    do
    {
      if ((this.e < this.f) || (b(1)))
      {
        char[] arrayOfChar = this.d;
        i1 = this.e;
        this.e = (i1 + 1);
        i1 = arrayOfChar[i1];
        if (i1 == 10)
        {
          this.g += 1;
          this.h = this.e;
        }
      }
      else
      {
        return;
      }
    } while (i1 != 13);
  }
  
  private char v()
  {
    if ((this.e == this.f) && (!b(1))) {
      throw b("Unterminated escape sequence");
    }
    char[] arrayOfChar = this.d;
    int i1 = this.e;
    this.e = (i1 + 1);
    char c1 = arrayOfChar[i1];
    switch (c1)
    {
    default: 
      return c1;
    case 'u': 
      if ((this.e + 4 > this.f) && (!b(4))) {
        throw b("Unterminated escape sequence");
      }
      int i2 = this.e;
      c1 = '\000';
      i1 = i2;
      if (i1 < i2 + 4)
      {
        int i3 = this.d[i1];
        int i4 = (char)(c1 << '\004');
        if ((i3 >= 48) && (i3 <= 57)) {
          c1 = (char)(i4 + (i3 - 48));
        }
        for (;;)
        {
          i1 += 1;
          break;
          if ((i3 >= 97) && (i3 <= 102))
          {
            c1 = (char)(i4 + (i3 - 97 + 10));
          }
          else
          {
            if ((i3 < 65) || (i3 > 70)) {
              break label267;
            }
            c1 = (char)(i4 + (i3 - 65 + 10));
          }
        }
        throw new NumberFormatException("\\u" + new String(this.d, this.e, 4));
      }
      this.e += 4;
      return c1;
    case 't': 
      return '\t';
    case 'b': 
      return '\b';
    case 'n': 
      return '\n';
    case 'r': 
      return '\r';
    case 'f': 
      label267:
      return '\f';
    }
    this.g += 1;
    this.h = this.e;
    return c1;
  }
  
  private void w()
  {
    a(true);
    this.e -= 1;
    if ((this.e + a.length > this.f) && (!b(a.length))) {
      return;
    }
    int i1 = 0;
    for (;;)
    {
      if (i1 >= a.length) {
        break label80;
      }
      if (this.d[(this.e + i1)] != a[i1]) {
        break;
      }
      i1 += 1;
    }
    label80:
    this.e += a.length;
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
    throw new IllegalStateException("Expected BEGIN_ARRAY but was " + f() + " at line " + (this.g + 1) + " column " + s());
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
    throw new IllegalStateException("Expected END_ARRAY but was " + f() + " at line " + (this.g + 1) + " column " + s());
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
    throw new IllegalStateException("Expected BEGIN_OBJECT but was " + f() + " at line " + (this.g + 1) + " column " + s());
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
    throw new IllegalStateException("Expected END_OBJECT but was " + f() + " at line " + (this.g + 1) + " column " + s());
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
    case 1: 
      return ff.c;
    case 2: 
      return ff.d;
    case 3: 
      return ff.a;
    case 4: 
      return ff.b;
    case 12: 
    case 13: 
    case 14: 
      return ff.e;
    case 5: 
    case 6: 
      return ff.h;
    case 7: 
      return ff.i;
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      return ff.f;
    case 15: 
    case 16: 
      return ff.g;
    }
    return ff.j;
  }
  
  public String h()
  {
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = g();
    }
    String str;
    if (i1 == 14) {
      str = r();
    }
    for (;;)
    {
      this.i = 0;
      return str;
      if (i1 == 12)
      {
        str = b('\'');
      }
      else
      {
        if (i1 != 13) {
          break;
        }
        str = b('"');
      }
    }
    throw new IllegalStateException("Expected a name but was " + f() + " at line " + (this.g + 1) + " column " + s());
  }
  
  public String i()
  {
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = g();
    }
    String str;
    if (i1 == 10) {
      str = r();
    }
    for (;;)
    {
      this.i = 0;
      return str;
      if (i1 == 8)
      {
        str = b('\'');
      }
      else if (i1 == 9)
      {
        str = b('"');
      }
      else if (i1 == 11)
      {
        str = this.l;
        this.l = null;
      }
      else if (i1 == 15)
      {
        str = Long.toString(this.j);
      }
      else
      {
        if (i1 != 16) {
          break;
        }
        str = new String(this.d, this.e, this.k);
        this.e += this.k;
      }
    }
    throw new IllegalStateException("Expected a string but was " + f() + " at line " + (this.g + 1) + " column " + s());
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
    throw new IllegalStateException("Expected a boolean but was " + f() + " at line " + (this.g + 1) + " column " + s());
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
    throw new IllegalStateException("Expected null but was " + f() + " at line " + (this.g + 1) + " column " + s());
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
    if (i1 == 16)
    {
      this.l = new String(this.d, this.e, this.k);
      this.e += this.k;
    }
    double d1;
    do
    {
      for (;;)
      {
        this.i = 11;
        d1 = Double.parseDouble(this.l);
        if ((this.b) || ((!Double.isNaN(d1)) && (!Double.isInfinite(d1)))) {
          break label289;
        }
        throw new fh("JSON forbids NaN and infinities: " + d1 + " at line " + (this.g + 1) + " column " + s());
        if ((i1 == 8) || (i1 == 9))
        {
          if (i1 == 8) {}
          for (char c1 = '\'';; c1 = '"')
          {
            this.l = b(c1);
            break;
          }
        }
        if (i1 != 10) {
          break;
        }
        this.l = r();
      }
    } while (i1 == 11);
    throw new IllegalStateException("Expected a double but was " + f() + " at line " + (this.g + 1) + " column " + s());
    label289:
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
    long l1;
    if (i1 == 16)
    {
      this.l = new String(this.d, this.e, this.k);
      this.e += this.k;
      this.i = 11;
      double d1 = Double.parseDouble(this.l);
      l1 = d1;
      if (l1 != d1) {
        throw new NumberFormatException("Expected a long but was " + this.l + " at line " + (this.g + 1) + " column " + s());
      }
    }
    else
    {
      if ((i1 == 8) || (i1 == 9))
      {
        if (i1 == 8) {}
        for (char c1 = '\'';; c1 = '"')
        {
          this.l = b(c1);
          try
          {
            l1 = Long.parseLong(this.l);
            this.i = 0;
            return l1;
          }
          catch (NumberFormatException localNumberFormatException) {}
          break;
        }
      }
      throw new IllegalStateException("Expected a long but was " + f() + " at line " + (this.g + 1) + " column " + s());
    }
    this.l = null;
    this.i = 0;
    return l1;
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
      i1 = (int)this.j;
      if (this.j != i1) {
        throw new NumberFormatException("Expected an int but was " + this.j + " at line " + (this.g + 1) + " column " + s());
      }
      this.i = 0;
      return i1;
    }
    if (i1 == 16)
    {
      this.l = new String(this.d, this.e, this.k);
      this.e += this.k;
      this.i = 11;
      double d1 = Double.parseDouble(this.l);
      i1 = (int)d1;
      if (i1 != d1) {
        throw new NumberFormatException("Expected an int but was " + this.l + " at line " + (this.g + 1) + " column " + s());
      }
    }
    else
    {
      if ((i1 == 8) || (i1 == 9))
      {
        if (i1 == 8) {}
        for (char c1 = '\'';; c1 = '"')
        {
          this.l = b(c1);
          try
          {
            i1 = Integer.parseInt(this.l);
            this.i = 0;
            return i1;
          }
          catch (NumberFormatException localNumberFormatException) {}
          break;
        }
      }
      throw new IllegalStateException("Expected an int but was " + f() + " at line " + (this.g + 1) + " column " + s());
    }
    this.l = null;
    this.i = 0;
    return i1;
  }
  
  public void o()
  {
    int i2 = 0;
    int i1 = this.i;
    int i3 = i1;
    if (i1 == 0) {
      i3 = g();
    }
    if (i3 == 3)
    {
      a(1);
      i1 = i2 + 1;
    }
    for (;;)
    {
      label32:
      this.i = 0;
      i2 = i1;
      if (i1 != 0) {
        break;
      }
      return;
      if (i3 == 1)
      {
        a(3);
        i1 = i2 + 1;
      }
      else if (i3 == 4)
      {
        this.o -= 1;
        i1 = i2 - 1;
      }
      else if (i3 == 2)
      {
        this.o -= 1;
        i1 = i2 - 1;
      }
      else if ((i3 == 14) || (i3 == 10))
      {
        do
        {
          i1 = 0;
          for (;;)
          {
            if (this.e + i1 < this.f) {
              switch (this.d[(this.e + i1)])
              {
              default: 
                i1 += 1;
                break;
              case '#': 
              case '/': 
              case ';': 
              case '=': 
              case '\\': 
                t();
              case '\t': 
              case '\n': 
              case '\f': 
              case '\r': 
              case ' ': 
              case ',': 
              case ':': 
              case '[': 
              case ']': 
              case '{': 
              case '}': 
                this.e = (i1 + this.e);
                i1 = i2;
                break label32;
              }
            }
          }
          this.e = (i1 + this.e);
        } while (b(1));
        i1 = i2;
      }
      else if ((i3 == 8) || (i3 == 12))
      {
        c('\'');
        i1 = i2;
      }
      else if ((i3 == 9) || (i3 == 13))
      {
        c('"');
        i1 = i2;
      }
      else
      {
        i1 = i2;
        if (i3 == 16)
        {
          this.e += this.k;
          i1 = i2;
        }
      }
    }
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + " at line " + (this.g + 1) + " column " + s();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.fe
 * JD-Core Version:    0.7.0.1
 */