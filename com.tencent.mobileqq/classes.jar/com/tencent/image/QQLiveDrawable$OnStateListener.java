package com.tencent.image;

public abstract interface QQLiveDrawable$OnStateListener
{
  public static final int STATE_BUFFERING = 3;
  public static final int STATE_COMPLETE = 6;
  public static final int STATE_ERROR = 5;
  public static final int STATE_IDLE = 0;
  public static final int STATE_INITIALIZED = 8;
  public static final int STATE_PAUSE = 4;
  public static final int STATE_PLAYING = 2;
  public static final int STATE_PREPARED = 1;
  public static final int STATE_PREPARING = 9;
  public static final int STATE_RELEASED = 10;
  public static final int STATE_UNKNOW = 7;
  
  public abstract void onStateChange(String paramString, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, int paramInt, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.QQLiveDrawable.OnStateListener
 * JD-Core Version:    0.7.0.1
 */