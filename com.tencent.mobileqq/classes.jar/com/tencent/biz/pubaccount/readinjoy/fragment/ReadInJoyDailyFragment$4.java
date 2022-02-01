package com.tencent.biz.pubaccount.readinjoy.fragment;

import bmhv;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import olh;
import omx;
import pin;
import pkn;
import pqg;

class ReadInJoyDailyFragment$4
  implements Runnable
{
  ReadInJoyDailyFragment$4(ReadInJoyDailyFragment paramReadInJoyDailyFragment, String paramString1, String paramString2) {}
  
  public void run()
  {
    pqg localpqg = new pqg();
    localpqg.b("folder_status", this.a);
    localpqg.b("entry_time", "" + ReadInJoyDailyFragment.a().a() / 1000L);
    localpqg.b("postset_time", "" + NetConnInfoCenter.getServerTime());
    localpqg.b("version", omx.a);
    localpqg.b("os", "1");
    localpqg.b("cmd", bmhv.h());
    localpqg.b("channel_id", pin.b());
    olh.a(null, null, this.b, this.b, 0, 0, "" + ReadInJoyDailyFragment.a().b() / 1000L, "", "", localpqg.a(), false);
    QLog.d("ReadInJoyDailyFragment", 2, "reportDuringTime time is" + ReadInJoyDailyFragment.a().b() / 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment.4
 * JD-Core Version:    0.7.0.1
 */