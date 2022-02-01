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
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.a = true;
    NowVideoController.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.now.NowVideoController.1
 * JD-Core Version:    0.7.0.1
 */