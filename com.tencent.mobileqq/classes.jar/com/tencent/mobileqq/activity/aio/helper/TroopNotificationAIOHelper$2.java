package com.tencent.mobileqq.activity.aio.helper;

import afgm;
import ajmh;
import amnz;
import auam;
import bcoz;
import bcpa;
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
  public TroopNotificationAIOHelper$2(afgm paramafgm) {}
  
  public void run()
  {
    int i = 1;
    if (afgm.a(this.this$0) == null) {}
    label12:
    Object localObject;
    label207:
    do
    {
      break label12;
      break label12;
      do
      {
        return;
      } while (afgm.a(this.this$0).a == null);
      amnz localamnz = afgm.a(this.this$0).a.a().a();
      RecentUser localRecentUser = localamnz.a(afgm.a(this.this$0).a(), 1);
      localObject = bcpa.a(afgm.a(this.this$0).a, afgm.a(this.this$0).a());
      if ((localObject != null) && (!((bcoz)localObject).a.isEmpty())) {}
      for (;;)
      {
        localObject = afgm.a(this.this$0).a.getHandler(Conversation.class);
        if (i != 0) {
          break;
        }
        if (auam.a().a(afgm.a(this.this$0).a, afgm.a(this.this$0).a())) {
          break label207;
        }
        if (!(localRecentUser.msg instanceof ajmh)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotificationAIOHelper", 2, "doOnStop. clear recent user of TroopNotificationMsg.");
        }
        localRecentUser.cleanMsgAndMsgData(localRecentUser.msgType);
        localamnz.a(localRecentUser);
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
      localamnz.b(localRecentUser, false);
    } while (localObject == null);
    ((MqqHandler)localObject).sendEmptyMessage(1009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopNotificationAIOHelper.2
 * JD-Core Version:    0.7.0.1
 */