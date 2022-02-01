package com.tencent.biz.troopgift;

import android.widget.TextView;

class TroopGiftPanel$11$1
  implements Runnable
{
  TroopGiftPanel$11$1(TroopGiftPanel.11 param11, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    TextView localTextView = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$11.a.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("");
    localTextView.setText(localStringBuilder.toString());
    if (this.b > 0)
    {
      localTextView = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$11.a.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("+");
      localStringBuilder.append(this.b);
      localTextView.setText(localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$11.a.c.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$11.a.c.setText("");
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$11.a.c.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.11.1
 * JD-Core Version:    0.7.0.1
 */