package com.tencent.biz.troopgift;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopGiftPanel$4
  implements View.OnClickListener
{
  TroopGiftPanel$4(TroopGiftPanel paramTroopGiftPanel, TroopGiftAioPanelData.WebPanelItemInfo paramWebPanelItemInfo) {}
  
  public void onClick(View paramView)
  {
    if (this.a.b == 1) {
      this.b.b(this.a.d);
    } else {
      TroopGiftPanel.a(this.b, this.a.d);
    }
    ReportController.b(null, "dc00899", "grp_lbs", "", "qq_gift", "aio_top_click", 0, 0, this.b.getTroopUin(), "", "", this.a.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.4
 * JD-Core Version:    0.7.0.1
 */