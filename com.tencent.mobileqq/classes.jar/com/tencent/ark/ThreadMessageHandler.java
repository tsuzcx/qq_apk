package com.tencent.ark;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ThreadMessageHandler
  extends Handler
{
  private static final int ASYNC_MESSAGE = 1;
  static final MessageWrapperImpl IMPL = new LegacyMessageWrapperImpl();
  private static final int SYNC_MESSAGE = 2;
  private static final String TAG = "ark.ThreadMessageHandler";
  private final Object mSignalObject = new Object();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 22)
    {
      IMPL = new LollipopMr1MessageWrapperImpl();
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
    Message localMessage = Message.obtain(this, paramInt, (int)(paramLong & 0xFFFFFFFF), (int)(paramLong >> 32 & 0xFFFFFFFF));
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
    }
    return false;
  }
  
  public void handleMessage(Message arg1)
  {
    if ((???.what != 1) && (???.what != 2)) {}
    do
    {
      return;
      nativeDelegateCallback(???.arg2 << 32 | ???.arg1);
    } while (???.what != 2);
    synchronized (this.mSignalObject)
    {
      this.mSignalObject.notifyAll();
      return;
    }
  }
  
  static final class LegacyMessageWrapperImpl
    implements ThreadMessageHandler.MessageWrapperImpl
  {
    private Method mMessageMethodSetAsynchronous;
    
    LegacyMessageWrapperImpl()
    {
      try
      {
        this.mMessageMethodSetAsynchronous = Class.forName("android.os.Message").getMethod("setAsynchronous", new Class[] { Boolean.TYPE });
        return;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Log.e("ark.ThreadMessageHandler", "Failed to find android.os.Message class", localClassNotFoundException);
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.e("ark.ThreadMessageHandler", "Failed to load Message.setAsynchronous method", localNoSuchMethodException);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        Log.e("ark.ThreadMessageHandler", "Exception while loading Message.setAsynchronous method", localRuntimeException);
      }
    }
    
    public void setAsynchronous(Message paramMessage, boolean paramBoolean)
    {
      if (this.mMessageMethodSetAsynchronous == null) {
        return;
      }
      try
      {
        this.mMessageMethodSetAsynchronous.invoke(paramMessage, new Object[] { Boolean.valueOf(paramBoolean) });
        return;
      }
      catch (IllegalAccessException paramMessage)
      {
        Log.e("ark.ThreadMessageHandler", "Illegal access to async message creation, disabling.");
        this.mMessageMethodSetAsynchronous = null;
        return;
      }
      catch (IllegalArgumentException paramMessage)
      {
        Log.e("ark.ThreadMessageHandler", "Illegal argument for async message creation, disabling.");
        this.mMessageMethodSetAsynchronous = null;
        return;
      }
      catch (InvocationTargetException paramMessage)
      {
        Log.e("ark.ThreadMessageHandler", "Invocation exception during async message creation, disabling.");
        this.mMessageMethodSetAsynchronous = null;
        return;
      }
      catch (RuntimeException paramMessage)
      {
        Log.e("ark.ThreadMessageHandler", "Runtime exception during async message creation, disabling.");
        this.mMessageMethodSetAsynchronous = null;
      }
    }
  }
  
  static final class LollipopMr1MessageWrapperImpl
    implements ThreadMessageHandler.MessageWrapperImpl
  {
    @TargetApi(22)
    public void setAsynchronous(Message paramMessage, boolean paramBoolean)
    {
      paramMessage.setAsynchronous(paramBoolean);
    }
  }
  
  static abstract interface MessageWrapperImpl
  {
    public abstract void setAsynchronous(Message paramMessage, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ark.ThreadMessageHandler
 * JD-Core Version:    0.7.0.1
 */