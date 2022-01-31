package com.tencent.biz.pubaccount.readinjoy;

import bkbq;
import nrt;
import nwu;
import ors;

public class ReadInJoyChannelWaterFallViewController$3
  implements Runnable
{
  public ReadInJoyChannelWaterFallViewController$3(nwu paramnwu) {}
  
  public void run()
  {
    if (nwu.a(this.this$0) == 40677)
    {
      nrt.a(null, "CliOper", "", "", "0X8009295", "0X8009295", 0, 0, bkbq.a("default_feeds_proteus_offline_bid"), "", "", ors.b(nwu.a(this.this$0)), false);
      return;
    }
    nrt.a(null, "CliOper", "", "", "0X80066F9", "0X80066F9", 0, 0, bkbq.a("default_feeds_proteus_offline_bid"), "", "", ors.b(nwu.a(this.this$0)), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelWaterFallViewController.3
 * JD-Core Version:    0.7.0.1
 */