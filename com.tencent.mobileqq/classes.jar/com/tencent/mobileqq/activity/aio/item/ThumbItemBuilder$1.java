package com.tencent.mobileqq.activity.aio.item;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ThumbItemBuilder$1
  extends Handler
{
  ThumbItemBuilder$1(ThumbItemBuilder paramThumbItemBuilder, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == ThumbItemBuilder.f) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ThumbItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */