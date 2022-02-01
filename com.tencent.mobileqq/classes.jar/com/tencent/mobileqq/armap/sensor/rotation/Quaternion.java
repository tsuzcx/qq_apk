package com.tencent.mobileqq.armap.sensor.rotation;

import java.io.Serializable;

public class Quaternion
  implements Serializable
{
  private static Quaternion a = new Quaternion(0.0F, 0.0F, 0.0F, 0.0F);
  private static Quaternion b = new Quaternion(0.0F, 0.0F, 0.0F, 0.0F);
  private static final long serialVersionUID = -7661875440774897168L;
  public float w;
  public float x;
  public float y;
  public float z;
  
  public Quaternion()
  {
    idt();
  }
  
  public Quaternion(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public Quaternion(Quaternion paramQuaternion)
  {
    set(paramQuaternion);
  }
  
  public Quaternion(Vector3 paramVector3, float paramFloat)
  {
    set(paramVector3, paramFloat);
  }
  
  public Quaternion conjugate()
  {
    this.x = (-this.x);
    this.y = (-this.y);
    this.z = (-this.z);
    return this;
  }
  
  public Quaternion cpy()
  {
    return new Quaternion(this);
  }
  
  public float dot(Quaternion paramQuaternion)
  {
    return this.x * paramQuaternion.x + this.y * paramQuaternion.y + this.z * paramQuaternion.z + this.w * paramQuaternion.w;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Quaternion)) {
      return false;
    }
    paramObject = (Quaternion)paramObject;
    return (this.x == paramObject.x) && (this.y == paramObject.y) && (this.z == paramObject.z) && (this.w == paramObject.w);
  }
  
  public Quaternion idt()
  {
    set(0.0F, 0.0F, 0.0F, 1.0F);
    return this;
  }
  
  public float len()
  {
    float f1 = this.x;
    float f2 = this.y;
    float f3 = this.z;
    float f4 = this.w;
    return (float)Math.sqrt(f1 * f1 + f2 * f2 + f3 * f3 + f4 * f4);
  }
  
  public float len2()
  {
    float f1 = this.x;
    float f2 = this.y;
    float f3 = this.z;
    float f4 = this.w;
    return f1 * f1 + f2 * f2 + f3 * f3 + f4 * f4;
  }
  
  public Quaternion mul(float paramFloat)
  {
    this.x *= paramFloat;
    this.y *= paramFloat;
    this.z *= paramFloat;
    this.w *= paramFloat;
    return this;
  }
  
  public Quaternion mulLeft(Quaternion paramQuaternion)
  {
    float f1 = paramQuaternion.w;
    float f2 = this.x;
    float f3 = paramQuaternion.x;
    float f4 = this.w;
    float f5 = paramQuaternion.y;
    float f6 = this.z;
    float f7 = paramQuaternion.z;
    float f8 = this.y;
    this.x = (f1 * f2 + f3 * f4 + f5 * f6 - f7 * f8);
    this.y = (f1 * f8 + f5 * f4 + f7 * f2 - f3 * f6);
    this.z = (f1 * f6 + f7 * f4 + f3 * f8 - f5 * f2);
    this.w = (f1 * f4 - f3 * f2 - f5 * f8 - f7 * f6);
    return this;
  }
  
  public Quaternion nor()
  {
    float f = len2();
    if ((f != 0.0F) && (Math.abs(f - 1.0F) > 1.0E-005F))
    {
      f = (float)Math.sqrt(f);
      this.w /= f;
      this.x /= f;
      this.y /= f;
      this.z /= f;
    }
    return this;
  }
  
  public Quaternion set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
    this.w = paramFloat4;
    return this;
  }
  
  public Quaternion set(Quaternion paramQuaternion)
  {
    return set(paramQuaternion.x, paramQuaternion.y, paramQuaternion.z, paramQuaternion.w);
  }
  
  public Quaternion set(Vector3 paramVector3, float paramFloat)
  {
    double d = (float)Math.toRadians(paramFloat) / 2.0F;
    paramFloat = (float)Math.sin(d);
    float f = (float)Math.cos(d);
    return set(paramVector3.x * paramFloat, paramVector3.y * paramFloat, paramVector3.z * paramFloat, f).nor();
  }
  
  public Quaternion setFromAxes(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    float f = paramFloat1 + paramFloat5 + paramFloat9;
    double d1;
    double d2;
    double d4;
    double d3;
    double d5;
    if (f >= 0.0F)
    {
      d1 = Math.sqrt(f + 1.0F);
      d2 = d1 * 0.5D;
      d4 = 0.5D / d1;
      d1 = paramFloat8 - paramFloat6;
      Double.isNaN(d1);
      d1 *= d4;
      d3 = paramFloat3 - paramFloat7;
      Double.isNaN(d3);
      d3 *= d4;
      d5 = paramFloat4 - paramFloat2;
      Double.isNaN(d5);
      d4 = d5 * d4;
    }
    else if ((paramFloat1 > paramFloat5) && (paramFloat1 > paramFloat9))
    {
      d1 = paramFloat1;
      Double.isNaN(d1);
      d2 = paramFloat5;
      Double.isNaN(d2);
      d3 = paramFloat9;
      Double.isNaN(d3);
      d1 = Math.sqrt(d1 + 1.0D - d2 - d3);
      d2 = 0.5D / d1;
      d3 = paramFloat4 + paramFloat2;
      Double.isNaN(d3);
      d3 *= d2;
      d4 = paramFloat3 + paramFloat7;
      Double.isNaN(d4);
      d4 *= d2;
      d5 = paramFloat8 - paramFloat6;
      Double.isNaN(d5);
      d1 *= 0.5D;
      d2 = d5 * d2;
    }
    else
    {
      if (paramFloat5 > paramFloat9)
      {
        d1 = paramFloat5;
        Double.isNaN(d1);
        d2 = paramFloat1;
        Double.isNaN(d2);
        d3 = paramFloat9;
        Double.isNaN(d3);
        d1 = Math.sqrt(d1 + 1.0D - d2 - d3);
        d2 = d1 * 0.5D;
        d5 = 0.5D / d1;
        d1 = paramFloat4 + paramFloat2;
        Double.isNaN(d1);
        d1 *= d5;
        d3 = paramFloat8 + paramFloat6;
        Double.isNaN(d3);
        d3 *= d5;
        d4 = paramFloat3 - paramFloat7;
        Double.isNaN(d4);
      }
      else
      {
        d1 = paramFloat9;
        Double.isNaN(d1);
        d2 = paramFloat1;
        Double.isNaN(d2);
        d3 = paramFloat5;
        Double.isNaN(d3);
        d1 = Math.sqrt(d1 + 1.0D - d2 - d3);
        d3 = d1 * 0.5D;
        d5 = 0.5D / d1;
        d1 = paramFloat3 + paramFloat7;
        Double.isNaN(d1);
        d1 *= d5;
        d2 = paramFloat8 + paramFloat6;
        Double.isNaN(d2);
        d2 *= d5;
        d4 = paramFloat4 - paramFloat2;
        Double.isNaN(d4);
      }
      d5 = d4 * d5;
      d4 = d3;
      d3 = d2;
      d2 = d5;
    }
    return set((float)d1, (float)d3, (float)d4, (float)d2);
  }
  
  public Quaternion setFromAxis(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat4 = paramFloat4 * 0.01745329F / 2.0F;
    float f = MathUtils.a(paramFloat4);
    return set(paramFloat1 * f, paramFloat2 * f, paramFloat3 * f, MathUtils.b(paramFloat4)).nor();
  }
  
  public Quaternion setFromAxis(Vector3 paramVector3, float paramFloat)
  {
    return setFromAxis(paramVector3.x, paramVector3.y, paramVector3.z, paramFloat);
  }
  
  public Quaternion setFromMatrix(Matrix4 paramMatrix4)
  {
    return setFromAxes(paramMatrix4.val[0], paramMatrix4.val[4], paramMatrix4.val[8], paramMatrix4.val[1], paramMatrix4.val[5], paramMatrix4.val[9], paramMatrix4.val[2], paramMatrix4.val[6], paramMatrix4.val[10]);
  }
  
  public Quaternion slerp(Quaternion paramQuaternion, float paramFloat)
  {
    if (equals(paramQuaternion)) {
      return this;
    }
    float f2 = dot(paramQuaternion);
    float f1 = f2;
    if (f2 < 0.0D)
    {
      paramQuaternion.mul(-1.0F);
      f1 = -f2;
    }
    float f4 = 1.0F - paramFloat;
    float f3 = f4;
    f2 = paramFloat;
    if (1.0F - f1 > 0.1D)
    {
      double d1 = Math.acos(f1);
      double d2 = 1.0D / Math.sin(d1);
      double d3 = f4;
      Double.isNaN(d3);
      f3 = (float)(Math.sin(d3 * d1) * d2);
      d3 = paramFloat;
      Double.isNaN(d3);
      f2 = (float)(Math.sin(d3 * d1) * d2);
    }
    set(this.x * f3 + paramQuaternion.x * f2, this.y * f3 + paramQuaternion.y * f2, this.z * f3 + paramQuaternion.z * f2, f3 * this.w + f2 * paramQuaternion.w);
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.x);
    localStringBuilder.append("|");
    localStringBuilder.append(this.y);
    localStringBuilder.append("|");
    localStringBuilder.append(this.z);
    localStringBuilder.append("|");
    localStringBuilder.append(this.w);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void transform(Vector3 paramVector3)
  {
    b.set(this);
    b.conjugate();
    b.mulLeft(a.set(paramVector3.x, paramVector3.y, paramVector3.z, 0.0F)).mulLeft(this);
    Quaternion localQuaternion = b;
    paramVector3.x = localQuaternion.x;
    paramVector3.y = localQuaternion.y;
    paramVector3.z = localQuaternion.z;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.rotation.Quaternion
 * JD-Core Version:    0.7.0.1
 */