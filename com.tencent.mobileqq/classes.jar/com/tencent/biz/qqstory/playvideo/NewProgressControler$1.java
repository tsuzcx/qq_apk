package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class NewProgressControler$1
  extends Handler
{
  NewProgressControler$1(NewProgressControler paramNewProgressControler, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.e) {
      return;
    }
    paramMessage = this.a;
    NewProgressControler.a(paramMessage, paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.NewProgressControler.1
 * JD-Core Version:    0.7.0.1
 */