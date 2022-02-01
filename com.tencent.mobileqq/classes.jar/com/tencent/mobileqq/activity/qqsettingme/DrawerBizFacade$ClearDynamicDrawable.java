package com.tencent.mobileqq.activity.qqsettingme;

import com.tencent.qqperf.opt.clearmemory.MemoryClearManager.IClearMemoryListener;
import mqq.util.WeakReference;

class DrawerBizFacade$ClearDynamicDrawable
  implements MemoryClearManager.IClearMemoryListener
{
  private final WeakReference<DrawerBizFacade> a;
  
  public DrawerBizFacade$ClearDynamicDrawable(DrawerBizFacade paramDrawerBizFacade)
  {
    this.a = new WeakReference(paramDrawerBizFacade);
  }
  
  public int a()
  {
    DrawerBizFacade localDrawerBizFacade = (DrawerBizFacade)this.a.get();
    if (localDrawerBizFacade != null) {
      return localDrawerBizFacade.a();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.DrawerBizFacade.ClearDynamicDrawable
 * JD-Core Version:    0.7.0.1
 */