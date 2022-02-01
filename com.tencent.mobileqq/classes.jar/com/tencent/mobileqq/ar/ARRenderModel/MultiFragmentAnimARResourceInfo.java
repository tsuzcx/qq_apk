package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

public class MultiFragmentAnimARResourceInfo
  extends ARRenderResourceInfo
{
  public ArCloudConfigInfo i;
  
  public MultiFragmentAnimARResourceInfo(String paramString, int paramInt1, int paramInt2, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramString, paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3);
    this.i = paramArCloudConfigInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MultiFragmentAnimARResourceInfo{");
    localStringBuilder.append("key=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", arType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", trackMode=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", arResourceInfo=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimARResourceInfo
 * JD-Core Version:    0.7.0.1
 */