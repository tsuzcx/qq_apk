package com.tencent.biz.troopgift;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopGiftPanel$9
  implements View.OnClickListener
{
  TroopGiftPanel$9(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void onClick(View paramView)
  {
    this.a.e();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.9
 * JD-Core Version:    0.7.0.1
 */