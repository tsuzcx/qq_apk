package com.tencent.ark;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;

public class ThreadMessageHandler
  extends Handler
{
  private static final int ASYNC_MESSAGE = 1;
  static final ThreadMessageHandler.MessageWrapperImpl IMPL = new ThreadMessageHandler.LegacyMessageWrapperImpl();
  private static final int SYNC_MESSAGE = 2;
  private static final String TAG = "ArkApp.Thread";
  private final Object mSignalObject = new Object();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 22)
    {
      IMPL = new ThreadMessageHandler.LollipopMr1MessageWrapperImpl();
      return;
    }
  }
  
  private static ThreadMessageHandler create()
  {
    return new ThreadMessageHandler();
  }
  
  private native boolean nativeDelegateCallback(long paramLong);
  
  private Message obtainAsyncMessage(int paramInt, long paramLong)
  {
    Message localMessage = Message.obtain(this, paramInt, (int)paramLong, (int)(paramLong >> 32));
    IMPL.setAsynchronous(localMessage, true);
    return localMessage;
  }
  
  private boolean postDelegate(long paramLong)
  {
    return sendMessage(obtainAsyncMessage(1, paramLong));
  }
  
  private boolean postDelegateDelayed(long paramLong1, long paramLong2)
  {
    return sendMessageDelayed(obtainAsyncMessage(1, paramLong1), paramLong2);
  }
  
  private boolean sendDelegate(long paramLong)
  {
    synchronized (this.mSignalObject)
    {
      if (!sendMessage(obtainAsyncMessage(2, paramLong))) {
        return false;
      }
      try
      {
        this.mSignalObject.wait();
        return true;
      }
      catch (InterruptedException localInterruptedException)
      {
        label35:
        break label35;
      }
      return false;
    }
  }
  
  public void handleMessage(Message arg1)
  {
    if ((???.what != 1) && (???.what != 2)) {
      return;
    }
    nativeDelegateCallback(???.arg2 << 32 | ???.arg1);
    if (???.what == 2) {
      synchronized (this.mSignalObject)
      {
        this.mSignalObject.notifyAll();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ThreadMessageHandler
 * JD-Core Version:    0.7.0.1
 */