package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo.WorldCupResPath;
import com.tencent.qphone.base.util.QLog;

public class ARWorldCupResourceInfo
  extends ARRenderResourceInfo
{
  ArCloudConfigInfo.WorldCupResPath a;
  
  public ARWorldCupResourceInfo(String paramString, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, ArCloudConfigInfo.WorldCupResPath paramWorldCupResPath)
  {
    super(paramString, paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3);
    QLog.d("ARWorldCupResourceInfo", 2, "resPath = " + paramWorldCupResPath);
    this.a = paramWorldCupResPath;
  }
  
  public String a()
  {
    if (this.a != null) {
      return this.a.f;
    }
    return null;
  }
  
  public String b()
  {
    if (this.a != null) {
      return this.a.g;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupResourceInfo
 * JD-Core Version:    0.7.0.1
 */