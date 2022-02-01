package com.tencent.biz.subscribe.bizdapters;

import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import java.util.ArrayList;
import zdp;

public class FakerFeedsAdapter$1
  implements Runnable
{
  public FakerFeedsAdapter$1(zdp paramzdp, SubscribeFeedsEvent paramSubscribeFeedsEvent) {}
  
  public void run()
  {
    this.this$0.a().add(0, this.a.mSingleFakeFeed);
    this.this$0.notifyDataSetChanged();
    this.this$0.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.1
 * JD-Core Version:    0.7.0.1
 */