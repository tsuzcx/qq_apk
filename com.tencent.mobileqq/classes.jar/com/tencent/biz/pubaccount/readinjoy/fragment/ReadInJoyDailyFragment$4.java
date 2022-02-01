package com.tencent.biz.pubaccount.readinjoy.fragment;

import bnrf;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import ocd;
import odr;
import oyc;
import paa;
import pag;

class ReadInJoyDailyFragment$4
  implements Runnable
{
  ReadInJoyDailyFragment$4(ReadInJoyDailyFragment paramReadInJoyDailyFragment, String paramString1, String paramString2) {}
  
  public void run()
  {
    paa localpaa = new paa();
    localpaa.b("folder_status", this.a);
    localpaa.b("entry_time", "" + ReadInJoyDailyFragment.a().a() / 1000L);
    localpaa.b("postset_time", "" + NetConnInfoCenter.getServerTime());
    localpaa.b("version", odr.a);
    localpaa.b("os", "1");
    localpaa.b("cmd", bnrf.h());
    localpaa.b("channel_id", oyc.b());
    ocd.a(null, null, this.b, this.b, 0, 0, "" + ReadInJoyDailyFragment.a().b() / 1000L, "", "", localpaa.a(), false);
    QLog.d("ReadInJoyDailyFragment", 2, "reportDuringTime time is" + ReadInJoyDailyFragment.a().b() / 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment.4
 * JD-Core Version:    0.7.0.1
 */