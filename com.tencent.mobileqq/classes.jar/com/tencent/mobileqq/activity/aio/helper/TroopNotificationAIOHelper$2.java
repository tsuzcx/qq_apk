package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.msg.TroopNotificationMsg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.troop.utils.TroopNotificationFlagMsg;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class TroopNotificationAIOHelper$2
  implements Runnable
{
  TroopNotificationAIOHelper$2(TroopNotificationAIOHelper paramTroopNotificationAIOHelper) {}
  
  public void run()
  {
    if (TroopNotificationAIOHelper.a(this.this$0) == null) {
      return;
    }
    if ((TroopNotificationAIOHelper.a(this.this$0).d != null) && (TroopNotificationAIOHelper.a(this.this$0).ah != null))
    {
      if (TextUtils.isEmpty(TroopNotificationAIOHelper.a(this.this$0).ah.b)) {
        return;
      }
      RecentUserProxy localRecentUserProxy = TroopNotificationAIOHelper.a(this.this$0).d.getProxyManager().g();
      Object localObject1 = TroopNotificationAIOHelper.a(this.this$0).ah.b;
      int i = 1;
      localObject1 = localRecentUserProxy.b((String)localObject1, 1);
      Object localObject2 = TroopNotificationHelper.d(TroopNotificationAIOHelper.a(this.this$0).d, TroopNotificationAIOHelper.a(this.this$0).ah.b);
      if ((localObject2 == null) || (((TroopNotificationFlagMsg)localObject2).a.isEmpty())) {
        i = 0;
      }
      localObject2 = TroopNotificationAIOHelper.a(this.this$0).d.getHandler(Conversation.class);
      if (i == 0) {
        if (!TroopAssistantManager.a().a(TroopNotificationAIOHelper.a(this.this$0).d, TroopNotificationAIOHelper.a(this.this$0).ah.b))
        {
          if ((((RecentUser)localObject1).msg instanceof TroopNotificationMsg))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TroopNotificationAIOHelper", 2, "doOnStop. clear recent user of TroopNotificationMsg.");
            }
            ((RecentUser)localObject1).cleanMsgAndMsgData(((RecentUser)localObject1).msgType);
            localRecentUserProxy.b((RecentUser)localObject1);
            if (localObject2 != null) {
              ((MqqHandler)localObject2).sendEmptyMessage(1009);
            }
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationAIOHelper", 2, "remove recent user on stop.");
          }
          localRecentUserProxy.a((RecentUser)localObject1, false);
          if (localObject2 != null) {
            ((MqqHandler)localObject2).sendEmptyMessage(1009);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopNotificationAIOHelper.2
 * JD-Core Version:    0.7.0.1
 */