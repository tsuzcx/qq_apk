package com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.base.model.CommentArgumentModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.tkd.comment.publisher.qq.QQPublishCommentManager;
import com.tencent.tkd.comment.publisher.qq.bridge.QQReportBridge;
import org.json.JSONException;
import org.json.JSONObject;

class QQViewBridgeImpl$2
  implements Runnable
{
  QQViewBridgeImpl$2(QQViewBridgeImpl paramQQViewBridgeImpl) {}
  
  private String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("os", 1);
      localJSONObject.put("entry", QQPublishCommentManager.getInstance().getReportBridge().getEntry());
      localJSONObject.put("comment_level", QQPublishCommentManager.getInstance().getReportBridge().getCommentLevel());
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void run()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(QQViewBridgeImpl.a(this.this$0).a), "0X800B9E0", "0X800B9E0", 0, 0, "", "", "", a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl.QQViewBridgeImpl.2
 * JD-Core Version:    0.7.0.1
 */