package com.tencent.av.business.manager.pendant;

import android.text.TextUtils;
import lip;
import mao;

public class EffectPendantTips$3
  implements Runnable
{
  public EffectPendantTips$3(lip paramlip, int paramInt) {}
  
  public void run()
  {
    try
    {
      if (this.a != 0)
      {
        String str = this.this$0.a(lip.a(this.this$0), this.a);
        if (!TextUtils.isEmpty(str)) {
          mao.a(lip.a(this.this$0), 1016, str);
        }
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
 * Qualified Name:     com.tencent.av.business.manager.pendant.EffectPendantTips.3
 * JD-Core Version:    0.7.0.1
 */