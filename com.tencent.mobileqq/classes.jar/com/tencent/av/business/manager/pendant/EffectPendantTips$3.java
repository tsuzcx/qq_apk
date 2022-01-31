package com.tencent.av.business.manager.pendant;

import android.text.TextUtils;
import lks;
import mdd;

public class EffectPendantTips$3
  implements Runnable
{
  public EffectPendantTips$3(lks paramlks, int paramInt) {}
  
  public void run()
  {
    try
    {
      if (this.a != 0)
      {
        String str = this.this$0.a(lks.a(this.this$0), this.a);
        if (!TextUtils.isEmpty(str)) {
          mdd.a(lks.a(this.this$0), 1016, str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.EffectPendantTips.3
 * JD-Core Version:    0.7.0.1
 */