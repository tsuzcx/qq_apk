package com.tencent.biz.pubaccount.readinjoy.model;

import bcyj;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import org.json.JSONObject;
import pfg;

public class ChannelCoverInfoModule$1
  implements Runnable
{
  public ChannelCoverInfoModule$1(pfg parampfg, TabChannelCoverInfo paramTabChannelCoverInfo) {}
  
  public void run()
  {
    if (this.a.redPoint != null) {
      this.a.redPointJson = bcyj.a(this.a.redPoint).toString();
    }
    this.this$0.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.1
 * JD-Core Version:    0.7.0.1
 */