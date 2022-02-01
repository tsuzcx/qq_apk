package com.tencent.map.sdk.a;

public final class hk
{
  public int a;
  public int b;
  public int c;
  public String d;
  
  public final byte[] a()
  {
    byte[] arrayOfByte1 = new byte[''];
    System.arraycopy(pa.a(this.a), 0, arrayOfByte1, 0, 4);
    System.arraycopy(pa.a(this.b), 0, arrayOfByte1, 4, 4);
    System.arraycopy(pa.a(this.c), 0, arrayOfByte1, 8, 4);
    byte[] arrayOfByte2 = pa.a(this.d);
    if (arrayOfByte2.length < 32)
    {
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 12, arrayOfByte2.length);
      return arrayOfByte1;
    }
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 12, 32);
    return arrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.hk
 * JD-Core Version:    0.7.0.1
 */