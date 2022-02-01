package com.tencent.device.file;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class DeviceFileHandler$1
  extends Handler
{
  DeviceFileHandler$1(DeviceFileHandler paramDeviceFileHandler, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 0) {
      return;
    }
    this.a.notifyUI(103, true, paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.file.DeviceFileHandler.1
 * JD-Core Version:    0.7.0.1
 */