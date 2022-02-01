package com.tencent.biz.pubaccount.readinjoy.fragment;

import bkwm;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import odq;
import ofe;
import ozh;
import pbg;
import pbm;

class ReadInJoyDailyFragment$4
  implements Runnable
{
  ReadInJoyDailyFragment$4(ReadInJoyDailyFragment paramReadInJoyDailyFragment, String paramString1, String paramString2) {}
  
  public void run()
  {
    pbg localpbg = new pbg();
    localpbg.b("folder_status", this.a);
    localpbg.b("entry_time", "" + ReadInJoyDailyFragment.a().a() / 1000L);
    localpbg.b("postset_time", "" + NetConnInfoCenter.getServerTime());
    localpbg.b("version", ofe.a);
    localpbg.b("os", "1");
    localpbg.b("cmd", bkwm.h());
    localpbg.b("channel_id", ozh.b());
    odq.a(null, null, this.b, this.b, 0, 0, "" + ReadInJoyDailyFragment.a().b() / 1000L, "", "", localpbg.a(), false);
    QLog.d("ReadInJoyDailyFragment", 2, "reportDuringTime time is" + ReadInJoyDailyFragment.a().b() / 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment.4
 * JD-Core Version:    0.7.0.1
 */