package com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.BannerInfoModule;

final class RIJDataFetchManager$1
  implements Runnable
{
  RIJDataFetchManager$1(int paramInt) {}
  
  public void run()
  {
    BannerInfoModule localBannerInfoModule = ReadInJoyLogicEngine.a().a();
    if (localBannerInfoModule != null) {
      localBannerInfoModule.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataFetchManager.1
 * JD-Core Version:    0.7.0.1
 */