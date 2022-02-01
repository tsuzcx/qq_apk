package com.tencent.device.file;

import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.transfile.TransProcessorHandler;

class DeviceAVFileMsgObserver$1
  extends TransProcessorHandler
{
  DeviceAVFileMsgObserver$1(DeviceAVFileMsgObserver paramDeviceAVFileMsgObserver, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.a.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.device.file.DeviceAVFileMsgObserver.1
 * JD-Core Version:    0.7.0.1
 */