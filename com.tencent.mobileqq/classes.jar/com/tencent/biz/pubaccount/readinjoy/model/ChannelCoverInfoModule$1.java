package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.mobileqq.util.JSONUtils;
import org.json.JSONObject;

class ChannelCoverInfoModule$1
  implements Runnable
{
  ChannelCoverInfoModule$1(ChannelCoverInfoModule paramChannelCoverInfoModule, TabChannelCoverInfo paramTabChannelCoverInfo) {}
  
  public void run()
  {
    if (this.a.redPoint != null) {
      this.a.redPointJson = JSONUtils.a(this.a.redPoint).toString();
    }
    this.this$0.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.1
 * JD-Core Version:    0.7.0.1
 */