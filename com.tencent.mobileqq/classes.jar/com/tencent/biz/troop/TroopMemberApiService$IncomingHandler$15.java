package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJEntryViewUtils;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.IVideoPublishCallback;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

class TroopMemberApiService$IncomingHandler$15
  implements IRIJUgcVideoPublishService.IVideoPublishCallback
{
  TroopMemberApiService$IncomingHandler$15(TroopMemberApiService.IncomingHandler paramIncomingHandler, Bundle paramBundle, QQAppInterface paramQQAppInterface) {}
  
  public void a(UgcVideo paramUgcVideo)
  {
    if (paramUgcVideo.fromForReport == 4)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("coverUrl", paramUgcVideo.coverUrl);
        localJSONObject.put("video_location", paramUgcVideo.address);
        localJSONObject.put("kdCommunityId", paramUgcVideo.kdCommunityId);
        localJSONObject.put("textLevel", ((IRIJEntryViewUtils)QRoute.api(IRIJEntryViewUtils.class)).parseMultiBiuStruct2Json(paramUgcVideo.getMultiTitleStruct()));
        localJSONObject.put("account", BaseApplicationImpl.getApplication().getRuntime().getAccount());
        localJSONObject.put("title", paramUgcVideo.title);
      }
      catch (JSONException paramUgcVideo)
      {
        QLog.e("TroopMemberApiService", 1, paramUgcVideo, new Object[] { "parseJson fail in ugcVideo" });
      }
      this.a.putString("publisherExtra", localJSONObject.toString());
      TroopMemberApiService.IncomingHandler.a(this.c, 161, this.a, 0, "success");
      paramUgcVideo = this.b;
      if (paramUgcVideo != null) {
        ((IRIJUgcVideoPublishService)paramUgcVideo.getRuntimeService(IRIJUgcVideoPublishService.class)).removeVideoPublishCallback(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.15
 * JD-Core Version:    0.7.0.1
 */