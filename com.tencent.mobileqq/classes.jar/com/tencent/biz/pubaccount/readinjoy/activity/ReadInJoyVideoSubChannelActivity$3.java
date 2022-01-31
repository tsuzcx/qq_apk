package com.tencent.biz.pubaccount.readinjoy.activity;

import bgmq;
import ndn;
import new;
import obz;

class ReadInJoyVideoSubChannelActivity$3
  implements Runnable
{
  ReadInJoyVideoSubChannelActivity$3(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity) {}
  
  public void run()
  {
    ndn.a(null, "CliOper", "", "", "0X80066F9", "0X80066F9", 0, 0, bgmq.a("default_feeds_proteus_offline_bid"), "", "", obz.b(ReadInJoyVideoSubChannelActivity.a(this.this$0)), false);
    ndn.a(null, "", "0X8007413", "0X8007413", 0, 0, "", "0", "", new.a(ReadInJoyVideoSubChannelActivity.a(this.this$0), null), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity.3
 * JD-Core Version:    0.7.0.1
 */