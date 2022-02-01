package com.tencent.av.business.manager.pendant;

import android.text.TextUtils;
import com.tencent.av.tips.TipsUtil;

class EffectPendantTipsImpl$2
  implements Runnable
{
  EffectPendantTipsImpl$2(EffectPendantTipsImpl paramEffectPendantTipsImpl, int paramInt) {}
  
  public void run()
  {
    try
    {
      String str = this.this$0.a(EffectPendantTipsImpl.b(this.this$0), this.a);
      if (!TextUtils.isEmpty(str))
      {
        TipsUtil.a(EffectPendantTipsImpl.a(this.this$0), 1016, str);
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
 * Qualified Name:     com.tencent.av.business.manager.pendant.EffectPendantTipsImpl.2
 * JD-Core Version:    0.7.0.1
 */