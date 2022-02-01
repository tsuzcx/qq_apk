package com.tencent.mobileqq.ar.arengine;

public class ARCloudRecogResultBase
{
  public boolean k = false;
  public ARCloudLBSLocationCheckResult l = null;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARCloudRecogResultBase{hasLBSLocation = ");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", checkResult = ");
    localStringBuilder.append(this.l);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudRecogResultBase
 * JD-Core Version:    0.7.0.1
 */