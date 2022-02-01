package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report;

import bkwm;
import odq;
import ofe;
import pay;

public final class RIJFrameworkReportManager$2
  implements Runnable
{
  public RIJFrameworkReportManager$2(int paramInt) {}
  
  public void run()
  {
    if (this.a == 40677) {
      odq.a(null, "CliOper", "", "", "0X8009295", "0X8009295", 0, 0, bkwm.a("default_feeds_proteus_offline_bid"), "", "", pay.b(this.a), false);
    }
    for (;;)
    {
      if (this.a == 56) {
        odq.a(null, "", "0X8007413", "0X8007413", 0, 0, "", "0", "", ofe.a(this.a, null), false);
      }
      return;
      odq.a(null, "CliOper", "", "", "0X80066F9", "0X80066F9", 0, 0, bkwm.a("default_feeds_proteus_offline_bid"), "", "", pay.b(this.a), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager.2
 * JD-Core Version:    0.7.0.1
 */