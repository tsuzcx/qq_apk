package com.tencent.imcore.message;

import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
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
  
  public void a(String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext)
  {
    Object localObject = this.a.a(paramInt1).g(paramString, paramInt1);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      if (localObject != null) {
        this.a.b.dumpmsgs("current Aio", ((List)localObject).subList(0, Math.min(15, ((List)localObject).size())));
      }
      long l = ((MessageRecord)((List)localObject).get(0)).uniseq;
      localObject = new ArrayList();
      paramRefreshMessageContext.e = true;
      if (paramRefreshMessageContext.e)
      {
        this.a.a(paramString, paramInt1, l, paramInt2, paramRefreshMessageContext, (ArrayList)localObject);
        this.a.a(paramInt1).b(paramString, paramInt1, (List)localObject);
        paramRefreshMessageContext.b = ((List)localObject);
        if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isMediaAndOtherSubscript((QQAppInterface)this.a.a, paramString)) {
          if ((paramRefreshMessageContext.b != null) && (paramRefreshMessageContext.b.size() != 0))
          {
            paramRefreshMessageContext.c = false;
            paramRefreshMessageContext.i = false;
          }
          else
          {
            l = ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).getMsgID((QQAppInterface)this.a.a, paramString);
            ((IPublicAccountHandler)((QQAppInterface)this.a.a).getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT)).getAIOHistoryMsg(paramString, l, 1);
            ReportController.b(this.a.a, "P_CliOper", "Pb_account_lifeservice", paramString, "0X8005C99", "0X8005C99", 0, 1, 0, "new", "2", "", "");
            return;
          }
        }
        paramString = this.a.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("refresh load local C2C msg only FIN , context = ");
        localStringBuilder.append(paramRefreshMessageContext);
        localStringBuilder.append(", size = ");
        localStringBuilder.append(((ArrayList)localObject).size());
        localObject = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(", timestamp = ");
        localStringBuilder.append(System.currentTimeMillis());
        paramString.qLogColor((String)localObject, localStringBuilder.toString());
        this.a.b.setChangeAndNotify(paramRefreshMessageContext);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead ERROR: AIO is closed !!");
    }
    paramRefreshMessageContext.b = null;
    this.a.a(paramRefreshMessageContext, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.PublicAccountRefresher
 * JD-Core Version:    0.7.0.1
 */