package com.tencent.imcore.message.facade.unread.count;

import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import java.util.Locale;

class ShopAccountUnreadCountCalculateStrategy
  implements UnreadCountCalculateStrategy
{
  public int a(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, StringBuilder paramStringBuilder)
  {
    if ((MiniAppConfProcessor.a("MiniAppEcShopNumMsgEnable", 1) == 1) && (paramQQAppInterface.getConversationFacade().b(AppConstants.EC_SHOP_ASSISTANT_UIN, 7120)))
    {
      int i = ((EcShopAssistantManager)paramQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).a(paramQQAppInterface);
      paramStringBuilder.append(String.format(Locale.US, "(%s,%d,%d) ", new Object[] { AppConstants.SERVICE_ACCOUNT_FOLDER_UIN, Integer.valueOf(7120), Integer.valueOf(i) }));
      return i;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.unread.count.ShopAccountUnreadCountCalculateStrategy
 * JD-Core Version:    0.7.0.1
 */