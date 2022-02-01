package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.util.WeakReferenceHandler;

class VipProfileCardDiyActivity$HiBoomTemplateView$1
  extends CallBacker
{
  VipProfileCardDiyActivity$HiBoomTemplateView$1(VipProfileCardDiyActivity.HiBoomTemplateView paramHiBoomTemplateView, VipProfileCardDiyActivity paramVipProfileCardDiyActivity) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (VipProfileCardDiyActivity.a(paramLong, paramString1, this.b.e))
    {
      if (paramInt1 == 0)
      {
        paramString1 = this.b;
        paramString1.f = 2;
        paramString1.h.ah.removeCallBacker(this);
      }
      else
      {
        this.b.f = 0;
      }
      paramString1 = this.b.h.ak.obtainMessage(5, paramInt1, 0);
      paramString1.obj = this.b.d;
      this.b.h.ak.sendMessage(paramString1);
    }
  }
  
  public void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    if (VipProfileCardDiyActivity.a(paramLong1, paramString1, this.b.e))
    {
      paramString1 = this.b.h.ak.obtainMessage(4);
      double d1 = paramLong2;
      double d2 = paramLong3;
      Double.isNaN(d1);
      Double.isNaN(d2);
      d1 /= d2;
      d2 = this.b.getHeight();
      Double.isNaN(d2);
      paramString1.arg1 = ((int)(d2 * d1));
      paramString1.obj = this.b.d;
      this.b.h.ak.sendMessage(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity.HiBoomTemplateView.1
 * JD-Core Version:    0.7.0.1
 */