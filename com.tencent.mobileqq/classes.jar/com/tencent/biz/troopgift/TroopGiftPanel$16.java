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
    this.a.jdField_a_of_type_AndroidWidgetButton.setText(TroopGiftPanel.a(this.a));
    TroopGiftPanel.a(this.a, 0L);
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131715205), 0).b(this.a.getResources().getDimensionPixelSize(2131299168));
    TroopGiftPanel.a(true);
  }
  
  public void b(int paramInt, String paramString)
  {
    super.b(paramInt, paramString);
    QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131715172), 0).b(this.a.getResources().getDimensionPixelSize(2131299168));
    TroopGiftPanel.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.16
 * JD-Core Version:    0.7.0.1
 */