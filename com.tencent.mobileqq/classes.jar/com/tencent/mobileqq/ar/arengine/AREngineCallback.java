package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMangerInnerCallback;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderTrackInfo;
import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;

public abstract interface AREngineCallback
{
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt1, ARTarget paramARTarget, int paramInt2);
  
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(long paramLong, int paramInt, ARRenderTrackInfo paramARRenderTrackInfo, ARLocalRecogResultBase paramARLocalRecogResultBase);
  
  public abstract void a(long paramLong, ARTarget paramARTarget);
  
  public abstract void a(long paramLong, boolean paramBoolean, ARTarget paramARTarget);
  
  public abstract void a(ArCloudConfigInfo paramArCloudConfigInfo1, ArCloudConfigInfo paramArCloudConfigInfo2, int paramInt1, int paramInt2, Object paramObject);
  
  public abstract void a(ARCloudLBSLocationCheckResult paramARCloudLBSLocationCheckResult, ArLBSActivity paramArLBSActivity);
  
  public abstract void a(ArVideoResourceInfo paramArVideoResourceInfo, ARRenderMangerInnerCallback paramARRenderMangerInnerCallback);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.AREngineCallback
 * JD-Core Version:    0.7.0.1
 */