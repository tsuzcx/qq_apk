package com.tencent.ark;

import android.os.Message;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class ThreadMessageHandler$LegacyMessageWrapperImpl
  implements ThreadMessageHandler.MessageWrapperImpl
{
  private Method mMessageMethodSetAsynchronous;
  
  ThreadMessageHandler$LegacyMessageWrapperImpl()
  {
    try
    {
      this.mMessageMethodSetAsynchronous = Class.forName("android.os.Message").getMethod("setAsynchronous", new Class[] { Boolean.TYPE });
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Log.e("ArkApp.ThreadMessageHandler", "Failed to find android.os.Message class", localClassNotFoundException);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Log.e("ArkApp.ThreadMessageHandler", "Failed to load Message.setAsynchronous method", localNoSuchMethodException);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.e("ArkApp.ThreadMessageHandler", "Exception while loading Message.setAsynchronous method", localRuntimeException);
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
      Log.e("ArkApp.ThreadMessageHandler", "Illegal access to async message creation, disabling.");
      this.mMessageMethodSetAsynchronous = null;
      return;
    }
    catch (IllegalArgumentException paramMessage)
    {
      Log.e("ArkApp.ThreadMessageHandler", "Illegal argument for async message creation, disabling.");
      this.mMessageMethodSetAsynchronous = null;
      return;
    }
    catch (InvocationTargetException paramMessage)
    {
      Log.e("ArkApp.ThreadMessageHandler", "Invocation exception during async message creation, disabling.");
      this.mMessageMethodSetAsynchronous = null;
      return;
    }
    catch (RuntimeException paramMessage)
    {
      Log.e("ArkApp.ThreadMessageHandler", "Runtime exception during async message creation, disabling.");
      this.mMessageMethodSetAsynchronous = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ThreadMessageHandler.LegacyMessageWrapperImpl
 * JD-Core Version:    0.7.0.1
 */