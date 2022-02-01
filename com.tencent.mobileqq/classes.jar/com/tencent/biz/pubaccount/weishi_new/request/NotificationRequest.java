package com.tencent.biz.pubaccount.weishi_new.request;

import UserGrowth.stNotificationReq;
import UserGrowth.stNotificationRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiLinkUtil;

public class NotificationRequest
  extends WeishiRequest<stNotificationRsp>
{
  public NotificationRequest(String paramString)
  {
    super("Notification", 4);
    stNotificationReq localstNotificationReq = new stNotificationReq();
    localstNotificationReq.linkStrategyArgs = WeishiLinkUtil.a();
    localstNotificationReq.push_info = paramString;
    this.a = localstNotificationReq;
    paramString = new StringBuilder();
    paramString.append("stNotificationReq = ");
    paramString.append(localstNotificationReq.toString());
    WSLog.b("NotificationRequest", paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.NotificationRequest
 * JD-Core Version:    0.7.0.1
 */