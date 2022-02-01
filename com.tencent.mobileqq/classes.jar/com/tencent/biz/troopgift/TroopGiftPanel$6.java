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
    String str2 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$AioActivityBubble.b;
    String str3 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$WebPanelItemInfo.jdField_a_of_type_JavaLangString;
    float f = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getProgress();
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$AioActivityBubble.a.iterator();
    do
    {
      str1 = str2;
      localObject = str3;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (TroopGiftAioPanelData.AioActivity)localIterator.next();
    } while ((f < ((TroopGiftAioPanelData.AioActivity)localObject).jdField_a_of_type_Float) || (f >= ((TroopGiftAioPanelData.AioActivity)localObject).b));
    String str1 = ((TroopGiftAioPanelData.AioActivity)localObject).d;
    Object localObject = ((TroopGiftAioPanelData.AioActivity)localObject).jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b(str1);
    ReportController.b(null, "dc00899", "grp_lbs", "", "qq_gift", "aio_top_click", 0, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "", "", (String)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.6
 * JD-Core Version:    0.7.0.1
 */