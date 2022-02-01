package com.tencent.av.business.manager.pendant;

import android.text.TextUtils;
import com.tencent.av.tips.TipsUtil;

class EffectPendantTipsImpl$3
  implements Runnable
{
  EffectPendantTipsImpl$3(EffectPendantTipsImpl paramEffectPendantTipsImpl, int paramInt) {}
  
  public void run()
  {
    try
    {
      String str = this.this$0.a(EffectPendantTipsImpl.a(this.this$0), this.a);
      if (!TextUtils.isEmpty(str)) {
        TipsUtil.a(EffectPendantTipsImpl.a(this.this$0), 1016, str);
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
 * Qualified Name:     com.tencent.av.business.manager.pendant.EffectPendantTipsImpl.3
 * JD-Core Version:    0.7.0.1
 */