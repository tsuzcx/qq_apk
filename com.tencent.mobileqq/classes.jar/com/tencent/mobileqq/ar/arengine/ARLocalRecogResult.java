package com.tencent.mobileqq.ar.arengine;

public class ARLocalRecogResult
{
  public long a = 0L;
  public ARLocalMarkerRecogResult b = null;
  public ARLocalFaceRecogResult c = null;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARLocalRecogResult{frameIdx = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", markerResult = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", faceResult = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalRecogResult
 * JD-Core Version:    0.7.0.1
 */