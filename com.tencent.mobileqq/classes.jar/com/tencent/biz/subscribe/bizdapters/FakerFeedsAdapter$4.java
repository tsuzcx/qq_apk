package com.tencent.biz.subscribe.bizdapters;

import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import java.util.ArrayList;
import zsu;

public class FakerFeedsAdapter$4
  implements Runnable
{
  public FakerFeedsAdapter$4(zsu paramzsu, SubscribeFeedsEvent paramSubscribeFeedsEvent) {}
  
  public void run()
  {
    this.this$0.a().addAll(0, this.a.mFakeFeedDataList);
    this.this$0.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.4
 * JD-Core Version:    0.7.0.1
 */