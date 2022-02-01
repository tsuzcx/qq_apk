package com.tencent.av.opengl.effects;

public class RenderResult
{
  CameraFrame jdField_a_of_type_ComTencentAvOpenglEffectsCameraFrame;
  short jdField_a_of_type_Short;
  byte[] jdField_a_of_type_ArrayOfByte;
  short jdField_b_of_type_Short;
  byte[] jdField_b_of_type_ArrayOfByte;
  byte[] c;
  
  RenderResult()
  {
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAvOpenglEffectsCameraFrame = null;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_ArrayOfByte = null;
    this.c = null;
    this.jdField_a_of_type_Short = 0;
    this.jdField_b_of_type_Short = 0;
  }
  
  public void a(CameraFrame paramCameraFrame, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2)
  {
    this.jdField_a_of_type_ComTencentAvOpenglEffectsCameraFrame = paramCameraFrame;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    this.c = paramArrayOfByte3;
    this.jdField_a_of_type_Short = paramShort1;
    this.jdField_b_of_type_Short = paramShort2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.RenderResult
 * JD-Core Version:    0.7.0.1
 */