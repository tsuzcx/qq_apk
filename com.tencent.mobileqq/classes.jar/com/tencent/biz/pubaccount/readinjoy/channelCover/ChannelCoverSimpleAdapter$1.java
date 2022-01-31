package com.tencent.biz.pubaccount.readinjoy.channelCover;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import ndn;
import new;
import ntg;
import org.json.JSONException;
import org.json.JSONObject;
import qmu;
import qmv;

public class ChannelCoverSimpleAdapter$1
  implements Runnable
{
  public ChannelCoverSimpleAdapter$1(ntg paramntg, ChannelCoverInfo paramChannelCoverInfo) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if ((ntg.a(this.this$0) != null) && ((ntg.a(this.this$0) instanceof Activity)) && (((Activity)ntg.a(this.this$0)).getIntent() != null))
        {
          i = ((Activity)ntg.a(this.this$0)).getIntent().getIntExtra("channel_from", -1);
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("is_followed", "1");
          ndn.a(null, "", "0X8007BE6", "0X8007BE6", 0, 0, "1", "", "", new qmv(new.a(this.a.mChannelCoverId, localJSONObject)).O(i).a().a(), false);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverSimpleAdapter.1
 * JD-Core Version:    0.7.0.1
 */