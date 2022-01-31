package com.tencent.mobileqq.armap.sensor.rotation;

public final class Vector4
{
  private static Vector4 a;
  private static Vector4 b;
  private static Vector4 c;
  public float a;
  public float b;
  public float c;
  public float d;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqArmapSensorRotationVector4 = new Vector4();
    jdField_b_of_type_ComTencentMobileqqArmapSensorRotationVector4 = new Vector4();
    jdField_c_of_type_ComTencentMobileqqArmapSensorRotationVector4 = new Vector4();
  }
  
  public Vector4 a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.jdField_c_of_type_Float = paramFloat3;
    this.d = paramFloat4;
    return this;
  }
  
  public Vector4 a(Matrix4 paramMatrix4)
  {
    paramMatrix4 = paramMatrix4.val;
    float f1 = this.jdField_a_of_type_Float;
    float f2 = paramMatrix4[0];
    float f3 = this.jdField_b_of_type_Float;
    float f4 = paramMatrix4[4];
    float f5 = this.jdField_c_of_type_Float;
    float f6 = paramMatrix4[8];
    float f7 = this.d;
    float f8 = paramMatrix4[12];
    float f9 = this.jdField_a_of_type_Float;
    float f10 = paramMatrix4[1];
    float f11 = this.jdField_b_of_type_Float;
    float f12 = paramMatrix4[5];
    float f13 = this.jdField_c_of_type_Float;
    float f14 = paramMatrix4[9];
    float f15 = this.d;
    float f16 = paramMatrix4[13];
    float f17 = this.jdField_a_of_type_Float;
    float f18 = paramMatrix4[2];
    float f19 = this.jdField_b_of_type_Float;
    float f20 = paramMatrix4[6];
    float f21 = this.jdField_c_of_type_Float;
    float f22 = paramMatrix4[10];
    float f23 = this.d;
    float f24 = paramMatrix4[14];
    float f25 = this.jdField_a_of_type_Float;
    float f26 = paramMatrix4[3];
    float f27 = this.jdField_b_of_type_Float;
    float f28 = paramMatrix4[7];
    float f29 = this.jdField_c_of_type_Float;
    float f30 = paramMatrix4[11];
    float f31 = this.d;
    return a(f1 * f2 + f3 * f4 + f5 * f6 + f7 * f8, f9 * f10 + f11 * f12 + f13 * f14 + f15 * f16, f17 * f18 + f19 * f20 + f21 * f22 + f23 * f24, paramMatrix4[15] * f31 + (f25 * f26 + f27 * f28 + f29 * f30));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (Vector4)paramObject;
      if (Float.floatToIntBits(this.jdField_a_of_type_Float) != Float.floatToIntBits(paramObject.jdField_a_of_type_Float)) {
        return false;
      }
      if (Float.floatToIntBits(this.jdField_b_of_type_Float) != Float.floatToIntBits(paramObject.jdField_b_of_type_Float)) {
        return false;
      }
      if (Float.floatToIntBits(this.jdField_c_of_type_Float) != Float.floatToIntBits(paramObject.jdField_c_of_type_Float)) {
        return false;
      }
    } while (Float.floatToIntBits(this.d) == Float.floatToIntBits(paramObject.d));
    return false;
  }
  
  public int hashCode()
  {
    return (((Float.floatToIntBits(this.jdField_a_of_type_Float) + 31) * 31 + Float.floatToIntBits(this.jdField_b_of_type_Float)) * 31 + Float.floatToIntBits(this.jdField_c_of_type_Float)) * 31 + Float.floatToIntBits(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.rotation.Vector4
 * JD-Core Version:    0.7.0.1
 */