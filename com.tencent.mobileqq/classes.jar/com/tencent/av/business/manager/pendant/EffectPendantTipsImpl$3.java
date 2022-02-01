package com.tencent.av.business.manager.pendant;

import com.tencent.av.tips.TipsUtil;

class EffectPendantTipsImpl$3
  implements Runnable
{
  EffectPendantTipsImpl$3(EffectPendantTipsImpl paramEffectPendantTipsImpl, EffectPendantTips.ClearErrorTipsCallback paramClearErrorTipsCallback) {}
  
  public void run()
  {
    try
    {
      TipsUtil.b(EffectPendantTipsImpl.a(this.this$0), 1016);
      if (this.a != null)
      {
        this.a.a();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.EffectPendantTipsImpl.3
 * JD-Core Version:    0.7.0.1
 */