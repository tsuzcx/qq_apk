package com.tencent.av.business.manager;

import java.lang.ref.WeakReference;

class EffectOperateManager$MyGoToZimuRunnable
  extends EffectOperateManager.MyGotoRunnable
{
  public void run()
  {
    EffectOperateManager localEffectOperateManager = (EffectOperateManager)this.a.get();
    if (localEffectOperateManager != null) {
      localEffectOperateManager.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectOperateManager.MyGoToZimuRunnable
 * JD-Core Version:    0.7.0.1
 */