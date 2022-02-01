package com.tencent.ilive.uicomponent.luxurygiftcomponent;

import android.view.LayoutInflater;
import android.view.View;
import com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.WebGiftInfo.TestSuit;

class LuxuryGiftController$TestSuit
{
  private View mGift264;
  private View mGiftH5;
  
  LuxuryGiftController$TestSuit(LuxuryGiftController paramLuxuryGiftController) {}
  
  public void init()
  {
    View localView = LayoutInflater.from(LuxuryGiftController.access$1000(this.this$0)).inflate(2131559358, LuxuryGiftController.access$900(this.this$0));
    this.mGiftH5 = localView.findViewById(2131364172);
    this.mGift264 = localView.findViewById(2131364171);
    this.mGiftH5.setOnClickListener(new LuxuryGiftController.TestSuit.1(this));
    this.mGift264.setOnClickListener(new LuxuryGiftController.TestSuit.2(this));
  }
  
  public void onPlayH264GiftForTest(int paramInt)
  {
    this.this$0.showAnimation(WebGiftInfo.TestSuit.obtain(paramInt), null);
  }
  
  public void onPlayH5GiftForTest(int paramInt)
  {
    LuxuryGiftController.access$102(this.this$0, WebGiftInfo.TestSuit.obtain(paramInt));
    LuxuryGiftController.access$300(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.LuxuryGiftController.TestSuit
 * JD-Core Version:    0.7.0.1
 */