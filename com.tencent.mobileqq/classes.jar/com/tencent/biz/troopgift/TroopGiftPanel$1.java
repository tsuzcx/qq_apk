package com.tencent.biz.troopgift;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopGiftPanel$1
  implements AdapterView.OnItemClickListener
{
  TroopGiftPanel$1(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.onTabSelected(0, paramInt);
    paramView.setSelected(true);
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.1
 * JD-Core Version:    0.7.0.1
 */