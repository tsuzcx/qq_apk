package com.tencent.mobileqq.activity.aio.helper;

import agla;
import allh;
import aoxz;
import awtz;
import bgll;
import bglm;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class TroopNotificationAIOHelper$2
  implements Runnable
{
  public TroopNotificationAIOHelper$2(agla paramagla) {}
  
  public void run()
  {
    int i = 1;
    if (agla.a(this.this$0) == null) {}
    label12:
    Object localObject;
    label210:
    do
    {
      break label12;
      break label12;
      do
      {
        return;
      } while (agla.a(this.this$0).app == null);
      aoxz localaoxz = agla.a(this.this$0).app.getProxyManager().a();
      RecentUser localRecentUser = (RecentUser)localaoxz.findRecentUserByUin(agla.a(this.this$0).getCurFriendUin(), 1);
      localObject = bglm.a(agla.a(this.this$0).app, agla.a(this.this$0).getCurFriendUin());
      if ((localObject != null) && (!((bgll)localObject).a.isEmpty())) {}
      for (;;)
      {
        localObject = agla.a(this.this$0).app.getHandler(Conversation.class);
        if (i != 0) {
          break;
        }
        if (awtz.a().a(agla.a(this.this$0).app, agla.a(this.this$0).getCurFriendUin())) {
          break label210;
        }
        if (!(localRecentUser.msg instanceof allh)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotificationAIOHelper", 2, "doOnStop. clear recent user of TroopNotificationMsg.");
        }
        localRecentUser.cleanMsgAndMsgData(localRecentUser.msgType);
        localaoxz.saveRecentUser(localRecentUser);
        if (localObject == null) {
          break;
        }
        ((MqqHandler)localObject).sendEmptyMessage(1009);
        return;
        i = 0;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationAIOHelper", 2, "remove recent user on stop.");
      }
      localaoxz.c(localRecentUser, false);
    } while (localObject == null);
    ((MqqHandler)localObject).sendEmptyMessage(1009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopNotificationAIOHelper.2
 * JD-Core Version:    0.7.0.1
 */