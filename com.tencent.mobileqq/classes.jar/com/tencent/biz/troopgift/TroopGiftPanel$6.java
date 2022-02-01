package com.tencent.biz.troopgift;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

class TroopGiftPanel$6
  implements View.OnClickListener
{
  TroopGiftPanel$6(TroopGiftPanel paramTroopGiftPanel, TroopGiftAioPanelData.AioActivityBubble paramAioActivityBubble, TroopGiftAioPanelData.WebPanelItemInfo paramWebPanelItemInfo, DiniFlyAnimationView paramDiniFlyAnimationView) {}
  
  public void onClick(View paramView)
  {
    String str1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$AioActivityBubble.b;
    String str2 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$WebPanelItemInfo.jdField_a_of_type_JavaLangString;
    float f = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getProgress();
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$AioActivityBubble.a.iterator();
    while (localIterator.hasNext())
    {
      TroopGiftAioPanelData.AioActivity localAioActivity = (TroopGiftAioPanelData.AioActivity)localIterator.next();
      if ((f >= localAioActivity.jdField_a_of_type_Float) && (f < localAioActivity.b))
      {
        str1 = localAioActivity.d;
        str2 = localAioActivity.jdField_a_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b(str1);
      ReportController.b(null, "dc00899", "grp_lbs", "", "qq_gift", "aio_top_click", 0, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "", "", str2);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.6
 * JD-Core Version:    0.7.0.1
 */