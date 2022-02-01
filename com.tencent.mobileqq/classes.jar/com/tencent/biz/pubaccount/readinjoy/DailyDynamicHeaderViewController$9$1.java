package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;

class DailyDynamicHeaderViewController$9$1
  implements Runnable
{
  DailyDynamicHeaderViewController$9$1(DailyDynamicHeaderViewController.9 param9) {}
  
  public void run()
  {
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(DailyDynamicHeaderViewController.a(this.a.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.DailyDynamicHeaderViewController.9.1
 * JD-Core Version:    0.7.0.1
 */