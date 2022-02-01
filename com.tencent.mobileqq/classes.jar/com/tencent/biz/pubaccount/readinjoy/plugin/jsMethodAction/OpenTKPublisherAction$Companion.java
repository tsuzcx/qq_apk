package com.tencent.biz.pubaccount.readinjoy.plugin.jsMethodAction;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/plugin/jsMethodAction/OpenTKPublisherAction$Companion;", "", "()V", "ERR_CODE", "", "SUCCESS_CODE", "TAG", "", "VIDEO_COVER_PATH", "doOpenPublisherReport", "", "hasRight", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class OpenTKPublisherAction$Companion
{
  public final void a(boolean paramBoolean)
  {
    int j = 0;
    JSONObject localJSONObject = new JSONObject();
    if (RIJUgcUtils.i())
    {
      i = 1;
      localJSONObject.put("ugc_video_flag", i);
      if (!RIJUgcUtils.h()) {
        break label98;
      }
    }
    label98:
    for (int i = 1;; i = 0)
    {
      localJSONObject.put("ugc_column_flag", i);
      i = j;
      if (paramBoolean) {
        i = 1;
      }
      localJSONObject.put("ugc_topic_video", i);
      localJSONObject.put("publisher_type", 1);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800AC6D", 5, localJSONObject.toString());
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.plugin.jsMethodAction.OpenTKPublisherAction.Companion
 * JD-Core Version:    0.7.0.1
 */