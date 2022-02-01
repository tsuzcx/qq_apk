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
    catch (RuntimeException localRuntimeException)
    {
      Log.e("ArkApp.Thread", "Exception while loading Message.setAsynchronous method", localRuntimeException);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Log.e("ArkApp.Thread", "Failed to load Message.setAsynchronous method", localNoSuchMethodException);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Log.e("ArkApp.Thread", "Failed to find android.os.Message class", localClassNotFoundException);
    }
  }
  
  public void setAsynchronous(Message paramMessage, boolean paramBoolean)
  {
    Method localMethod = this.mMessageMethodSetAsynchronous;
    if (localMethod == null) {
      return;
    }
    try
    {
      localMethod.invoke(paramMessage, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (IllegalAccessException paramMessage)
    {
      break label70;
    }
    catch (IllegalArgumentException paramMessage)
    {
      break label56;
    }
    catch (InvocationTargetException paramMessage)
    {
      break label42;
    }
    catch (RuntimeException paramMessage)
    {
      label28:
      break label28;
    }
    Log.e("ArkApp.Thread", "Runtime exception during async message creation, disabling.");
    this.mMessageMethodSetAsynchronous = null;
    return;
    label42:
    Log.e("ArkApp.Thread", "Invocation exception during async message creation, disabling.");
    this.mMessageMethodSetAsynchronous = null;
    return;
    label56:
    Log.e("ArkApp.Thread", "Illegal argument for async message creation, disabling.");
    this.mMessageMethodSetAsynchronous = null;
    return;
    label70:
    Log.e("ArkApp.Thread", "Illegal access to async message creation, disabling.");
    this.mMessageMethodSetAsynchronous = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ThreadMessageHandler.LegacyMessageWrapperImpl
 * JD-Core Version:    0.7.0.1
 */