package com.tencent.ilive.opensdk.coreinterface;

public abstract interface IMusicDecoderEx
{
  public abstract int get(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public abstract int getChannels();
  
  public abstract int getDubFrameLen();
  
  public abstract int getDubInfoChannels();
  
  public abstract int getDubInfoSampleRate();
  
  public abstract long getLength();
  
  public abstract int getOrgFrameLen();
  
  public abstract int getSampleRate();
  
  public abstract long getTimestamp();
  
  public abstract boolean hasDubInfo();
  
  public abstract int open(String paramString1, String paramString2);
  
  public abstract void seekTo(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.opensdk.coreinterface.IMusicDecoderEx
 * JD-Core Version:    0.7.0.1
 */