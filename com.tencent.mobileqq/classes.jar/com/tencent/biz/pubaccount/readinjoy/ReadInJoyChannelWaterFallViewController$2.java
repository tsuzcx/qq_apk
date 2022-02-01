package com.tencent.biz.pubaccount.readinjoy;

import bnrf;
import ocd;
import ohx;
import ozs;

public class ReadInJoyChannelWaterFallViewController$2
  implements Runnable
{
  public ReadInJoyChannelWaterFallViewController$2(ohx paramohx) {}
  
  public void run()
  {
    if (ohx.a(this.this$0) == 40677)
    {
      ocd.a(null, "CliOper", "", "", "0X8009295", "0X8009295", 0, 0, bnrf.a("default_feeds_proteus_offline_bid"), "", "", ozs.b(ohx.a(this.this$0)), false);
      return;
    }
    ocd.a(null, "CliOper", "", "", "0X80066F9", "0X80066F9", 0, 0, bnrf.a("default_feeds_proteus_offline_bid"), "", "", ozs.b(ohx.a(this.this$0)), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelWaterFallViewController.2
 * JD-Core Version:    0.7.0.1
 */