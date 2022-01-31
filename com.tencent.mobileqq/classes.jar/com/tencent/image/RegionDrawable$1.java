package com.tencent.image;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class RegionDrawable$1
  extends Handler
{
  RegionDrawable$1(RegionDrawable paramRegionDrawable, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.this$0.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.RegionDrawable.1
 * JD-Core Version:    0.7.0.1
 */