package com.tencent.biz.pubaccount.readinjoy.channelCover;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import odq;
import ofe;
import opo;
import org.json.JSONException;
import org.json.JSONObject;
import sid;
import sie;

public class ChannelCoverSimpleAdapter$1
  implements Runnable
{
  public ChannelCoverSimpleAdapter$1(opo paramopo, ChannelCoverInfo paramChannelCoverInfo) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if ((opo.a(this.this$0) != null) && ((opo.a(this.this$0) instanceof Activity)) && (((Activity)opo.a(this.this$0)).getIntent() != null))
        {
          i = ((Activity)opo.a(this.this$0)).getIntent().getIntExtra("channel_from", -1);
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("is_followed", "1");
          odq.a(null, "", "0X8007BE6", "0X8007BE6", 0, 0, "1", "", "", new sie(ofe.a(this.a.mChannelCoverId, localJSONObject)).N(i).a().a(), false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverSimpleAdapter.1
 * JD-Core Version:    0.7.0.1
 */