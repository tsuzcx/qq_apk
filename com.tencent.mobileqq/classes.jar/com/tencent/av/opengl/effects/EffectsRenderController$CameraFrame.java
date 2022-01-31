package com.tencent.av.opengl.effects;

import com.tencent.mobileqq.utils.AudioHelper;

public class EffectsRenderController$CameraFrame
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  boolean jdField_a_of_type_Boolean;
  byte[] jdField_a_of_type_ArrayOfByte;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  int jdField_c_of_type_Int;
  long jdField_c_of_type_Long;
  int jdField_d_of_type_Int;
  long jdField_d_of_type_Long = 0L;
  
  EffectsRenderController$CameraFrame() {}
  
  EffectsRenderController$CameraFrame(CameraFrame paramCameraFrame)
  {
    this(paramCameraFrame.jdField_a_of_type_ArrayOfByte, paramCameraFrame.jdField_a_of_type_Int, paramCameraFrame.jdField_b_of_type_Int, paramCameraFrame.jdField_c_of_type_Int, paramCameraFrame.jdField_d_of_type_Int, paramCameraFrame.jdField_a_of_type_Boolean, paramCameraFrame.jdField_a_of_type_Long, paramCameraFrame.jdField_b_of_type_Long);
    this.jdField_d_of_type_Long = paramCameraFrame.jdField_d_of_type_Long;
  }
  
  EffectsRenderController$CameraFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_d_of_type_Int = paramInt4;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_c_of_type_Long = AudioHelper.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.opengl.effects.EffectsRenderController.CameraFrame
 * JD-Core Version:    0.7.0.1
 */