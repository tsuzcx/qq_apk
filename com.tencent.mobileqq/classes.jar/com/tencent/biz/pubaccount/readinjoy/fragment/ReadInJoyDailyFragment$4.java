package com.tencent.biz.pubaccount.readinjoy.fragment;

import bjxj;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import nrt;
import ntd;
import opt;
import orz;
import osk;

class ReadInJoyDailyFragment$4
  implements Runnable
{
  ReadInJoyDailyFragment$4(ReadInJoyDailyFragment paramReadInJoyDailyFragment, String paramString1, String paramString2) {}
  
  public void run()
  {
    orz localorz = new orz();
    localorz.b("folder_status", this.a);
    localorz.b("entry_time", "" + ReadInJoyDailyFragment.a().a() / 1000L);
    localorz.b("postset_time", "" + NetConnInfoCenter.getServerTime());
    localorz.b("version", ntd.a);
    localorz.b("os", "1");
    localorz.b("cmd", bjxj.g());
    localorz.b("channel_id", opt.b());
    nrt.a(null, null, this.b, this.b, 0, 0, "" + ReadInJoyDailyFragment.a().b() / 1000L, "", "", localorz.a(), false);
    QLog.d("ReadInJoyDailyFragment", 2, "reportDuringTime time is" + ReadInJoyDailyFragment.a().b() / 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment.4
 * JD-Core Version:    0.7.0.1
 */