package com.tencent.ilive.components.luxurygift;

import android.view.LayoutInflater;
import android.view.View;
import com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.WebGiftInfo.TestSuit;

class LiteLuxuryGiftController$TestSuit
{
  private View mGift264;
  private View mGiftH5;
  
  LiteLuxuryGiftController$TestSuit(LiteLuxuryGiftController paramLiteLuxuryGiftController) {}
  
  public void init()
  {
    View localView = LayoutInflater.from(LiteLuxuryGiftController.access$900(this.this$0)).inflate(2131559233, LiteLuxuryGiftController.access$800(this.this$0));
    this.mGiftH5 = localView.findViewById(2131364092);
    this.mGift264 = localView.findViewById(2131364091);
    this.mGiftH5.setOnClickListener(new LiteLuxuryGiftController.TestSuit.1(this));
    this.mGift264.setOnClickListener(new LiteLuxuryGiftController.TestSuit.2(this));
  }
  
  public void onPlayH264GiftForTest(int paramInt)
  {
    this.this$0.showAnimation(WebGiftInfo.TestSuit.obtain(paramInt), null);
  }
  
  public void onPlayH5GiftForTest(int paramInt)
  {
    LiteLuxuryGiftController.access$102(this.this$0, WebGiftInfo.TestSuit.obtain(paramInt));
    LiteLuxuryGiftController.access$400(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.components.luxurygift.LiteLuxuryGiftController.TestSuit
 * JD-Core Version:    0.7.0.1
 */