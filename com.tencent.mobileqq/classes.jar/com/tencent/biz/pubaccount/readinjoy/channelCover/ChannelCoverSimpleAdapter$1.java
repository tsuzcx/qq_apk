package com.tencent.biz.pubaccount.readinjoy.channelCover;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import noo;
import npx;
import oeq;
import org.json.JSONException;
import org.json.JSONObject;
import qzd;
import qze;

public class ChannelCoverSimpleAdapter$1
  implements Runnable
{
  public ChannelCoverSimpleAdapter$1(oeq paramoeq, ChannelCoverInfo paramChannelCoverInfo) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if ((oeq.a(this.this$0) != null) && ((oeq.a(this.this$0) instanceof Activity)) && (((Activity)oeq.a(this.this$0)).getIntent() != null))
        {
          i = ((Activity)oeq.a(this.this$0)).getIntent().getIntExtra("channel_from", -1);
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("is_followed", "1");
          noo.a(null, "", "0X8007BE6", "0X8007BE6", 0, 0, "1", "", "", new qze(npx.a(this.a.mChannelCoverId, localJSONObject)).P(i).a().a(), false);
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