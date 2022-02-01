package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

public class ARLocalMarkerRecogResult
  extends ARLocalRecogResultBase
{
  public long a = 0L;
  public int b = 2;
  public String c = "";
  public int d = 0;
  public float e = 0.0F;
  public float f = 0.0F;
  public float g = 0.0F;
  public float[] h = null;
  public ArCloudConfigInfo i = null;
  
  public ARLocalMarkerRecogResult()
  {
    this.j = 1L;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARLocalMarkerRecogResult{recogType = ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", frameIdx = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", state = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", markerName = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", markerType = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", markerWidth = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", markerHeight = ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", markerDiameter = ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", pose = ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", arResourceInfo = ");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalMarkerRecogResult
 * JD-Core Version:    0.7.0.1
 */