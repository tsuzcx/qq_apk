package com.tencent.ilive.opensdk.params;

public class RtcRelaRect
{
  public float h = 1.0F;
  public float w = 1.0F;
  public float x = 0.0F;
  public float y = 0.0F;
  
  public RtcRelaRect() {}
  
  public RtcRelaRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.w = paramFloat3;
    this.h = paramFloat4;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(" ");
    localStringBuilder.append(this.x);
    localStringBuilder.append(",");
    localStringBuilder.append(this.y);
    localStringBuilder.append(",");
    localStringBuilder.append(this.w);
    localStringBuilder.append(",");
    localStringBuilder.append(this.h);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.opensdk.params.RtcRelaRect
 * JD-Core Version:    0.7.0.1
 */