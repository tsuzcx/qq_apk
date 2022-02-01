package com.music.voice;

public class MusicWrapperJNI
{
  static
  {
    try
    {
      System.loadLibrary("MusicWrapper");
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public native int GetFeature(float paramFloat, int[] paramArrayOfInt1, float[] paramArrayOfFloat, byte[] paramArrayOfByte, int[] paramArrayOfInt2);
  
  public native int Init(String paramString);
  
  public native int Process(byte[] paramArrayOfByte, int paramInt);
  
  public native int QAFPGetVersion(int[] paramArrayOfInt);
  
  public native int QAFPSetPeakThreshold(float paramFloat);
  
  public native void QAHPGetDefaultInitArgs(String paramString, boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2);
  
  public native int QAHPGetVersion(int[] paramArrayOfInt);
  
  public native int Release();
  
  public native int Reset();
  
  public native int SetTimeThreashold(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.music.voice.MusicWrapperJNI
 * JD-Core Version:    0.7.0.1
 */