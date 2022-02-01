package com.tencent.mobileqq.ar.view;

import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.model.ScanEntryResourceDelegate;
import com.tencent.mobileqq.ar.model.UniformGLRenderManager;
import com.tencent.mobileqq.olympic.activity.PromotionRes;

public abstract interface ScanEntryContainerViewListener
{
  public abstract void a(boolean paramBoolean);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract ARCommonConfigInfo getARCommonConfig();
  
  public abstract PromotionRes getPromotionManager();
  
  public abstract UniformGLRenderManager getRenderEngine();
  
  public abstract ScanEntryResourceDelegate getUniformResManger();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanEntryContainerViewListener
 * JD-Core Version:    0.7.0.1
 */