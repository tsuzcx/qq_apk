package com.tencent.av.camera;

import android.annotation.TargetApi;
import com.tencent.qphone.base.util.QLog;

class CameraUtils$OpenCameraRunnable
  implements Runnable
{
  long jdField_a_of_type_Long = 0L;
  boolean jdField_a_of_type_Boolean = false;
  
  CameraUtils$OpenCameraRunnable(CameraUtils paramCameraUtils) {}
  
  @TargetApi(14)
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.w("CameraUtils", 1, "openCamera begin, mCamera[" + this.this$0.a + "], mOpening[" + this.jdField_a_of_type_Boolean + "], seq[" + this.jdField_a_of_type_Long + "]");
      return;
    }
    CameraUtils.a(this.this$0, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public String toString()
  {
    return "mOpening[" + this.jdField_a_of_type_Boolean + "], seq[" + this.jdField_a_of_type_Long + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.camera.CameraUtils.OpenCameraRunnable
 * JD-Core Version:    0.7.0.1
 */