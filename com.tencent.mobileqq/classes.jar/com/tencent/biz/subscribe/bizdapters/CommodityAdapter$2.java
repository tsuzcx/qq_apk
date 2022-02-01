package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import aagg;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;

public class CommodityAdapter$2
  implements Runnable
{
  public CommodityAdapter$2(aagg paramaagg) {}
  
  public void run()
  {
    this.this$0.setDatas((ArrayList)aagg.a(this.this$0).goods.get());
    this.this$0.a(aagg.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.CommodityAdapter.2
 * JD-Core Version:    0.7.0.1
 */