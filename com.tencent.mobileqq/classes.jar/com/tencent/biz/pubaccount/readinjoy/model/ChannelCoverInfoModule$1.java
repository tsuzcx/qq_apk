package com.tencent.biz.pubaccount.readinjoy.model;

import azxx;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import opa;
import org.json.JSONObject;

public class ChannelCoverInfoModule$1
  implements Runnable
{
  public ChannelCoverInfoModule$1(opa paramopa, TabChannelCoverInfo paramTabChannelCoverInfo) {}
  
  public void run()
  {
    if (this.a.redPoint != null) {
      this.a.redPointJson = azxx.a(this.a.redPoint).toString();
    }
    this.this$0.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.1
 * JD-Core Version:    0.7.0.1
 */