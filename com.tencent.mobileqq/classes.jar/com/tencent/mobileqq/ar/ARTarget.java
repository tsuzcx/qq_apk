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
    return "ARTarget{arResourceInfo=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARTarget
 * JD-Core Version:    0.7.0.1
 */