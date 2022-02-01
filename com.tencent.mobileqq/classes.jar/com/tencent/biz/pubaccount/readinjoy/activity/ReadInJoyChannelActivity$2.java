package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

class ReadInJoyChannelActivity$2
  implements Runnable
{
  ReadInJoyChannelActivity$2(ReadInJoyChannelActivity paramReadInJoyChannelActivity) {}
  
  public void run()
  {
    ReadInJoyGlobalReporter.a().a(true);
    ReadInJoyGlobalReporter.a().b(this.this$0.app, NetConnInfoCenter.getServerTimeMillis(), -1, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity.2
 * JD-Core Version:    0.7.0.1
 */