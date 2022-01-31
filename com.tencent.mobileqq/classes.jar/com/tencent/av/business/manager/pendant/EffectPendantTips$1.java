package com.tencent.av.business.manager.pendant;

import android.text.TextUtils;
import kyc;
import lqb;

public class EffectPendantTips$1
  implements Runnable
{
  public EffectPendantTips$1(kyc paramkyc, String paramString) {}
  
  public void run()
  {
    try
    {
      if (!TextUtils.isEmpty(this.a)) {
        lqb.a(kyc.a(this.this$0), 1016, this.a);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.EffectPendantTips.1
 * JD-Core Version:    0.7.0.1
 */