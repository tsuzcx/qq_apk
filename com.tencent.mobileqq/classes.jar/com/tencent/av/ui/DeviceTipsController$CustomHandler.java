package com.tencent.av.ui;

import android.os.Handler;
import android.os.Message;

class DeviceTipsController$CustomHandler
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 256) {
      return;
    }
    DeviceTipsController.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DeviceTipsController.CustomHandler
 * JD-Core Version:    0.7.0.1
 */