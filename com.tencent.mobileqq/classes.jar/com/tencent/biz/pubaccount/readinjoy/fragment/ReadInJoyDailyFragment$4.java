package com.tencent.biz.pubaccount.readinjoy.fragment;

import bhvh;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import noo;
import npx;
import olm;
import onr;
import ooc;

class ReadInJoyDailyFragment$4
  implements Runnable
{
  ReadInJoyDailyFragment$4(ReadInJoyDailyFragment paramReadInJoyDailyFragment, String paramString1, String paramString2) {}
  
  public void run()
  {
    onr localonr = new onr();
    localonr.b("folder_status", this.a);
    localonr.b("entry_time", "" + ReadInJoyDailyFragment.a().a() / 1000L);
    localonr.b("postset_time", "" + NetConnInfoCenter.getServerTime());
    localonr.b("version", npx.a);
    localonr.b("os", "1");
    localonr.b("cmd", bhvh.g());
    localonr.b("channel_id", olm.b());
    noo.a(null, null, this.b, this.b, 0, 0, "" + ReadInJoyDailyFragment.a().b() / 1000L, "", "", localonr.a(), false);
    QLog.d("ReadInJoyDailyFragment", 2, "reportDuringTime time is" + ReadInJoyDailyFragment.a().b() / 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment.4
 * JD-Core Version:    0.7.0.1
 */