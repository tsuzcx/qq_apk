package com.tencent.mobileqq.ar.arengine;

import com.tencent.YTFace.model.FaceStatus;

public class ARCloudRecogReqFaceInfo
{
  public int a = 3000;
  public FaceStatus[] a;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARCloudRecogReqFaceInfo{timeout = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudRecogReqFaceInfo
 * JD-Core Version:    0.7.0.1
 */