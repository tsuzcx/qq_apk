package com.tencent.biz.troopgift;

import aaww;
import android.widget.TextView;

public class TroopGiftPanel$11$1
  implements Runnable
{
  public TroopGiftPanel$11$1(aaww paramaaww, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aaww.a.b.setText(this.jdField_a_of_type_Int + "");
    if (this.b > 0)
    {
      this.jdField_a_of_type_Aaww.a.c.setText("+" + this.b);
      this.jdField_a_of_type_Aaww.a.c.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_Aaww.a.c.setText("");
    this.jdField_a_of_type_Aaww.a.c.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.11.1
 * JD-Core Version:    0.7.0.1
 */