package com.tencent.biz.troopgift;

import android.widget.TextView;

class TroopGiftPanel$11$1
  implements Runnable
{
  TroopGiftPanel$11$1(TroopGiftPanel.11 param11, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    TextView localTextView = this.c.b.s;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("");
    localTextView.setText(localStringBuilder.toString());
    if (this.b > 0)
    {
      localTextView = this.c.b.t;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("+");
      localStringBuilder.append(this.b);
      localTextView.setText(localStringBuilder.toString());
      this.c.b.t.setVisibility(0);
      return;
    }
    this.c.b.t.setText("");
    this.c.b.t.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.11.1
 * JD-Core Version:    0.7.0.1
 */