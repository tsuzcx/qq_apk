package com.tencent.imcore.message.facade.unread.count;

import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import java.util.Locale;

class ServiceAccountUnreadCountCalculateStrategy
  implements UnreadCountCalculateStrategy
{
  public int a(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, StringBuilder paramStringBuilder)
  {
    if (paramQQAppInterface.getConversationFacade().o(AppConstants.SERVICE_ACCOUNT_FOLDER_UIN, 7230))
    {
      int j = ServiceAccountFolderManager.a().h();
      int k = ((IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).getNumRedNumByPath("104000.104001", 100);
      int i = j;
      if (k > 0) {
        i = j + k;
      }
      paramStringBuilder.append(String.format(Locale.US, "(%s,%d,%d) ", new Object[] { AppConstants.SERVICE_ACCOUNT_FOLDER_UIN, Integer.valueOf(7230), Integer.valueOf(i) }));
      return i;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.unread.count.ServiceAccountUnreadCountCalculateStrategy
 * JD-Core Version:    0.7.0.1
 */