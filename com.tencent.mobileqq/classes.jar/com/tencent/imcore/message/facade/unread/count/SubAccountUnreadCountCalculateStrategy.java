package com.tencent.imcore.message.facade.unread.count;

import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import java.util.Locale;

class SubAccountUnreadCountCalculateStrategy
  implements UnreadCountCalculateStrategy
{
  public int a(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, StringBuilder paramStringBuilder)
  {
    if (paramQQAppInterface.getConversationFacade().o(AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7000))
    {
      paramQQMessageFacade = (IConversationFacade)paramQQAppInterface.getRuntimeService(IConversationFacade.class, "");
      int i = ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).getAllSubAccountMsgUnreadNum(paramQQAppInterface, paramQQMessageFacade);
      paramStringBuilder.append(String.format(Locale.US, "(%s,%d,%d) ", new Object[] { AppConstants.SUBACCOUNT_ASSISTANT_UIN, Integer.valueOf(7000), Integer.valueOf(i) }));
      return i;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.unread.count.SubAccountUnreadCountCalculateStrategy
 * JD-Core Version:    0.7.0.1
 */