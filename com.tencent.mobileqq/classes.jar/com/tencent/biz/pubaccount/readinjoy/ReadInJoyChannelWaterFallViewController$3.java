package com.tencent.biz.pubaccount.readinjoy;

import bgmq;
import ndn;
import nii;
import obz;

public class ReadInJoyChannelWaterFallViewController$3
  implements Runnable
{
  public ReadInJoyChannelWaterFallViewController$3(nii paramnii) {}
  
  public void run()
  {
    if (nii.a(this.this$0) == 40677)
    {
      ndn.a(null, "CliOper", "", "", "0X8009295", "0X8009295", 0, 0, bgmq.a("default_feeds_proteus_offline_bid"), "", "", obz.b(nii.a(this.this$0)), false);
      return;
    }
    ndn.a(null, "CliOper", "", "", "0X80066F9", "0X80066F9", 0, 0, bgmq.a("default_feeds_proteus_offline_bid"), "", "", obz.b(nii.a(this.this$0)), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelWaterFallViewController.3
 * JD-Core Version:    0.7.0.1
 */