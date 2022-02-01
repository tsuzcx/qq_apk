package com.tencent.mobileqq.armap.sensor.rotation;

import aqeb;
import java.io.Serializable;

public class Vector3
  implements Serializable
{
  public static final Vector3 X = new Vector3(1.0F, 0.0F, 0.0F);
  public static final Vector3 Y = new Vector3(0.0F, 1.0F, 0.0F);
  public static final Vector3 Z = new Vector3(0.0F, 0.0F, 1.0F);
  public static final Vector3 Zero = new Vector3(0.0F, 0.0F, 0.0F);
  private static final Matrix4 a = new Matrix4();
  private static final long serialVersionUID = 3840054589595372522L;
  public static final Vector3 tmp = new Vector3();
  public float x;
  public float y;
  public float z;
  
  public Vector3() {}
  
  public Vector3(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    set(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public Vector3(Vector3 paramVector3)
  {
    set(paramVector3);
  }
  
  public Vector3(float[] paramArrayOfFloat)
  {
    set(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2]);
  }
  
  public Vector3 add(float paramFloat)
  {
    return set(this.x + paramFloat, this.y + paramFloat, this.z + paramFloat);
  }
  
  public Vector3 add(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return set(this.x + paramFloat1, this.y + paramFloat2, this.z + paramFloat3);
  }
  
  public Vector3 add(Vector3 paramVector3)
  {
    return add(paramVector3.x, paramVector3.y, paramVector3.z);
  }
  
  public Vector3 crs(Vector3 paramVector3)
  {
    return set(this.y * paramVector3.z - this.z * paramVector3.y, this.z * paramVector3.x - this.x * paramVector3.z, this.x * paramVector3.y - this.y * paramVector3.x);
  }
  
  public Vector3 div(float paramFloat)
  {
    return mul(1.0F / paramFloat);
  }
  
  public float dot(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return this.x * paramFloat1 + this.y * paramFloat2 + this.z * paramFloat3;
  }
  
  public float dot(Vector3 paramVector3)
  {
    return this.x * paramVector3.x + this.y * paramVector3.y + this.z * paramVector3.z;
  }
  
  public float dst(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (float)Math.sqrt(dst2(paramFloat1, paramFloat2, paramFloat3));
  }
  
  public float dst(Vector3 paramVector3)
  {
    float f1 = paramVector3.x - this.x;
    float f2 = paramVector3.y - this.y;
    float f3 = paramVector3.z - this.z;
    return (float)Math.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
  }
  
  public float dst2(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramFloat1 -= this.x;
    paramFloat2 -= this.y;
    paramFloat3 -= this.z;
    return paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 + paramFloat3 * paramFloat3;
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
      paramObject = (Vector3)paramObject;
      if (aqeb.a(this.x) != aqeb.a(paramObject.x)) {
        return false;
      }
      if (aqeb.a(this.y) != aqeb.a(paramObject.y)) {
        return false;
      }
    } while (aqeb.a(this.z) == aqeb.a(paramObject.z));
    return false;
  }
  
  public int hashCode()
  {
    return ((aqeb.a(this.x) + 31) * 31 + aqeb.a(this.y)) * 31 + aqeb.a(this.z);
  }
  
  public boolean isUnit()
  {
    return len() == 1.0F;
  }
  
  public boolean isZero()
  {
    return (this.x == 0.0F) && (this.y == 0.0F) && (this.z == 0.0F);
  }
  
  public float len()
  {
    return (float)Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
  }
  
  public Vector3 lerp(Vector3 paramVector3, float paramFloat)
  {
    Vector3 localVector3 = mul(1.0F - paramFloat);
    localVector3.add(paramVector3.tmp().mul(paramFloat));
    return localVector3;
  }
  
  public Vector3 mul(float paramFloat)
  {
    return set(this.x * paramFloat, this.y * paramFloat, this.z * paramFloat);
  }
  
  public Vector3 mul(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return set(this.x * paramFloat1, this.y * paramFloat2, this.z * paramFloat3);
  }
  
  public Vector3 mul(Matrix4 paramMatrix4)
  {
    paramMatrix4 = paramMatrix4.val;
    float f1 = this.x;
    float f2 = paramMatrix4[0];
    float f3 = this.y;
    float f4 = paramMatrix4[4];
    float f5 = this.z;
    float f6 = paramMatrix4[8];
    float f7 = paramMatrix4[12];
    float f8 = this.x;
    float f9 = paramMatrix4[1];
    float f10 = this.y;
    float f11 = paramMatrix4[5];
    float f12 = this.z;
    float f13 = paramMatrix4[9];
    float f14 = paramMatrix4[13];
    float f15 = this.x;
    float f16 = paramMatrix4[2];
    float f17 = this.y;
    float f18 = paramMatrix4[6];
    float f19 = this.z;
    float f20 = paramMatrix4[10];
    return set(f1 * f2 + f3 * f4 + f5 * f6 + f7, f8 * f9 + f10 * f11 + f12 * f13 + f14, paramMatrix4[14] + (f15 * f16 + f17 * f18 + f19 * f20));
  }
  
  public Vector3 nor()
  {
    float f = len();
    if (f == 0.0F) {
      return this;
    }
    return div(f);
  }
  
  public Vector3 rotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return rotate(tmp.set(paramFloat2, paramFloat3, paramFloat4), paramFloat1);
  }
  
  public Vector3 rotate(Vector3 paramVector3, float paramFloat)
  {
    a.setToRotation(paramVector3, paramFloat);
    return mul(a);
  }
  
  public Vector3 scale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.x *= paramFloat1;
    this.y *= paramFloat2;
    this.z *= paramFloat3;
    return this;
  }
  
  public Vector3 set(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
    return this;
  }
  
  public Vector3 set(Vector3 paramVector3)
  {
    return set(paramVector3.x, paramVector3.y, paramVector3.z);
  }
  
  public Vector3 set(float[] paramArrayOfFloat)
  {
    return set(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2]);
  }
  
  public Vector3 slerp(Vector3 paramVector3, float paramFloat)
  {
    float f1 = 1.0F;
    float f2 = -1.0F;
    float f3 = dot(paramVector3);
    if ((f3 > 0.99995D) || (f3 < 0.9995000000000001D))
    {
      add(paramVector3.tmp().sub(this).mul(paramFloat));
      nor();
      return this;
    }
    if (f3 > 1.0F) {}
    for (;;)
    {
      if (f1 < -1.0F) {
        f1 = f2;
      }
      for (;;)
      {
        paramFloat = (float)Math.acos(f1) * paramFloat;
        paramVector3 = paramVector3.tmp().sub(this.x * f1, this.y * f1, f1 * this.z);
        paramVector3.nor();
        return mul((float)Math.cos(paramFloat)).add(paramVector3.mul((float)Math.sin(paramFloat))).nor();
      }
      f1 = f3;
    }
  }
  
  public Vector3 sub(float paramFloat)
  {
    return set(this.x - paramFloat, this.y - paramFloat, this.z - paramFloat);
  }
  
  public Vector3 sub(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return set(this.x - paramFloat1, this.y - paramFloat2, this.z - paramFloat3);
  }
  
  public Vector3 sub(Vector3 paramVector3)
  {
    return sub(paramVector3.x, paramVector3.y, paramVector3.z);
  }
  
  public Vector3 tmp()
  {
    return tmp.set(this);
  }
  
  public String toString()
  {
    return this.x + "," + this.y + "," + this.z;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.rotation.Vector3
 * JD-Core Version:    0.7.0.1
 */