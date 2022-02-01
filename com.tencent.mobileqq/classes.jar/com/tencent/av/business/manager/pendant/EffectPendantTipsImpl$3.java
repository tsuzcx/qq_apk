package com.tencent.av.business.manager.pendant;

import android.text.TextUtils;
import lho;
import maf;

public class EffectPendantTipsImpl$3
  implements Runnable
{
  public EffectPendantTipsImpl$3(lho paramlho, int paramInt) {}
  
  public void run()
  {
    try
    {
      if (this.a != 0)
      {
        String str = this.this$0.a(lho.a(this.this$0), this.a);
        if (!TextUtils.isEmpty(str)) {
          maf.a(lho.a(this.this$0), 1016, str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.EffectPendantTipsImpl.3
 * JD-Core Version:    0.7.0.1
 */