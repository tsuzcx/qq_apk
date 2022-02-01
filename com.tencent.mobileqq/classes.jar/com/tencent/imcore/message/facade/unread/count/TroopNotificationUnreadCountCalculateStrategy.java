package com.tencent.imcore.message.facade.unread.count;

import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

class TroopNotificationUnreadCountCalculateStrategy
  implements UnreadCountCalculateStrategy
{
  public int a(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, StringBuilder paramStringBuilder)
  {
    if (paramQQAppInterface.getConversationFacade().b(AppConstants.TROOP_NOTIFICATION_UIN, 9000))
    {
      int i = TroopNotificationUtils.a(paramQQAppInterface);
      if ((i != 0) && (QLog.isColorLevel()))
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("Recent TroopNotification Unread=");
        paramQQAppInterface.append(i);
        QLog.d("TroopNotificationUnreadCountCalculateStrategy", 2, paramQQAppInterface.toString());
      }
      paramStringBuilder.append(String.format(Locale.US, "(%s,%d,%d) ", new Object[] { AppConstants.TROOP_NOTIFICATION_UIN, Integer.valueOf(9000), Integer.valueOf(i) }));
      return i;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.unread.count.TroopNotificationUnreadCountCalculateStrategy
 * JD-Core Version:    0.7.0.1
 */