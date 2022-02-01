package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo.ARVideoLayout;
import com.tencent.mobileqq.ar.keying.KeyingParams;

public class NormalVideoARResourceInfo
  extends ARRenderResourceInfo
{
  public int i;
  public String j;
  public int k = 1;
  public KeyingParams l;
  public ArCloudConfigInfo.ARVideoLayout m;
  
  public NormalVideoARResourceInfo(String paramString1, int paramInt1, int paramInt2, int paramInt3, KeyingParams paramKeyingParams, ArCloudConfigInfo.ARVideoLayout paramARVideoLayout, String paramString2, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramString1, paramInt1, paramInt2, paramInt5, paramFloat1, paramFloat2, paramFloat3);
    this.i = paramInt3;
    this.j = paramString2;
    this.k = paramInt4;
    this.l = paramKeyingParams;
    this.m = paramARVideoLayout;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("NormalVideoARResourceInfo{");
    localStringBuilder.append("key=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", arType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", trackMode=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mRealRenderType=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", mKeyingParams='");
    localStringBuilder.append(this.l);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mVideoPath='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mLayout='");
    localStringBuilder.append(this.m);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.NormalVideoARResourceInfo
 * JD-Core Version:    0.7.0.1
 */