package com.tencent.biz.pubaccount.readinjoy.plugin.jsMethodAction;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/plugin/jsMethodAction/TweetTopicEntranceShouldShowAction$Companion;", "", "()V", "HIDE_TOPIC_ENTRANCE", "", "SHOW_TOPIC_ENTRANCE", "TAG", "", "doShowEntranceReport", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TweetTopicEntranceShouldShowAction$Companion
{
  public final void a()
  {
    int j = 0;
    JSONObject localJSONObject = new JSONObject();
    if (RIJUgcUtils.i()) {}
    for (int i = 1;; i = 0)
    {
      localJSONObject.put("ugc_video_flag", i);
      i = j;
      if (RIJUgcUtils.h()) {
        i = 1;
      }
      localJSONObject.put("ugc_column_flag", i);
      localJSONObject.put("ugc_video_flag1", 1);
      localJSONObject.put("publisher_type", 1);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800AC6C", 2, localJSONObject.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.plugin.jsMethodAction.TweetTopicEntranceShouldShowAction.Companion
 * JD-Core Version:    0.7.0.1
 */