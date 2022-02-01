package com.android.dx.rop.cst;

import com.android.dx.rop.type.Type;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;

public final class CstString
  extends TypedConstant
{
  public static final CstString EMPTY_STRING = new CstString("");
  private final ByteArray bytes;
  private final String string;
  
  public CstString(ByteArray paramByteArray)
  {
    if (paramByteArray == null) {
      throw new NullPointerException("bytes == null");
    }
    this.bytes = paramByteArray;
    this.string = utf8BytesToString(paramByteArray).intern();
  }
  
  public CstString(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("string == null");
    }
    this.string = paramString.intern();
    this.bytes = new ByteArray(stringToUtf8Bytes(paramString));
  }
  
  public static byte[] stringToUtf8Bytes(String paramString)
  {
    int k = paramString.length();
    byte[] arrayOfByte = new byte[k * 3];
    int j = 0;
    int i = 0;
    if (j < k)
    {
      int m = paramString.charAt(j);
      if ((m != 0) && (m < 128))
      {
        arrayOfByte[i] = ((byte)m);
        i += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        if (m < 2048)
        {
          arrayOfByte[i] = ((byte)(m >> 6 & 0x1F | 0xC0));
          arrayOfByte[(i + 1)] = ((byte)(m & 0x3F | 0x80));
          i += 2;
        }
        else
        {
          arrayOfByte[i] = ((byte)(m >> 12 & 0xF | 0xE0));
          arrayOfByte[(i + 1)] = ((byte)(m >> 6 & 0x3F | 0x80));
          arrayOfByte[(i + 2)] = ((byte)(m & 0x3F | 0x80));
          i += 3;
        }
      }
    }
    paramString = new byte[i];
    System.arraycopy(arrayOfByte, 0, paramString, 0, i);
    return paramString;
  }
  
  private static String throwBadUtf8(int paramInt1, int paramInt2)
  {
    throw new IllegalArgumentException("bad utf-8 byte " + Hex.u1(paramInt1) + " at offset " + Hex.u4(paramInt2));
  }
  
  public static String utf8BytesToString(ByteArray paramByteArray)
  {
    int k = paramByteArray.size();
    char[] arrayOfChar = new char[k];
    int j = 0;
    int m = 0;
    if (k > 0)
    {
      int n = paramByteArray.getUnsignedByte(j);
      int i;
      switch (n >> 4)
      {
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      default: 
        return throwBadUtf8(n, j);
      case 0: 
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
        k -= 1;
        if (n == 0) {
          return throwBadUtf8(n, j);
        }
        i = (char)n;
        j += 1;
      }
      for (;;)
      {
        arrayOfChar[m] = i;
        m += 1;
        break;
        k -= 2;
        if (k < 0) {
          return throwBadUtf8(n, j);
        }
        int i1 = paramByteArray.getUnsignedByte(j + 1);
        if ((i1 & 0xC0) != 128) {
          return throwBadUtf8(i1, j + 1);
        }
        n = (n & 0x1F) << 6 | i1 & 0x3F;
        if ((n != 0) && (n < 128)) {
          return throwBadUtf8(i1, j + 1);
        }
        i = (char)n;
        j += 2;
        continue;
        k -= 3;
        if (k < 0) {
          return throwBadUtf8(n, j);
        }
        int i2 = paramByteArray.getUnsignedByte(j + 1);
        if ((i2 & 0xC0) != 128) {
          return throwBadUtf8(i2, j + 1);
        }
        i1 = paramByteArray.getUnsignedByte(j + 2);
        if ((i2 & 0xC0) != 128) {
          return throwBadUtf8(i1, j + 2);
        }
        n = (n & 0xF) << 12 | (i2 & 0x3F) << 6 | i1 & 0x3F;
        if (n < 2048) {
          return throwBadUtf8(i1, j + 2);
        }
        i = (char)n;
        j += 3;
      }
    }
    return new String(arrayOfChar, 0, m);
  }
  
  protected int compareTo0(Constant paramConstant)
  {
    return this.string.compareTo(((CstString)paramConstant).string);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof CstString)) {
      return false;
    }
    return this.string.equals(((CstString)paramObject).string);
  }
  
  public ByteArray getBytes()
  {
    return this.bytes;
  }
  
  public String getString()
  {
    return this.string;
  }
  
  public Type getType()
  {
    return Type.STRING;
  }
  
  public int getUtf16Size()
  {
    return this.string.length();
  }
  
  public int getUtf8Size()
  {
    return this.bytes.size();
  }
  
  public int hashCode()
  {
    return this.string.hashCode();
  }
  
  public boolean isCategory2()
  {
    return false;
  }
  
  public String toHuman()
  {
    int n = this.string.length();
    StringBuilder localStringBuilder = new StringBuilder(n * 3 / 2);
    int j = 0;
    if (j < n)
    {
      char c1 = this.string.charAt(j);
      if ((c1 >= ' ') && (c1 < ''))
      {
        if ((c1 == '\'') || (c1 == '"') || (c1 == '\\')) {
          localStringBuilder.append('\\');
        }
        localStringBuilder.append(c1);
      }
      for (;;)
      {
        j += 1;
        break;
        if (c1 <= '')
        {
          switch (c1)
          {
          case '\013': 
          case '\f': 
          default: 
            if (j < n - 1)
            {
              i = this.string.charAt(j + 1);
              label161:
              if ((i < 48) || (i > 55)) {
                break label277;
              }
            }
            break;
          }
          label277:
          for (int i = 1;; i = 0)
          {
            localStringBuilder.append('\\');
            char c3 = '\006';
            while (c3 >= 0)
            {
              char c2 = (char)((c1 >> c3 & 0x7) + 48);
              int m;
              if (c2 == '0')
              {
                m = i;
                if (i == 0) {}
              }
              else
              {
                localStringBuilder.append(c2);
                m = 1;
              }
              int k;
              c3 -= '\003';
              i = m;
            }
            localStringBuilder.append("\\n");
            break;
            localStringBuilder.append("\\r");
            break;
            localStringBuilder.append("\\t");
            break;
            i = 0;
            break label161;
          }
          if (i == 0) {
            localStringBuilder.append('0');
          }
        }
        else
        {
          localStringBuilder.append("\\u");
          localStringBuilder.append(Character.forDigit(c1 >> '\f', 16));
          localStringBuilder.append(Character.forDigit(c1 >> '\b' & 0xF, 16));
          localStringBuilder.append(Character.forDigit(c1 >> '\004' & 0xF, 16));
          localStringBuilder.append(Character.forDigit(c1 & 0xF, 16));
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public String toQuoted()
  {
    return '"' + toHuman() + '"';
  }
  
  public String toQuoted(int paramInt)
  {
    String str2 = toHuman();
    if (str2.length() <= paramInt - 2) {}
    for (String str1 = "";; str1 = "...")
    {
      return '"' + str2 + str1 + '"';
      str2 = str2.substring(0, paramInt - 5);
    }
  }
  
  public String toString()
  {
    return "string{\"" + toHuman() + "\"}";
  }
  
  public String typeName()
  {
    return "utf8";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.CstString
 * JD-Core Version:    0.7.0.1
 */