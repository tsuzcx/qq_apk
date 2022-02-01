package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.compat;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.BannerInfoModule;

class ReadInJoyDynamicChannelFragment$3
  implements Runnable
{
  ReadInJoyDynamicChannelFragment$3(ReadInJoyDynamicChannelFragment paramReadInJoyDynamicChannelFragment) {}
  
  public void run()
  {
    BannerInfoModule localBannerInfoModule = ReadInJoyLogicEngine.a().a();
    if (localBannerInfoModule != null) {
      localBannerInfoModule.b(ReadInJoyDynamicChannelFragment.l(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.compat.ReadInJoyDynamicChannelFragment.3
 * JD-Core Version:    0.7.0.1
 */