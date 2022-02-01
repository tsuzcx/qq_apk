package com.tencent.biz.troopgift;

import android.content.res.Resources;
import android.widget.Button;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.widget.QQToast;

class TroopGiftPanel$16
  extends TroopGiftCallback
{
  TroopGiftPanel$16(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.a.x.setText(TroopGiftPanel.d(this.a));
    TroopGiftPanel.a(this.a, 0L);
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    QQToast.makeText(this.a.m, HardCodeUtil.a(2131912688), 0).show(this.a.getResources().getDimensionPixelSize(2131299920));
    TroopGiftPanel.c(true);
  }
  
  public void b(int paramInt, String paramString)
  {
    super.b(paramInt, paramString);
    QQToast.makeText(this.a.m, HardCodeUtil.a(2131912659), 0).show(this.a.getResources().getDimensionPixelSize(2131299920));
    TroopGiftPanel.c(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.16
 * JD-Core Version:    0.7.0.1
 */