package com.tencent.component.media.utils;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;

public class BaseHandler
  extends Handler
{
  public BaseHandler() {}
  
  public BaseHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  @TargetApi(3)
  public BaseHandler(Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper, paramCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.utils.BaseHandler
 * JD-Core Version:    0.7.0.1
 */