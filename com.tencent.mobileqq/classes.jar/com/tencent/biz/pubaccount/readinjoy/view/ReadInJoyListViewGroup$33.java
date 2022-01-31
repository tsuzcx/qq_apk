package com.tencent.biz.pubaccount.readinjoy.view;

import bgmq;
import ndn;
import new;
import obz;

class ReadInJoyListViewGroup$33
  implements Runnable
{
  ReadInJoyListViewGroup$33(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void run()
  {
    if (this.this$0.a == 40677) {
      ndn.a(null, "CliOper", "", "", "0X8009295", "0X8009295", 0, 0, bgmq.a("default_feeds_proteus_offline_bid"), "", "", obz.b(this.this$0.a), false);
    }
    for (;;)
    {
      if (this.this$0.a == 56) {
        ndn.a(null, "", "0X8007413", "0X8007413", 0, 0, "", "0", "", new.a(this.this$0.a, null), false);
      }
      return;
      ndn.a(null, "CliOper", "", "", "0X80066F9", "0X80066F9", 0, 0, bgmq.a("default_feeds_proteus_offline_bid"), "", "", obz.b(this.this$0.a), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.33
 * JD-Core Version:    0.7.0.1
 */