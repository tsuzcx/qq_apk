package com.tencent.common;

public class PileMp4Decoder
{
  private int mHandler;
  
  static
  {
    System.loadLibrary("getframe");
  }
  
  public PileMp4Decoder(String paramString)
  {
    this.mHandler = initDecoder(paramString);
  }
  
  public static native int getFrameFromPileMp4(int paramInt, byte[] paramArrayOfByte);
  
  public static native int initDecoder(String paramString);
  
  public static native int releaseDecoder(int paramInt);
  
  public int getFrame(byte[] paramArrayOfByte)
  {
    return getFrameFromPileMp4(this.mHandler, paramArrayOfByte);
  }
  
  public void release()
  {
    releaseDecoder(this.mHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.common.PileMp4Decoder
 * JD-Core Version:    0.7.0.1
 */