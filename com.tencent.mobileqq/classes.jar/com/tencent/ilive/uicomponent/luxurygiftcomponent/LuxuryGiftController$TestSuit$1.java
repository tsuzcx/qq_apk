package com.tencent.ilive.uicomponent.luxurygiftcomponent;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ilive.uicomponent.luxurygiftcomponent.utils.RandomUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LuxuryGiftController$TestSuit$1
  implements View.OnClickListener
{
  LuxuryGiftController$TestSuit$1(LuxuryGiftController.TestSuit paramTestSuit) {}
  
  public void onClick(View paramView)
  {
    this.this$1.onPlayH5GiftForTest(RandomUtils.nextInt(3));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.LuxuryGiftController.TestSuit.1
 * JD-Core Version:    0.7.0.1
 */