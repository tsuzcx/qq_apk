package com.tencent.mobileqq.ar.ARRenderModel;

import android.content.Context;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;

public abstract interface ARRenderMangerInnerCallback
{
  public abstract Context a();
  
  public abstract ARRenerArumentManager a();
  
  public abstract Object a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(ARBaseRender paramARBaseRender, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt1, int paramInt2, Object paramObject);
  
  public abstract void a(ArVideoResourceInfo paramArVideoResourceInfo);
  
  public abstract void a(ArVideoResourceInfo paramArVideoResourceInfo, ARRenderMangerInnerCallback paramARRenderMangerInnerCallback);
  
  public abstract void a(Runnable paramRunnable);
  
  public abstract void a(String paramString);
  
  public abstract void f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARRenderMangerInnerCallback
 * JD-Core Version:    0.7.0.1
 */