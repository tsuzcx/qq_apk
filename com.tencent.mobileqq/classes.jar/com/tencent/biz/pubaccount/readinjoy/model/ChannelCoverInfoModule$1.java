package com.tencent.biz.pubaccount.readinjoy.model;

import bghp;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import org.json.JSONObject;
import pwl;

public class ChannelCoverInfoModule$1
  implements Runnable
{
  public ChannelCoverInfoModule$1(pwl parampwl, TabChannelCoverInfo paramTabChannelCoverInfo) {}
  
  public void run()
  {
    if (this.a.redPoint != null) {
      this.a.redPointJson = bghp.a(this.a.redPoint).toString();
    }
    this.this$0.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.1
 * JD-Core Version:    0.7.0.1
 */