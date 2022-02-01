package com.android.dx.util;

public final class Hex
{
  public static String dump(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = paramInt1 + paramInt2;
    if (((paramInt1 | paramInt2 | i) < 0) || (i > paramArrayOfByte.length)) {
      throw new IndexOutOfBoundsException("arr.length " + paramArrayOfByte.length + "; " + paramInt1 + "..!" + i);
    }
    if (paramInt3 < 0) {
      throw new IllegalArgumentException("outOffset < 0");
    }
    if (paramInt2 == 0) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer(paramInt2 * 4 + 6);
    int j = 0;
    i = paramInt3;
    paramInt3 = paramInt1;
    paramInt1 = j;
    if (paramInt2 > 0)
    {
      String str;
      if (paramInt1 == 0) {
        switch (paramInt5)
        {
        case 3: 
        case 5: 
        default: 
          str = u4(i);
          label167:
          localStringBuffer.append(str);
          localStringBuffer.append(": ");
        }
      }
      for (;;)
      {
        localStringBuffer.append(u1(paramArrayOfByte[paramInt3]));
        i += 1;
        paramInt3 += 1;
        j = paramInt1 + 1;
        paramInt1 = j;
        if (j == paramInt4)
        {
          localStringBuffer.append('\n');
          paramInt1 = 0;
        }
        paramInt2 -= 1;
        break;
        str = u1(i);
        break label167;
        str = u2(i);
        break label167;
        str = u3(i);
        break label167;
        if ((paramInt1 & 0x1) == 0) {
          localStringBuffer.append(' ');
        }
      }
    }
    if (paramInt1 != 0) {
      localStringBuffer.append('\n');
    }
    return localStringBuffer.toString();
  }
  
  public static String s1(int paramInt)
  {
    int i = 0;
    char[] arrayOfChar = new char[3];
    if (paramInt < 0)
    {
      arrayOfChar[0] = '-';
      paramInt = -paramInt;
    }
    while (i < 2)
    {
      arrayOfChar[(2 - i)] = Character.forDigit(paramInt & 0xF, 16);
      paramInt >>= 4;
      i += 1;
      continue;
      arrayOfChar[0] = '+';
    }
    return new String(arrayOfChar);
  }
  
  public static String s2(int paramInt)
  {
    int i = 0;
    char[] arrayOfChar = new char[5];
    if (paramInt < 0)
    {
      arrayOfChar[0] = '-';
      paramInt = -paramInt;
    }
    while (i < 4)
    {
      arrayOfChar[(4 - i)] = Character.forDigit(paramInt & 0xF, 16);
      paramInt >>= 4;
      i += 1;
      continue;
      arrayOfChar[0] = '+';
    }
    return new String(arrayOfChar);
  }
  
  public static String s4(int paramInt)
  {
    int i = 0;
    char[] arrayOfChar = new char[9];
    if (paramInt < 0)
    {
      arrayOfChar[0] = '-';
      paramInt = -paramInt;
    }
    while (i < 8)
    {
      arrayOfChar[(8 - i)] = Character.forDigit(paramInt & 0xF, 16);
      paramInt >>= 4;
      i += 1;
      continue;
      arrayOfChar[0] = '+';
    }
    return new String(arrayOfChar);
  }
  
  public static String s8(long paramLong)
  {
    int i = 0;
    char[] arrayOfChar = new char[17];
    if (paramLong < 0L)
    {
      arrayOfChar[0] = '-';
      paramLong = -paramLong;
    }
    while (i < 16)
    {
      arrayOfChar[(16 - i)] = Character.forDigit((int)paramLong & 0xF, 16);
      paramLong >>= 4;
      i += 1;
      continue;
      arrayOfChar[0] = '+';
    }
    return new String(arrayOfChar);
  }
  
  public static String u1(int paramInt)
  {
    char[] arrayOfChar = new char[2];
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < 2)
    {
      arrayOfChar[(1 - paramInt)] = Character.forDigit(i & 0xF, 16);
      i >>= 4;
      paramInt += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static String u2(int paramInt)
  {
    char[] arrayOfChar = new char[4];
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < 4)
    {
      arrayOfChar[(3 - paramInt)] = Character.forDigit(i & 0xF, 16);
      i >>= 4;
      paramInt += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static String u2or4(int paramInt)
  {
    if (paramInt == (char)paramInt) {
      return u2(paramInt);
    }
    return u4(paramInt);
  }
  
  public static String u3(int paramInt)
  {
    char[] arrayOfChar = new char[6];
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < 6)
    {
      arrayOfChar[(5 - paramInt)] = Character.forDigit(i & 0xF, 16);
      i >>= 4;
      paramInt += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static String u4(int paramInt)
  {
    char[] arrayOfChar = new char[8];
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < 8)
    {
      arrayOfChar[(7 - paramInt)] = Character.forDigit(i & 0xF, 16);
      i >>= 4;
      paramInt += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static String u8(long paramLong)
  {
    char[] arrayOfChar = new char[16];
    int i = 0;
    while (i < 16)
    {
      arrayOfChar[(15 - i)] = Character.forDigit((int)paramLong & 0xF, 16);
      paramLong >>= 4;
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static String uNibble(int paramInt)
  {
    return new String(new char[] { Character.forDigit(paramInt & 0xF, 16) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.util.Hex
 * JD-Core Version:    0.7.0.1
 */