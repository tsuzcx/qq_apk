package com.tencent.biz.subscribe.bizdapters;

import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import java.util.ArrayList;

class FakerFeedsAdapter$1
  implements Runnable
{
  FakerFeedsAdapter$1(FakerFeedsAdapter paramFakerFeedsAdapter, SubscribeFeedsEvent paramSubscribeFeedsEvent) {}
  
  public void run()
  {
    this.this$0.N().add(0, this.a.mSingleFakeFeed);
    this.this$0.notifyDataSetChanged();
    this.this$0.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.1
 * JD-Core Version:    0.7.0.1
 */