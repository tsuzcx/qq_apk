package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;

public abstract interface ARRenderManagerCallBack
{
  public abstract void a();
  
  public abstract void a(ArCloudConfigInfo paramArCloudConfigInfo, int paramInt1, int paramInt2, Object paramObject);
  
  public abstract void a(ArVideoResourceInfo paramArVideoResourceInfo, ARRenderMangerInnerCallback paramARRenderMangerInnerCallback);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void b(String paramString, int paramInt);
  
  public abstract void c(String paramString, int paramInt);
  
  public abstract void d(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARRenderManagerCallBack
 * JD-Core Version:    0.7.0.1
 */