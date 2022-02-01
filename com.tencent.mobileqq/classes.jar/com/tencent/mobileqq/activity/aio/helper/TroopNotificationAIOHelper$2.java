package com.tencent.mobileqq.activity.aio.helper;

import agns;
import alez;
import aong;
import awhv;
import bftq;
import bftr;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class TroopNotificationAIOHelper$2
  implements Runnable
{
  public TroopNotificationAIOHelper$2(agns paramagns) {}
  
  public void run()
  {
    int i = 1;
    if (agns.a(this.this$0) == null) {}
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
      } while (agns.a(this.this$0).a == null);
      aong localaong = agns.a(this.this$0).a.a().a();
      RecentUser localRecentUser = (RecentUser)localaong.findRecentUserByUin(agns.a(this.this$0).a(), 1);
      localObject = bftr.a(agns.a(this.this$0).a, agns.a(this.this$0).a());
      if ((localObject != null) && (!((bftq)localObject).a.isEmpty())) {}
      for (;;)
      {
        localObject = agns.a(this.this$0).a.getHandler(Conversation.class);
        if (i != 0) {
          break;
        }
        if (awhv.a().a(agns.a(this.this$0).a, agns.a(this.this$0).a())) {
          break label210;
        }
        if (!(localRecentUser.msg instanceof alez)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotificationAIOHelper", 2, "doOnStop. clear recent user of TroopNotificationMsg.");
        }
        localRecentUser.cleanMsgAndMsgData(localRecentUser.msgType);
        localaong.saveRecentUser(localRecentUser);
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
      localaong.delRecentUser(localRecentUser, false);
    } while (localObject == null);
    ((MqqHandler)localObject).sendEmptyMessage(1009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopNotificationAIOHelper.2
 * JD-Core Version:    0.7.0.1
 */