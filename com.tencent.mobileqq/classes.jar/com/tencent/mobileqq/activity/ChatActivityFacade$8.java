package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class ChatActivityFacade$8
  implements Runnable
{
  ChatActivityFacade$8(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, JSONObject paramJSONObject, boolean paramBoolean) {}
  
  public void run()
  {
    if (ChatActivityFacade.e(this.a, this.b, false))
    {
      Object localObject1 = this.c.optString("fromuin");
      if (this.b.b.equals(localObject1))
      {
        long l = this.c.optLong("time");
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("add new feeds publishTime:");
        ((StringBuilder)localObject2).append(l);
        QLog.i("ChatActivityFacade.QCircleFeeds", 1, ((StringBuilder)localObject2).toString());
        if (this.d)
        {
          ((INewFriendService)this.a.getRuntimeService(INewFriendService.class)).insertFriendFeedForAIOShowNewsMsg(this.c.toString(), (String)localObject1);
          return;
        }
        localObject2 = (BeancurdManager)this.a.getManager(QQManagerFactory.BEANCURD_MANAGER);
        BeancurdMsg localBeancurdMsg = new BeancurdMsg();
        localBeancurdMsg.buffer = this.c.toString();
        localBeancurdMsg.busiid = 12;
        localBeancurdMsg.frienduin = ((String)localObject1);
        localBeancurdMsg.isNeedDelHistory = true;
        localBeancurdMsg.startTime = MessageCache.c();
        localBeancurdMsg.validTime = 604800L;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("addQCircleFeedMessageV2 receiveBeancurd:");
          ((StringBuilder)localObject1).append(localBeancurdMsg);
          QLog.i("ChatActivityFacade.QCircleFeeds", 2, ((StringBuilder)localObject1).toString());
        }
        ((BeancurdManager)localObject2).a(localBeancurdMsg);
        ReportController.b(null, "dc00898", "", this.b.b, "0X800B279", "0X800B279", 0, 0, "", "", "", "");
        return;
      }
      QLog.e("ChatActivityFacade.QCircleFeeds", 1, "当前获取到的feeds的发表人不匹配，忽略不插入");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.8
 * JD-Core Version:    0.7.0.1
 */