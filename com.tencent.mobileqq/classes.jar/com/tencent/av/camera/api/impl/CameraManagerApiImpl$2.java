package com.tencent.av.camera.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Camera;
import com.tencent.qphone.base.util.QLog;

class CameraManagerApiImpl$2
  implements Runnable
{
  CameraManagerApiImpl$2(CameraManagerApiImpl paramCameraManagerApiImpl, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    int i = Camera.getNumberOfCameras();
    this.a.edit().putInt("cameraNumber", i).commit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CameraHandlerThread, async checkCameraNumbers numberOfCameras ");
    localStringBuilder.append(i);
    QLog.d("CameraUtils", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.camera.api.impl.CameraManagerApiImpl.2
 * JD-Core Version:    0.7.0.1
 */