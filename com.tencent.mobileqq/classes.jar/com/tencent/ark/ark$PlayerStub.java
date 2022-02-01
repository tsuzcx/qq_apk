package com.tencent.ark;

public abstract interface ark$PlayerStub
{
  public static final int ERROR_NETWORK = -3;
  public static final int ERROR_NO_RESOURCE = -5;
  public static final int ERROR_SUCCESS = 0;
  public static final int ERROR_UNKNOWN = -1;
  public static final int ERROR_UNSUPPORT_HARDWARE = -4;
  public static final int ERROR_UNSUPPORT_MEDIA = -2;
  public static final int STATE_ERROR = 6;
  public static final int STATE_LOAD = 2;
  public static final int STATE_LOADING = 1;
  public static final int STATE_PAUSE = 4;
  public static final int STATE_PLAY = 3;
  public static final int STATE_START = 0;
  public static final int STATE_STOP = 5;
  public static final int TYPE_AUDIO = 1;
  public static final int TYPE_VIDEO = 0;
  
  public abstract void Destroy();
  
  public abstract double GetBufferedTime();
  
  public abstract double GetCurrentTime();
  
  public abstract int GetErrorCode();
  
  public abstract ark.PlayerStub.MediaInfo GetMediaInfo();
  
  public abstract boolean Load(String paramString);
  
  public abstract boolean Pause();
  
  public abstract boolean Play();
  
  public abstract boolean Resume();
  
  public abstract boolean Seek(double paramDouble);
  
  public abstract void SetBufferingCallback(long paramLong1, long paramLong2);
  
  public abstract void SetFrameCallback(long paramLong1, long paramLong2);
  
  public abstract void SetOutputSizeHint(int paramInt1, int paramInt2);
  
  public abstract void SetStateCallback(long paramLong1, long paramLong2);
  
  public abstract boolean SetVolume(float paramFloat);
  
  public abstract boolean Stop();
  
  public abstract boolean VideoPreviewSupported();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ark.PlayerStub
 * JD-Core Version:    0.7.0.1
 */