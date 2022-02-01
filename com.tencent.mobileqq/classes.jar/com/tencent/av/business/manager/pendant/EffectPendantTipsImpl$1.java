package com.tencent.av.business.manager.pendant;

import android.text.TextUtils;
import com.tencent.av.tips.TipsUtil;

class EffectPendantTipsImpl$1
  implements Runnable
{
  EffectPendantTipsImpl$1(EffectPendantTipsImpl paramEffectPendantTipsImpl, String paramString) {}
  
  public void run()
  {
    try
    {
      if (!TextUtils.isEmpty(this.a)) {
        TipsUtil.a(EffectPendantTipsImpl.a(this.this$0), 1016, this.a);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.EffectPendantTipsImpl.1
 * JD-Core Version:    0.7.0.1
 */