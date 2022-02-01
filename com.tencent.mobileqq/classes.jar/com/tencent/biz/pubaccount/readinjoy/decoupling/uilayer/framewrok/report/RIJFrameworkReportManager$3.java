package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report;

import bmhv;
import olh;
import omx;
import pqf;

public final class RIJFrameworkReportManager$3
  implements Runnable
{
  public RIJFrameworkReportManager$3(int paramInt) {}
  
  public void run()
  {
    if (this.a == 40677) {
      olh.a(null, "CliOper", "", "", "0X8009295", "0X8009295", 0, 0, bmhv.a("default_feeds_proteus_offline_bid"), "", "", pqf.b(this.a), false);
    }
    for (;;)
    {
      if (this.a == 56) {
        olh.a(null, "", "0X8007413", "0X8007413", 0, 0, "", "0", "", omx.a(this.a, null), false);
      }
      return;
      olh.a(null, "CliOper", "", "", "0X80066F9", "0X80066F9", 0, 0, bmhv.a("default_feeds_proteus_offline_bid"), "", "", pqf.b(this.a), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager.3
 * JD-Core Version:    0.7.0.1
 */