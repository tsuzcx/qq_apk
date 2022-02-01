package com.tencent.mobileqq.ar.arengine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.ar.model.CameraProxy;

class ARCamera$ARCameraHandler
  extends Handler
{
  public ARCamera$ARCameraHandler(ARCamera paramARCamera, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      CameraProxy.a().a(new ARCamera.ARCameraHandler.1(this));
      removeMessages(100);
      sendEmptyMessageDelayed(100, 3000L);
      return;
    case 101: 
      CameraProxy.a().a(new ARCamera.ARCameraHandler.2(this));
      return;
    }
    CameraProxy.a().a(new ARCamera.ARCameraHandler.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCamera.ARCameraHandler
 * JD-Core Version:    0.7.0.1
 */