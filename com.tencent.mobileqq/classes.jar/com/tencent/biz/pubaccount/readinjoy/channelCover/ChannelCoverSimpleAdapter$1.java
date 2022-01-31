package com.tencent.biz.pubaccount.readinjoy.channelCover;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import nol;
import npu;
import oen;
import org.json.JSONException;
import org.json.JSONObject;
import qza;
import qzb;

public class ChannelCoverSimpleAdapter$1
  implements Runnable
{
  public ChannelCoverSimpleAdapter$1(oen paramoen, ChannelCoverInfo paramChannelCoverInfo) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if ((oen.a(this.this$0) != null) && ((oen.a(this.this$0) instanceof Activity)) && (((Activity)oen.a(this.this$0)).getIntent() != null))
        {
          i = ((Activity)oen.a(this.this$0)).getIntent().getIntExtra("channel_from", -1);
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("is_followed", "1");
          nol.a(null, "", "0X8007BE6", "0X8007BE6", 0, 0, "1", "", "", new qzb(npu.a(this.a.mChannelCoverId, localJSONObject)).P(i).a().a(), false);
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