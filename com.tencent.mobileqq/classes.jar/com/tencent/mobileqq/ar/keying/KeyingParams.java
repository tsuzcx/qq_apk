package com.tencent.mobileqq.ar.keying;

public class KeyingParams
{
  public int a = 0;
  public float b = 0.0F;
  public float c = 0.0F;
  public float d = 0.0F;
  public float e = 0.0F;
  public float f = 0.0F;
  public float g = 1.0F;
  public float h = 0.0F;
  public float i = 1.0F;
  public float j = 0.0F;
  public String k = null;
  
  public KeyingParams() {}
  
  public KeyingParams(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.b = paramFloat1;
    this.c = paramFloat2;
    this.d = paramFloat3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KeyingParams {keyType: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", screenColorR: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", screenColorG: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", screenColorB: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", uA: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", uD: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", u_threshold: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", u_clipBlack: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", u_clipWhite: ");
    localStringBuilder.append(this.i);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.keying.KeyingParams
 * JD-Core Version:    0.7.0.1
 */