package com.qq.wx.voice.embedqqegg.vad;

public class EVadNative
{
  public static final int VAD_ERROR = 1;
  public static final int VAD_SILENCE = 3;
  public static final int VAD_SPEAK = 2;
  public static final int VAD_SUCCESS = 0;
  public static final int VAD_UNKNOW = 4;
  
  public native int AddData(long paramLong, short[] paramArrayOfShort, int paramInt);
  
  public native long Init(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4);
  
  public native int Release(long paramLong);
  
  public native int Reset(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.qq.wx.voice.embedqqegg.vad.EVadNative
 * JD-Core Version:    0.7.0.1
 */