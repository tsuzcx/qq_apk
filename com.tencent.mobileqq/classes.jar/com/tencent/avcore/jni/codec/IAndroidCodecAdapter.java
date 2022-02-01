package com.tencent.avcore.jni.codec;

public abstract interface IAndroidCodecAdapter
{
  public abstract AndroidCodecBase createDecCodec(String paramString);
  
  public abstract AndroidCodecBase createEncCodec(String paramString);
  
  public abstract boolean isSupportAsyncAPI();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.jni.codec.IAndroidCodecAdapter
 * JD-Core Version:    0.7.0.1
 */