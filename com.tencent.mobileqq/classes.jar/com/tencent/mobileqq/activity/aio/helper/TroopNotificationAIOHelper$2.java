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
    int i = 1;
    if (TroopNotificationAIOHelper.a(this.this$0) == null) {}
    label12:
    Object localObject;
    label252:
    do
    {
      break label12;
      break label12;
      do
      {
        return;
      } while ((TroopNotificationAIOHelper.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (TroopNotificationAIOHelper.a(this.this$0).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(TroopNotificationAIOHelper.a(this.this$0).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)));
      RecentUserProxy localRecentUserProxy = TroopNotificationAIOHelper.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
      RecentUser localRecentUser = localRecentUserProxy.a(TroopNotificationAIOHelper.a(this.this$0).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1);
      localObject = TroopNotificationHelper.a(TroopNotificationAIOHelper.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TroopNotificationAIOHelper.a(this.this$0).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if ((localObject != null) && (!((TroopNotificationFlagMsg)localObject).a.isEmpty())) {}
      for (;;)
      {
        localObject = TroopNotificationAIOHelper.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
        if (i != 0) {
          break;
        }
        if (TroopAssistantManager.a().a(TroopNotificationAIOHelper.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TroopNotificationAIOHelper.a(this.this$0).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
          break label252;
        }
        if (!(localRecentUser.msg instanceof TroopNotificationMsg)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotificationAIOHelper", 2, "doOnStop. clear recent user of TroopNotificationMsg.");
        }
        localRecentUser.cleanMsgAndMsgData(localRecentUser.msgType);
        localRecentUserProxy.b(localRecentUser);
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
      localRecentUserProxy.a(localRecentUser, false);
    } while (localObject == null);
    ((MqqHandler)localObject).sendEmptyMessage(1009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopNotificationAIOHelper.2
 * JD-Core Version:    0.7.0.1
 */