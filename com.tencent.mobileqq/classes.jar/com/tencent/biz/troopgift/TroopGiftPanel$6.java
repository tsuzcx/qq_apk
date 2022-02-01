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
    String str2 = this.a.e;
    String str3 = this.b.a;
    float f = this.c.getProgress();
    Iterator localIterator = this.a.f.iterator();
    do
    {
      str1 = str2;
      localObject = str3;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (TroopGiftAioPanelData.AioActivity)localIterator.next();
    } while ((f < ((TroopGiftAioPanelData.AioActivity)localObject).e) || (f >= ((TroopGiftAioPanelData.AioActivity)localObject).f));
    String str1 = ((TroopGiftAioPanelData.AioActivity)localObject).d;
    Object localObject = ((TroopGiftAioPanelData.AioActivity)localObject).a;
    this.d.b(str1);
    ReportController.b(null, "dc00899", "grp_lbs", "", "qq_gift", "aio_top_click", 0, 0, this.d.getTroopUin(), "", "", (String)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.6
 * JD-Core Version:    0.7.0.1
 */