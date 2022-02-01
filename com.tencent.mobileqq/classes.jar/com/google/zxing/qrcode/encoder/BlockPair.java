package com.google.zxing.qrcode.encoder;

final class BlockPair
{
  private final byte[] a;
  private final byte[] b;
  
  BlockPair(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.a = paramArrayOfByte1;
    this.b = paramArrayOfByte2;
  }
  
  public byte[] a()
  {
    return this.a;
  }
  
  public byte[] b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.zxing.qrcode.encoder.BlockPair
 * JD-Core Version:    0.7.0.1
 */