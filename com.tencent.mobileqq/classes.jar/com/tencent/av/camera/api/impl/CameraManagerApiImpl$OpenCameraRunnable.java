package com.tencent.av.camera.api.impl;

import android.annotation.TargetApi;
import com.tencent.qphone.base.util.QLog;

class CameraManagerApiImpl$OpenCameraRunnable
  implements Runnable
{
  long jdField_a_of_type_Long = 0L;
  boolean jdField_a_of_type_Boolean = false;
  
  CameraManagerApiImpl$OpenCameraRunnable(CameraManagerApiImpl paramCameraManagerApiImpl) {}
  
  @TargetApi(14)
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("openCamera begin, mCamera[");
      localStringBuilder.append(CameraManagerApiImpl.access$500(this.this$0));
      localStringBuilder.append("], mOpening[");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("]");
      QLog.w("CameraUtils", 1, localStringBuilder.toString());
      return;
    }
    CameraManagerApiImpl.access$000(this.this$0, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mOpening[");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.camera.api.impl.CameraManagerApiImpl.OpenCameraRunnable
 * JD-Core Version:    0.7.0.1
 */