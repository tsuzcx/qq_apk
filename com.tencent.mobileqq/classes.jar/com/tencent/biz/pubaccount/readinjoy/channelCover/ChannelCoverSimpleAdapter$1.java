package com.tencent.biz.pubaccount.readinjoy.channelCover;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONException;
import org.json.JSONObject;

class ChannelCoverSimpleAdapter$1
  implements Runnable
{
  ChannelCoverSimpleAdapter$1(ChannelCoverSimpleAdapter paramChannelCoverSimpleAdapter, ChannelCoverInfo paramChannelCoverInfo) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if ((ChannelCoverSimpleAdapter.a(this.this$0) != null) && ((ChannelCoverSimpleAdapter.a(this.this$0) instanceof Activity)) && (((Activity)ChannelCoverSimpleAdapter.a(this.this$0)).getIntent() != null))
        {
          i = ((Activity)ChannelCoverSimpleAdapter.a(this.this$0)).getIntent().getIntExtra("channel_from", -1);
          Object localObject = new JSONObject();
          ((JSONObject)localObject).put("is_followed", "1");
          localObject = new VideoR5.Builder(VideoReporter.a(this.a.mChannelCoverId, (JSONObject)localObject)).N(i).a().a();
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007BE6", "0X8007BE6", 0, 0, "1", "", "", (String)localObject, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverSimpleAdapter.1
 * JD-Core Version:    0.7.0.1
 */