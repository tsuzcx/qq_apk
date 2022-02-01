package com.tencent.mobileqq.app.automator.step;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class RegisterProxy$ReconnectHandler
  extends Handler
{
  public RegisterProxy$ReconnectHandler(RegisterProxy paramRegisterProxy, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 100) {
      return;
    }
    RegisterProxy.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.RegisterProxy.ReconnectHandler
 * JD-Core Version:    0.7.0.1
 */