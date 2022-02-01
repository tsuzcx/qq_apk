package com.tencent.imcore.message;

import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class PublicAccountRefresher
  implements IMessageRefresher
{
  private final C2CMessageManager a;
  
  public PublicAccountRefresher(C2CMessageManager paramC2CMessageManager)
  {
    this.a = paramC2CMessageManager;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).d(paramString, paramInt1);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead ERROR: AIO is closed !!");
      }
      paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = null;
      this.a.a(paramRefreshMessageContext, paramInt1);
    }
    long l;
    do
    {
      return;
      if (localObject != null) {
        this.a.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a("current Aio", ((List)localObject).subList(0, Math.min(15, ((List)localObject).size())));
      }
      l = ((MessageRecord)((List)localObject).get(0)).uniseq;
      localObject = new ArrayList();
      paramRefreshMessageContext.c = true;
    } while (!paramRefreshMessageContext.c);
    this.a.a(paramString, paramInt1, l, paramInt2, paramRefreshMessageContext, (ArrayList)localObject);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, (List)localObject);
    paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = ((List)localObject);
    if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isMediaAndOtherSubscript(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString))
    {
      if ((paramRefreshMessageContext.jdField_a_of_type_JavaUtilList == null) || (paramRefreshMessageContext.jdField_a_of_type_JavaUtilList.size() == 0))
      {
        l = ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).getMsgID(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
        ((PublicAccountHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT)).a(paramString, l, 1);
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X8005C99", "0X8005C99", 0, 1, 0, "new", "2", "", "");
        return;
      }
      paramRefreshMessageContext.jdField_a_of_type_Boolean = false;
      paramRefreshMessageContext.g = false;
    }
    paramString = this.a.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade;
    StringBuilder localStringBuilder = new StringBuilder().append("refresh load local C2C msg only FIN , context = ").append(paramRefreshMessageContext).append(", size = ");
    if (localObject == null) {}
    for (paramInt1 = -1;; paramInt1 = ((ArrayList)localObject).size())
    {
      paramString.a(paramInt1, ", timestamp = " + System.currentTimeMillis());
      this.a.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramRefreshMessageContext);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.PublicAccountRefresher
 * JD-Core Version:    0.7.0.1
 */