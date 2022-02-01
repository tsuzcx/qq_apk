package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo.ARVideoLayout;

public class GeneralARResourceInfo
  extends ARRenderResourceInfo
{
  public String i;
  public String j;
  public String k;
  public ArCloudConfigInfo.ARVideoLayout l;
  
  public GeneralARResourceInfo(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, ArCloudConfigInfo.ARVideoLayout paramARVideoLayout, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramString1, paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3);
    this.i = paramString2;
    this.j = paramString3;
    this.k = paramString4;
    this.l = paramARVideoLayout;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("GeneralAR_3D_ResourceInfo{");
    localStringBuilder.append("key=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", arType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", trackMode=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mLuaScriptPath=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", mResourceDirPath='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mMusicPath='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mLayout='");
    localStringBuilder.append(this.l);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.GeneralARResourceInfo
 * JD-Core Version:    0.7.0.1
 */