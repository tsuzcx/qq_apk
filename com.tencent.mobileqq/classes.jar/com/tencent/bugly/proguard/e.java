package com.tencent.bugly.proguard;

public final class e
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      char[] arrayOfChar1 = new char[paramArrayOfByte.length * 2];
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        int j = paramArrayOfByte[i];
        int k = i * 2;
        char[] arrayOfChar2 = a;
        arrayOfChar1[(k + 1)] = arrayOfChar2[(j & 0xF)];
        arrayOfChar1[k] = arrayOfChar2[((byte)(j >>> 4) & 0xF)];
        i += 1;
      }
      return new String(arrayOfChar1);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.bugly.proguard.e
 * JD-Core Version:    0.7.0.1
 */