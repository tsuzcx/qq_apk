package com.tencent.imcore.message.facade.unread.count;

import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.Locale;

class TroopSendHelperUnreadCountCalculateStrategy
  implements UnreadCountCalculateStrategy
{
  public int a(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, StringBuilder paramStringBuilder)
  {
    if (paramQQAppInterface.getConversationFacade().b(AppConstants.SEND_BLESS_UIN, 9003))
    {
      paramQQAppInterface = (BlessManager)paramQQAppInterface.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER);
      if (paramQQAppInterface != null)
      {
        int i = paramQQAppInterface.b();
        paramStringBuilder.append(String.format(Locale.US, "(%s,%d,%d) ", new Object[] { AppConstants.SEND_BLESS_UIN, Integer.valueOf(9003), Integer.valueOf(i) }));
        return i;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.unread.count.TroopSendHelperUnreadCountCalculateStrategy
 * JD-Core Version:    0.7.0.1
 */