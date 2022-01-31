package com.tencent.biz.pubaccount.readinjoy.channelCover;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import nrt;
import ntd;
import oiz;
import org.json.JSONException;
import org.json.JSONObject;
import rom;
import ron;

public class ChannelCoverSimpleAdapter$1
  implements Runnable
{
  public ChannelCoverSimpleAdapter$1(oiz paramoiz, ChannelCoverInfo paramChannelCoverInfo) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if ((oiz.a(this.this$0) != null) && ((oiz.a(this.this$0) instanceof Activity)) && (((Activity)oiz.a(this.this$0)).getIntent() != null))
        {
          i = ((Activity)oiz.a(this.this$0)).getIntent().getIntExtra("channel_from", -1);
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("is_followed", "1");
          nrt.a(null, "", "0X8007BE6", "0X8007BE6", 0, 0, "1", "", "", new ron(ntd.a(this.a.mChannelCoverId, localJSONObject)).O(i).a().a(), false);
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