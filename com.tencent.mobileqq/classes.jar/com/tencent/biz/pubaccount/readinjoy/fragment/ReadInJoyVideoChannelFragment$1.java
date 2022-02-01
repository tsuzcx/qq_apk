package com.tencent.biz.pubaccount.readinjoy.fragment;

import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInJoyVideoChannelFragment$1
  implements Runnable
{
  ReadInJoyVideoChannelFragment$1(ReadInJoyVideoChannelFragment paramReadInJoyVideoChannelFragment) {}
  
  public void run()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007C41", "0X8007C41", 0, 0, "0", "0", "", VideoReporter.a(56, null), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoChannelFragment.1
 * JD-Core Version:    0.7.0.1
 */