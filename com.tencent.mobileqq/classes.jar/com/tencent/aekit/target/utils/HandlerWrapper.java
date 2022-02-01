package com.tencent.aekit.target.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class HandlerWrapper
  extends Handler
{
  private HandlerWrapper.MessageHandler mh = null;
  
  public HandlerWrapper(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void call(Runnable paramRunnable)
  {
    synchronized (new Object())
    {
      post(new HandlerWrapper.1(this, ???, paramRunnable));
      try
      {
        ???.wait();
      }
      catch (InterruptedException paramRunnable)
      {
        paramRunnable.printStackTrace();
      }
      return;
    }
  }
  
  public final void handleMessage(Message paramMessage)
  {
    HandlerWrapper.MessageHandler localMessageHandler = this.mh;
    if (localMessageHandler != null) {
      localMessageHandler.handleMessage(paramMessage);
    }
  }
  
  public void setMessageHandler(HandlerWrapper.MessageHandler paramMessageHandler)
  {
    this.mh = paramMessageHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.target.utils.HandlerWrapper
 * JD-Core Version:    0.7.0.1
 */