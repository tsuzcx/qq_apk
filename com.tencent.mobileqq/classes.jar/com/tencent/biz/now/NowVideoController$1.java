package com.tencent.biz.now;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class NowVideoController$1
  extends Handler
{
  NowVideoController$1(NowVideoController paramNowVideoController, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    paramMessage = this.a;
    paramMessage.a = true;
    NowVideoController.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.now.NowVideoController.1
 * JD-Core Version:    0.7.0.1
 */