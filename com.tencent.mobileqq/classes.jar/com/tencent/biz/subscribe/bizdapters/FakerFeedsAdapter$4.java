package com.tencent.biz.subscribe.bizdapters;

import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import java.util.ArrayList;

class FakerFeedsAdapter$4
  implements Runnable
{
  FakerFeedsAdapter$4(FakerFeedsAdapter paramFakerFeedsAdapter, SubscribeFeedsEvent paramSubscribeFeedsEvent) {}
  
  public void run()
  {
    this.this$0.b().addAll(0, this.a.mFakeFeedDataList);
    this.this$0.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.4
 * JD-Core Version:    0.7.0.1
 */