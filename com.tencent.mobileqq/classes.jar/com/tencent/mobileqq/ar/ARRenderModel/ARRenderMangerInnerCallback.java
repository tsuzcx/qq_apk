package com.tencent.mobileqq.ar.ARRenderModel;

import android.content.Context;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.UniformGLRenderManager;

public abstract interface ARRenderMangerInnerCallback
{
  public abstract Context a();
  
  public abstract Object a(int paramInt);
  
  public abstract void a(ARBaseRender paramARBaseRender, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt1, int paramInt2, Object paramObject);
  
  public abstract void a(ArVideoResourceInfo paramArVideoResourceInfo);
  
  public abstract void a(ArVideoResourceInfo paramArVideoResourceInfo, ARRenderMangerInnerCallback paramARRenderMangerInnerCallback);
  
  public abstract void a(Runnable paramRunnable);
  
  public abstract void a(String paramString);
  
  public abstract void b();
  
  public abstract void b(int paramInt1, int paramInt2);
  
  public abstract ARRenerArumentManager c();
  
  public abstract UniformGLRenderManager d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARRenderMangerInnerCallback
 * JD-Core Version:    0.7.0.1
 */