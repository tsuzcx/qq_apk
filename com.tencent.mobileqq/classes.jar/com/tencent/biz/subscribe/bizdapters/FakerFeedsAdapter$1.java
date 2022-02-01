package com.tencent.biz.subscribe.bizdapters;

import aagr;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import java.util.ArrayList;

public class FakerFeedsAdapter$1
  implements Runnable
{
  public FakerFeedsAdapter$1(aagr paramaagr, SubscribeFeedsEvent paramSubscribeFeedsEvent) {}
  
  public void run()
  {
    this.this$0.getDataList().add(0, this.a.mSingleFakeFeed);
    this.this$0.notifyDataSetChanged();
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.1
 * JD-Core Version:    0.7.0.1
 */