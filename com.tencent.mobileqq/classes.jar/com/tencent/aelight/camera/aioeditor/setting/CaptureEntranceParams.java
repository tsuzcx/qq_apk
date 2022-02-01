package com.tencent.aelight.camera.aioeditor.setting;

public class CaptureEntranceParams
{
  public int a;
  private CapturePicParams jdField_a_of_type_ComTencentAelightCameraAioeditorSettingCapturePicParams;
  private CaptureVideoParams jdField_a_of_type_ComTencentAelightCameraAioeditorSettingCaptureVideoParams;
  public int b;
  public int c;
  
  public CaptureEntranceParams(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public CapturePicParams a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingCapturePicParams;
  }
  
  public CaptureVideoParams a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingCaptureVideoParams;
  }
  
  public void a(CapturePicParams paramCapturePicParams)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingCapturePicParams = paramCapturePicParams;
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingCapturePicParams.a() != null) {
      this.b = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingCapturePicParams.b();
    }
  }
  
  public void a(CaptureVideoParams paramCaptureVideoParams)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingCaptureVideoParams = paramCaptureVideoParams;
  }
  
  public int b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.setting.CaptureEntranceParams
 * JD-Core Version:    0.7.0.1
 */