package com.tencent.biz.pubaccount.readinjoy;

import bkwm;
import odq;
import ojk;
import pay;

public class ReadInJoyChannelWaterFallViewController$2
  implements Runnable
{
  public ReadInJoyChannelWaterFallViewController$2(ojk paramojk) {}
  
  public void run()
  {
    if (ojk.a(this.this$0) == 40677)
    {
      odq.a(null, "CliOper", "", "", "0X8009295", "0X8009295", 0, 0, bkwm.a("default_feeds_proteus_offline_bid"), "", "", pay.b(ojk.a(this.this$0)), false);
      return;
    }
    odq.a(null, "CliOper", "", "", "0X80066F9", "0X80066F9", 0, 0, bkwm.a("default_feeds_proteus_offline_bid"), "", "", pay.b(ojk.a(this.this$0)), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelWaterFallViewController.2
 * JD-Core Version:    0.7.0.1
 */