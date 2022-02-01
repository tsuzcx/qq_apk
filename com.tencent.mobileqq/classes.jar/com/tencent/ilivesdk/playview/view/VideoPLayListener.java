package com.tencent.ilivesdk.playview.view;

public abstract interface VideoPLayListener
{
  public static final int ERROR_CREATE_DECODER = -2;
  public static final int ERROR_FILE_RELATIVE = -1;
  public static final int ERROR_IN_PLAYING = -11;
  public static final int ERROR_START_DECODE_TIMEOUT = -3;
  public static final int ERROR_STATE_ALSO_PLAYING = -10;
  public static final int ERROR_STATE_VIEW_ALSO_READY = -11;
  public static final int ERROR_STATE_VIEW_ALSO_STOPING = -12;
  
  public abstract void onEnd();
  
  public abstract void onError(int paramInt);
  
  public abstract void onPlayAtTime(long paramLong);
  
  public abstract void onStart();
  
  public abstract void onVideoSize(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.VideoPLayListener
 * JD-Core Version:    0.7.0.1
 */