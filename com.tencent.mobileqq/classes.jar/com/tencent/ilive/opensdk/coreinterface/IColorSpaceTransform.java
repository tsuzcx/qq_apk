package com.tencent.ilive.opensdk.coreinterface;

public abstract interface IColorSpaceTransform
{
  public abstract long getPTS();
  
  public abstract int i420ToNV12(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public abstract int i420ToRGBA(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public abstract int nv21Toi420Rotate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract int rgba2I420(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.opensdk.coreinterface.IColorSpaceTransform
 * JD-Core Version:    0.7.0.1
 */