package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;

class CommodityAdapter$2
  implements Runnable
{
  CommodityAdapter$2(CommodityAdapter paramCommodityAdapter) {}
  
  public void run()
  {
    CommodityAdapter localCommodityAdapter = this.this$0;
    localCommodityAdapter.a((ArrayList)CommodityAdapter.a(localCommodityAdapter).goods.get());
    localCommodityAdapter = this.this$0;
    localCommodityAdapter.a(CommodityAdapter.a(localCommodityAdapter));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.CommodityAdapter.2
 * JD-Core Version:    0.7.0.1
 */