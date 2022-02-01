package com.tencent.mobileqq.armap.sensor.rotation;

import java.io.Serializable;

public class Vector2
  implements Serializable
{
  public static final Vector2 X = new Vector2(1.0F, 0.0F);
  public static final Vector2 Y = new Vector2(0.0F, 1.0F);
  public static final Vector2 Zero = new Vector2(0.0F, 0.0F);
  private static final long serialVersionUID = 913902788239530931L;
  public static final Vector2 tmp = new Vector2();
  public static final Vector2 tmp2 = new Vector2();
  public static final Vector2 tmp3 = new Vector2();
  public float x;
  public float y;
  
  public Vector2() {}
  
  public Vector2(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  public Vector2(Vector2 paramVector2)
  {
    set(paramVector2);
  }
  
  public Vector2 add(float paramFloat1, float paramFloat2)
  {
    this.x += paramFloat1;
    this.y += paramFloat2;
    return this;
  }
  
  public Vector2 add(Vector2 paramVector2)
  {
    this.x += paramVector2.x;
    this.y += paramVector2.y;
    return this;
  }
  
  public float angle()
  {
    float f2 = (float)Math.atan2(this.y, this.x) * 57.295776F;
    float f1 = f2;
    if (f2 < 0.0F) {
      f1 = f2 + 360.0F;
    }
    return f1;
  }
  
  public float dot(Vector2 paramVector2)
  {
    return this.x * paramVector2.x + this.y * paramVector2.y;
  }
  
  public float dst(float paramFloat1, float paramFloat2)
  {
    paramFloat1 -= this.x;
    paramFloat2 -= this.y;
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public float dst(Vector2 paramVector2)
  {
    float f1 = paramVector2.x - this.x;
    float f2 = paramVector2.y - this.y;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
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
    paramObject = (Vector2)paramObject;
    if (NumberUtils.a(this.x) != NumberUtils.a(paramObject.x)) {
      return false;
    }
    return NumberUtils.a(this.y) == NumberUtils.a(paramObject.y);
  }
  
  public int hashCode()
  {
    return (NumberUtils.a(this.x) + 31) * 31 + NumberUtils.a(this.y);
  }
  
  public float len()
  {
    float f1 = this.x;
    float f2 = this.y;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public Vector2 lerp(Vector2 paramVector2, float paramFloat)
  {
    Vector2 localVector2 = mul(1.0F - paramFloat);
    localVector2.add(paramVector2.tmp().mul(paramFloat));
    return localVector2;
  }
  
  public Vector2 mul(float paramFloat)
  {
    this.x *= paramFloat;
    this.y *= paramFloat;
    return this;
  }
  
  public Vector2 nor()
  {
    float f = len();
    if (f != 0.0F)
    {
      this.x /= f;
      this.y /= f;
    }
    return this;
  }
  
  public Vector2 rotate(float paramFloat)
  {
    double d = paramFloat * 0.01745329F;
    paramFloat = (float)Math.cos(d);
    float f1 = (float)Math.sin(d);
    float f2 = this.x;
    float f3 = this.y;
    this.x = (f2 * paramFloat - f3 * f1);
    this.y = (f2 * f1 + f3 * paramFloat);
    return this;
  }
  
  public Vector2 set(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    return this;
  }
  
  public Vector2 set(Vector2 paramVector2)
  {
    this.x = paramVector2.x;
    this.y = paramVector2.y;
    return this;
  }
  
  public void setAngle(float paramFloat)
  {
    set(len(), 0.0F);
    rotate(paramFloat);
  }
  
  public Vector2 sub(float paramFloat1, float paramFloat2)
  {
    this.x -= paramFloat1;
    this.y -= paramFloat2;
    return this;
  }
  
  public Vector2 sub(Vector2 paramVector2)
  {
    this.x -= paramVector2.x;
    this.y -= paramVector2.y;
    return this;
  }
  
  public Vector2 tmp()
  {
    return tmp.set(this);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.x);
    localStringBuilder.append(":");
    localStringBuilder.append(this.y);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.rotation.Vector2
 * JD-Core Version:    0.7.0.1
 */