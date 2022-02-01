package com.tencent.mobileqq.ar.view;

import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.model.ScanEntryResourceDelegate;
import com.tencent.mobileqq.ar.model.UniformGLRenderManager;
import com.tencent.mobileqq.olympic.activity.PromotionRes;

public abstract interface ScanEntryContainerViewListener
{
  public abstract ARCommonConfigInfo a();
  
  public abstract ScanEntryResourceDelegate a();
  
  public abstract UniformGLRenderManager a();
  
  public abstract PromotionRes a();
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanEntryContainerViewListener
 * JD-Core Version:    0.7.0.1
 */