package com.tencent.mobileqq.armap.sensor.rotation;

public final class Vector4
{
  private static Vector4 e = new Vector4();
  private static Vector4 f = new Vector4();
  private static Vector4 g = new Vector4();
  public float a;
  public float b;
  public float c;
  public float d;
  
  public Vector4 a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
    return this;
  }
  
  public Vector4 a(Matrix4 paramMatrix4)
  {
    paramMatrix4 = paramMatrix4.val;
    float f1 = this.a;
    float f2 = paramMatrix4[0];
    float f3 = this.b;
    float f4 = paramMatrix4[4];
    float f5 = this.c;
    float f6 = paramMatrix4[8];
    float f7 = this.d;
    return a(f2 * f1 + f4 * f3 + f6 * f5 + paramMatrix4[12] * f7, paramMatrix4[1] * f1 + paramMatrix4[5] * f3 + paramMatrix4[9] * f5 + paramMatrix4[13] * f7, paramMatrix4[2] * f1 + paramMatrix4[6] * f3 + paramMatrix4[10] * f5 + paramMatrix4[14] * f7, f1 * paramMatrix4[3] + f3 * paramMatrix4[7] + f5 * paramMatrix4[11] + f7 * paramMatrix4[15]);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (Vector4)paramObject;
    if (Float.floatToIntBits(this.a) != Float.floatToIntBits(paramObject.a)) {
      return false;
    }
    if (Float.floatToIntBits(this.b) != Float.floatToIntBits(paramObject.b)) {
      return false;
    }
    if (Float.floatToIntBits(this.c) != Float.floatToIntBits(paramObject.c)) {
      return false;
    }
    return Float.floatToIntBits(this.d) == Float.floatToIntBits(paramObject.d);
  }
  
  public int hashCode()
  {
    return (((Float.floatToIntBits(this.a) + 31) * 31 + Float.floatToIntBits(this.b)) * 31 + Float.floatToIntBits(this.c)) * 31 + Float.floatToIntBits(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.rotation.Vector4
 * JD-Core Version:    0.7.0.1
 */