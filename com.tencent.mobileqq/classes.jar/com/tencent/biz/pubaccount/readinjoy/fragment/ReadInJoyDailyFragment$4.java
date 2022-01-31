package com.tencent.biz.pubaccount.readinjoy.fragment;

import bhvy;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import nol;
import npu;
import olj;
import ono;
import onz;

class ReadInJoyDailyFragment$4
  implements Runnable
{
  ReadInJoyDailyFragment$4(ReadInJoyDailyFragment paramReadInJoyDailyFragment, String paramString1, String paramString2) {}
  
  public void run()
  {
    ono localono = new ono();
    localono.b("folder_status", this.a);
    localono.b("entry_time", "" + ReadInJoyDailyFragment.a().a() / 1000L);
    localono.b("postset_time", "" + NetConnInfoCenter.getServerTime());
    localono.b("version", npu.a);
    localono.b("os", "1");
    localono.b("cmd", bhvy.g());
    localono.b("channel_id", olj.b());
    nol.a(null, null, this.b, this.b, 0, 0, "" + ReadInJoyDailyFragment.a().b() / 1000L, "", "", localono.a(), false);
    QLog.d("ReadInJoyDailyFragment", 2, "reportDuringTime time is" + ReadInJoyDailyFragment.a().b() / 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment.4
 * JD-Core Version:    0.7.0.1
 */