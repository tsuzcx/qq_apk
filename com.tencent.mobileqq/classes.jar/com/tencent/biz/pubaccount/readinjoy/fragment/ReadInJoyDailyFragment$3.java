package com.tencent.biz.pubaccount.readinjoy.fragment;

import bgmq;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import ndn;
import new;
import oab;
import ocg;
import ocr;

class ReadInJoyDailyFragment$3
  implements Runnable
{
  ReadInJoyDailyFragment$3(ReadInJoyDailyFragment paramReadInJoyDailyFragment, String paramString1, String paramString2) {}
  
  public void run()
  {
    ocg localocg = new ocg();
    localocg.b("folder_status", this.a);
    localocg.b("entry_time", "" + ReadInJoyDailyFragment.a(this.this$0).a() / 1000L);
    localocg.b("postset_time", "" + NetConnInfoCenter.getServerTime());
    localocg.b("version", new.a);
    localocg.b("os", "1");
    localocg.b("cmd", bgmq.g());
    localocg.b("channel_id", oab.b());
    ndn.a(null, null, this.b, this.b, 0, 0, "" + ReadInJoyDailyFragment.a(this.this$0).b() / 1000L, "", "", localocg.a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment.3
 * JD-Core Version:    0.7.0.1
 */