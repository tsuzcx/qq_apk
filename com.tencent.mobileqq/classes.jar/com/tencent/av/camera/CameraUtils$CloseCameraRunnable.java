package com.tencent.av.camera;

class CameraUtils$CloseCameraRunnable
  implements Runnable
{
  public long a;
  private boolean a;
  
  CameraUtils$CloseCameraRunnable(CameraUtils paramCameraUtils)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    CameraUtils.a(this.this$0, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_Long + "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.camera.CameraUtils.CloseCameraRunnable
 * JD-Core Version:    0.7.0.1
 */