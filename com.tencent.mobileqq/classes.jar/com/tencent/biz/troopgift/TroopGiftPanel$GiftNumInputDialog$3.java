package com.tencent.biz.troopgift;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.GiftPanelHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class TroopGiftPanel$GiftNumInputDialog$3
  implements View.OnClickListener
{
  TroopGiftPanel$GiftNumInputDialog$3(TroopGiftPanel.GiftNumInputDialog paramGiftNumInputDialog, TroopGiftPanel paramTroopGiftPanel) {}
  
  public void onClick(View paramView)
  {
    this.b.c();
    this.b.b();
    if (this.b.e.F) {
      this.b.e.G.b();
    } else {
      ((GiftPanelHelper)((BaseChatPie)this.b.e.C.get()).q(136)).e();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.GiftNumInputDialog.3
 * JD-Core Version:    0.7.0.1
 */