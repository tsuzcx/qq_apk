package com.tencent.mobileqq.armap.sensor.rotation;

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
    float f1 = this.y;
    float f2 = paramVector3.z;
    float f3 = this.z;
    float f4 = paramVector3.y;
    float f5 = paramVector3.x;
    float f6 = this.x;
    return set(f1 * f2 - f3 * f4, f3 * f5 - f2 * f6, f6 * f4 - f1 * f5);
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
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (Vector3)paramObject;
    if (NumberUtils.a(this.x) != NumberUtils.a(paramObject.x)) {
      return false;
    }
    if (NumberUtils.a(this.y) != NumberUtils.a(paramObject.y)) {
      return false;
    }
    return NumberUtils.a(this.z) == NumberUtils.a(paramObject.z);
  }
  
  public int hashCode()
  {
    return ((NumberUtils.a(this.x) + 31) * 31 + NumberUtils.a(this.y)) * 31 + NumberUtils.a(this.z);
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
    float f1 = this.x;
    float f2 = this.y;
    float f3 = this.z;
    return (float)Math.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
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
    return set(f2 * f1 + f4 * f3 + paramMatrix4[8] * f5 + paramMatrix4[12], paramMatrix4[1] * f1 + paramMatrix4[5] * f3 + paramMatrix4[9] * f5 + paramMatrix4[13], f1 * paramMatrix4[2] + f3 * paramMatrix4[6] + f5 * paramMatrix4[10] + paramMatrix4[14]);
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
    float f2 = dot(paramVector3);
    double d = f2;
    if ((d <= 0.99995D) && (d >= 0.9995000000000001D))
    {
      float f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      f2 = f1;
      if (f1 < -1.0F) {
        f2 = -1.0F;
      }
      f1 = (float)Math.acos(f2);
      paramVector3 = paramVector3.tmp().sub(this.x * f2, this.y * f2, this.z * f2);
      paramVector3.nor();
      d = f1 * paramFloat;
      return mul((float)Math.cos(d)).add(paramVector3.mul((float)Math.sin(d))).nor();
    }
    add(paramVector3.tmp().sub(this).mul(paramFloat));
    nor();
    return this;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.x);
    localStringBuilder.append(",");
    localStringBuilder.append(this.y);
    localStringBuilder.append(",");
    localStringBuilder.append(this.z);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.rotation.Vector3
 * JD-Core Version:    0.7.0.1
 */