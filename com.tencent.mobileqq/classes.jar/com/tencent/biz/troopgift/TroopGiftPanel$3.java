package com.tencent.biz.troopgift;

import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopGiftPanel$3
  implements View.OnClickListener
{
  TroopGiftPanel$3(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void onClick(View paramView)
  {
    TroopGiftPanel.b(this.a).setSelected(false);
    this.a.E.a(-1);
    TroopGiftPanel.a(this.a).setSelected(true);
    ((TextView)TroopGiftPanel.b(this.a).findViewById(2131448499)).setTextColor(Color.parseColor("#ff878b99"));
    TroopGiftPanel.b(this.a).findViewById(2131449821).setVisibility(8);
    ((TextView)TroopGiftPanel.a(this.a).findViewById(2131448496)).setTextColor(Color.parseColor("#ffff5b84"));
    TroopGiftPanel.a(this.a).findViewById(2131449827).setVisibility(0);
    TroopGiftPanel localTroopGiftPanel = this.a;
    localTroopGiftPanel.onTabSelected(localTroopGiftPanel.k, TroopGiftPanel.d);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.3
 * JD-Core Version:    0.7.0.1
 */