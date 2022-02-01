package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

public class ARTarget
{
  public ArCloudConfigInfo a;
  
  public ARTarget(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    this.a = paramArCloudConfigInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARTarget{arResourceInfo=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARTarget
 * JD-Core Version:    0.7.0.1
 */