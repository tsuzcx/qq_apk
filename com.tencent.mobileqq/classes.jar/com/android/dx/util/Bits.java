package com.android.dx.util;

public final class Bits
{
  public static boolean anyInRange(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    paramInt1 = findFirst(paramArrayOfInt, paramInt1);
    return (paramInt1 >= 0) && (paramInt1 < paramInt2);
  }
  
  public static int bitCount(int[] paramArrayOfInt)
  {
    int i = 0;
    int k = paramArrayOfInt.length;
    int j = 0;
    while (i < k)
    {
      j += Integer.bitCount(paramArrayOfInt[i]);
      i += 1;
    }
    return j;
  }
  
  public static void clear(int[] paramArrayOfInt, int paramInt)
  {
    int i = paramInt >> 5;
    paramArrayOfInt[i] = ((1 << (paramInt & 0x1F) ^ 0xFFFFFFFF) & paramArrayOfInt[i]);
  }
  
  public static int findFirst(int paramInt1, int paramInt2)
  {
    paramInt2 = Integer.numberOfTrailingZeros(((1 << paramInt2) - 1 ^ 0xFFFFFFFF) & paramInt1);
    paramInt1 = paramInt2;
    if (paramInt2 == 32) {
      paramInt1 = -1;
    }
    return paramInt1;
  }
  
  public static int findFirst(int[] paramArrayOfInt, int paramInt)
  {
    int j = paramArrayOfInt.length;
    int i = paramInt & 0x1F;
    paramInt >>= 5;
    while (paramInt < j)
    {
      int k = paramArrayOfInt[paramInt];
      if (k != 0)
      {
        i = findFirst(k, i);
        if (i >= 0) {
          return (paramInt << 5) + i;
        }
      }
      i = 0;
      paramInt += 1;
    }
    return -1;
  }
  
  public static boolean get(int[] paramArrayOfInt, int paramInt)
  {
    return (paramArrayOfInt[(paramInt >> 5)] & 1 << (paramInt & 0x1F)) != 0;
  }
  
  public static int getMax(int[] paramArrayOfInt)
  {
    return paramArrayOfInt.length * 32;
  }
  
  public static boolean isEmpty(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfInt[i] != 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static int[] makeBitSet(int paramInt)
  {
    return new int[paramInt + 31 >> 5];
  }
  
  public static void or(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = 0;
    while (i < paramArrayOfInt2.length)
    {
      paramArrayOfInt1[i] |= paramArrayOfInt2[i];
      i += 1;
    }
  }
  
  public static void set(int[] paramArrayOfInt, int paramInt)
  {
    int i = paramInt >> 5;
    paramArrayOfInt[i] = (1 << (paramInt & 0x1F) | paramArrayOfInt[i]);
  }
  
  public static void set(int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    int i = paramInt >> 5;
    paramInt = 1 << (paramInt & 0x1F);
    if (paramBoolean)
    {
      paramArrayOfInt[i] = (paramInt | paramArrayOfInt[i]);
      return;
    }
    paramArrayOfInt[i] = ((paramInt ^ 0xFFFFFFFF) & paramArrayOfInt[i]);
  }
  
  public static String toHuman(int[] paramArrayOfInt)
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('{');
    int m = paramArrayOfInt.length;
    int i = 0;
    while (i < m * 32)
    {
      int k = j;
      if (get(paramArrayOfInt, i))
      {
        if (j != 0) {
          localStringBuilder.append(',');
        }
        k = 1;
        localStringBuilder.append(i);
      }
      i += 1;
      j = k;
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.util.Bits
 * JD-Core Version:    0.7.0.1
 */