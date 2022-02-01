package com.tencent.av.camera.api.impl;

class CameraManagerApiImpl$CloseCameraRunnable
  implements Runnable
{
  public long a;
  private boolean a;
  
  CameraManagerApiImpl$CloseCameraRunnable(CameraManagerApiImpl paramCameraManagerApiImpl)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void run()
  {
    CameraManagerApiImpl.access$100(this.this$0, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.camera.api.impl.CameraManagerApiImpl.CloseCameraRunnable
 * JD-Core Version:    0.7.0.1
 */