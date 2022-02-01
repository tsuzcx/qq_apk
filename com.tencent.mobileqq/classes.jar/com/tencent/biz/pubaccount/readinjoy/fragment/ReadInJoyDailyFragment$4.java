package com.tencent.biz.pubaccount.readinjoy.fragment;

import bmqa;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import oat;
import och;
import pfk;
import phi;
import pho;

class ReadInJoyDailyFragment$4
  implements Runnable
{
  ReadInJoyDailyFragment$4(ReadInJoyDailyFragment paramReadInJoyDailyFragment, String paramString1, String paramString2) {}
  
  public void run()
  {
    phi localphi = new phi();
    localphi.b("folder_status", this.a);
    localphi.b("entry_time", "" + ReadInJoyDailyFragment.a().a() / 1000L);
    localphi.b("postset_time", "" + NetConnInfoCenter.getServerTime());
    localphi.b("version", och.a);
    localphi.b("os", "1");
    localphi.b("cmd", bmqa.h());
    localphi.b("channel_id", pfk.b());
    oat.a(null, null, this.b, this.b, 0, 0, "" + ReadInJoyDailyFragment.a().b() / 1000L, "", "", localphi.a(), false);
    QLog.d("ReadInJoyDailyFragment", 2, "reportDuringTime time is" + ReadInJoyDailyFragment.a().b() / 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment.4
 * JD-Core Version:    0.7.0.1
 */