package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CreateCommentResult;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentNetworkHelper.RIJCreateCommentObserver;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentRptDataUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class TroopMemberApiService$IncomingHandler$17
  implements IRIJCommentNetworkHelper.RIJCreateCommentObserver
{
  TroopMemberApiService$IncomingHandler$17(TroopMemberApiService.IncomingHandler paramIncomingHandler, JSONObject paramJSONObject, BaseCommentData paramBaseCommentData, JSONArray paramJSONArray, Bundle paramBundle) {}
  
  public void a(CreateCommentResult paramCreateCommentResult)
  {
    try
    {
      boolean bool = paramCreateCommentResult.b;
      j = 0;
      if (!bool) {
        break label199;
      }
      i = 0;
    }
    catch (JSONException paramCreateCommentResult)
    {
      for (;;)
      {
        int j;
        label161:
        continue;
        label199:
        int i = -2;
      }
    }
    this.a.put("retCode", i);
    this.a.put("commentId", paramCreateCommentResult.e);
    this.a.put("comment", this.b.commentContent);
    if (this.c != null) {
      this.a.put("linkDataList", this.c);
    }
    i = j;
    if (paramCreateCommentResult.c == -4096) {
      i = 1;
    }
    this.a.put("errorType", i);
    this.a.put("errorCode", paramCreateCommentResult.c);
    this.a.put("rptDataList", ((IRIJCommentRptDataUtil)QRoute.api(IRIJCommentRptDataUtil.class)).getJsonForWeb(this.b.commentRptDataList));
    break label161;
    QLog.e("TroopMemberApiService", 1, "handleCommentEditorNativeResult put create comment result error.");
    this.d.putString("BUNDLE_KEY_JS_OBJ", this.a.toString());
    this.e.a.a(154, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.17
 * JD-Core Version:    0.7.0.1
 */