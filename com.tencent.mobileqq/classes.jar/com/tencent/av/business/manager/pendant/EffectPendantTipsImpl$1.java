package com.tencent.av.business.manager.pendant;

import android.text.TextUtils;
import lhw;
import mbb;

public class EffectPendantTipsImpl$1
  implements Runnable
{
  public EffectPendantTipsImpl$1(lhw paramlhw, String paramString) {}
  
  public void run()
  {
    try
    {
      if (!TextUtils.isEmpty(this.a)) {
        mbb.a(lhw.a(this.this$0), 1016, this.a);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.EffectPendantTipsImpl.1
 * JD-Core Version:    0.7.0.1
 */