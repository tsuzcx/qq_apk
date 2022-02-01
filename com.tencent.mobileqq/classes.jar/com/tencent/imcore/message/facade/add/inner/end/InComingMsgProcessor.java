package com.tencent.imcore.message.facade.add.inner.end;

import com.tencent.imcore.message.BaseMessageManager.AddMessageContext;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.facade.IAddMultiMessagesInnerEndProcessor;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class InComingMsgProcessor
  implements IAddMultiMessagesInnerEndProcessor<QQMessageFacade, QQAppInterface>
{
  private void a(BaseMessageManager.AddMessageContext paramAddMessageContext, Message paramMessage)
  {
    if (paramMessage != null)
    {
      int j = 0;
      int i;
      if (paramMessage.istroop == 1)
      {
        paramAddMessageContext = ((TroopInfoManager)paramAddMessageContext.jdField_a_of_type_MqqManagerManager).a(paramMessage.frienduin);
        i = j;
        if (paramAddMessageContext != null)
        {
          i = j;
          if (paramAddMessageContext.a() == paramMessage.shmsgseq) {
            i = paramAddMessageContext.a();
          }
        }
      }
      else
      {
        i = j;
        if (paramMessage.istroop == 3000)
        {
          paramAddMessageContext = (TroopInfoManager)paramAddMessageContext.jdField_a_of_type_MqqManagerManager;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramMessage.frienduin);
          localStringBuilder.append("&");
          localStringBuilder.append(3000);
          paramAddMessageContext = paramAddMessageContext.a(localStringBuilder.toString());
          i = j;
          if (paramAddMessageContext != null)
          {
            i = j;
            if (paramAddMessageContext.a() == paramMessage.shmsgseq) {
              i = paramAddMessageContext.b();
            }
          }
        }
      }
      paramMessage.bizType = i;
    }
  }
  
  private void a(QQMessageFacade paramQQMessageFacade, QQAppInterface paramQQAppInterface, BaseMessageManager.AddMessageContext paramAddMessageContext, Message paramMessage, RecentUser paramRecentUser)
  {
    ((IHotChatUtil)QRoute.api(IHotChatUtil.class)).checkIsHCRecentUser(paramQQAppInterface, paramRecentUser);
    RecentUtil.a(paramRecentUser, paramQQMessageFacade);
    paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy.b(paramRecentUser);
    if (paramRecentUser.getType() == 1038) {
      ((AppletsFolderManager)paramQQAppInterface.getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER)).a(paramRecentUser);
    }
    if (paramMessage != null)
    {
      if (paramMessage.istroop == 3000)
      {
        paramQQMessageFacade = (TroopInfoManager)paramAddMessageContext.jdField_a_of_type_MqqManagerManager;
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(paramRecentUser.uin);
        paramQQAppInterface.append("&");
        paramQQAppInterface.append(3000);
        paramQQMessageFacade.b(paramQQAppInterface.toString());
        return;
      }
      ((TroopInfoManager)paramAddMessageContext.jdField_a_of_type_MqqManagerManager).b(paramRecentUser.uin);
    }
  }
  
  public void a(QQMessageFacade paramQQMessageFacade, QQAppInterface paramQQAppInterface, List<MessageRecord> paramList, BaseMessageManager.AddMessageContext paramAddMessageContext, boolean paramBoolean)
  {
    paramList = paramQQMessageFacade.a();
    a(paramAddMessageContext, paramList);
    Iterator localIterator = paramAddMessageContext.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (RecentUser)paramAddMessageContext.jdField_a_of_type_JavaUtilMap.get(localObject);
      try
      {
        a(paramQQMessageFacade, paramQQAppInterface, paramAddMessageContext, paramList, (RecentUser)localObject);
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addMultiMessagesInner --> Catch Exception .Info = ");
        localStringBuilder.append(localException);
        QLog.e("InComingMsgProcessor", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.add.inner.end.InComingMsgProcessor
 * JD-Core Version:    0.7.0.1
 */