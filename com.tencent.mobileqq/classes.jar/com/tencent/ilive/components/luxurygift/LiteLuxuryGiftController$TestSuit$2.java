package com.tencent.ilive.components.luxurygift;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ilive.uicomponent.luxurygiftcomponent.utils.RandomUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LiteLuxuryGiftController$TestSuit$2
  implements View.OnClickListener
{
  LiteLuxuryGiftController$TestSuit$2(LiteLuxuryGiftController.TestSuit paramTestSuit) {}
  
  public void onClick(View paramView)
  {
    this.this$1.onPlayH264GiftForTest(RandomUtils.nextInt(3));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.components.luxurygift.LiteLuxuryGiftController.TestSuit.2
 * JD-Core Version:    0.7.0.1
 */