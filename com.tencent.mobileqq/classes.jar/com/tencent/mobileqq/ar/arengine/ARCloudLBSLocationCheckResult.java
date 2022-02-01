package com.tencent.mobileqq.ar.arengine;

public class ARCloudLBSLocationCheckResult
{
  public int a = -1;
  public String b = "";
  public ARCloudLBSLocationCheckResult.POIInfo c = null;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARCloudLBSLocationCheckResult{retCode = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", imageId = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", nearestPOIInfo = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudLBSLocationCheckResult
 * JD-Core Version:    0.7.0.1
 */