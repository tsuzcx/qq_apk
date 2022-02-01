package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class ChatActivityFacade$7
  implements Runnable
{
  ChatActivityFacade$7(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, JSONObject paramJSONObject, boolean paramBoolean, boolean[] paramArrayOfBoolean, long[] paramArrayOfLong) {}
  
  public void run()
  {
    if (ChatActivityFacade.d(this.a, this.b, false))
    {
      long l1 = this.c.optLong("fromuin");
      if (String.valueOf(l1).equals(this.b.b))
      {
        long l2 = this.c.optLong("time");
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("add new feeds publishTime:");
        ((StringBuilder)localObject).append(l2);
        QLog.i("ChatActivityFacade.QZoneFeeds", 1, ((StringBuilder)localObject).toString());
        if (this.d)
        {
          ((INewFriendService)this.a.getRuntimeService(INewFriendService.class)).insertFriendFeedForAIOShowNewsMsg(this.c.toString(), String.valueOf(l1));
          return;
        }
        localObject = (BeancurdManager)this.a.getManager(QQManagerFactory.BEANCURD_MANAGER);
        BeancurdMsg localBeancurdMsg = new BeancurdMsg();
        localBeancurdMsg.buffer = this.c.toString();
        localBeancurdMsg.busiid = 2;
        localBeancurdMsg.frienduin = String.valueOf(l1);
        localBeancurdMsg.isNeedDelHistory = true;
        localBeancurdMsg.ispush = this.e[0];
        localBeancurdMsg.startTime = MessageCache.c();
        localBeancurdMsg.validTime = 604800L;
        localBeancurdMsg.token = this.f[0];
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("addQzoneFeedMessageV2l receiveBeancurd:");
          localStringBuilder.append(String.valueOf(localBeancurdMsg));
          QLog.i("ChatActivityFacade.QZoneFeeds", 2, localStringBuilder.toString());
        }
        ((BeancurdManager)localObject).a(localBeancurdMsg);
        return;
      }
      QLog.e("ChatActivityFacade.QZoneFeeds", 1, "当前获取到的feeds的发表人不匹配，忽略不插入");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.7
 * JD-Core Version:    0.7.0.1
 */