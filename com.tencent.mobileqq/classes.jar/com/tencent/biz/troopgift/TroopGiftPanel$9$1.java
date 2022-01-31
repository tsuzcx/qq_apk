package com.tencent.biz.troopgift;

import android.widget.TextView;
import yrr;

public class TroopGiftPanel$9$1
  implements Runnable
{
  public TroopGiftPanel$9$1(yrr paramyrr, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.jdField_a_of_type_Yrr.a.b.setText(this.jdField_a_of_type_Int + "");
    if (this.b > 0)
    {
      this.jdField_a_of_type_Yrr.a.c.setText("+" + this.b);
      this.jdField_a_of_type_Yrr.a.c.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_Yrr.a.c.setText("");
    this.jdField_a_of_type_Yrr.a.c.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.9.1
 * JD-Core Version:    0.7.0.1
 */