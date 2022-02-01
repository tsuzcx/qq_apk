package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.biz.troopgift.TroopGiftPanel.OnShowOrHideListerner;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.nearby.gift.INearbyGiftPanelDialog;

class NearByGiftPanelHelper$1
  implements TroopGiftPanel.OnShowOrHideListerner
{
  NearByGiftPanelHelper$1(NearByGiftPanelHelper paramNearByGiftPanelHelper) {}
  
  public void a()
  {
    INearbyGiftPanelDialog localINearbyGiftPanelDialog = this.a.g;
    int i;
    if (this.a.b.O().a == 10002) {
      i = 8;
    } else {
      i = 6;
    }
    localINearbyGiftPanelDialog.a(false, true, i);
  }
  
  public void b()
  {
    this.a.g.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.NearByGiftPanelHelper.1
 * JD-Core Version:    0.7.0.1
 */