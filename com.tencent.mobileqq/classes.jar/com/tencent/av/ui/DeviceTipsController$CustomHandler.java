package com.tencent.av.ui;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class DeviceTipsController$CustomHandler
  extends Handler
{
  public DeviceTipsController$CustomHandler(DeviceTipsController paramDeviceTipsController, Looper paramLooper)
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
    DeviceTipsController.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.DeviceTipsController.CustomHandler
 * JD-Core Version:    0.7.0.1
 */