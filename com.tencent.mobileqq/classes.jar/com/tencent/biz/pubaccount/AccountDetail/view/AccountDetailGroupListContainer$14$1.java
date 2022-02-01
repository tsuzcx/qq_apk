package com.tencent.biz.pubaccount.accountdetail.view;

import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.applets.NewPublicAccountObserver.ResponseResultListener;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

class AccountDetailGroupListContainer$14$1
  extends NewPublicAccountObserver.ResponseResultListener
{
  AccountDetailGroupListContainer$14$1(AccountDetailGroupListContainer.14 param14, int paramInt) {}
  
  public int a()
  {
    return 7;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof ArrayList))
    {
      Object localObject1 = ((ArrayList)paramObject).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (((localObject2 instanceof AppletItem)) && (((AppletItem)localObject2).f().equals(this.b.c.g)))
        {
          this.b.a.f = this.a;
          paramObject = null;
          localObject1 = (IPublicAccountDataManager)this.b.c.b.getRuntimeService(IPublicAccountDataManager.class, "all");
          if (localObject1 != null) {
            paramObject = (PublicAccountDetailImpl)((IPublicAccountDataManager)localObject1).findAccountDetailInfo(this.b.c.g);
          }
          if (paramObject != null)
          {
            int i = this.b.a.g;
            boolean bool = true;
            if (i == 6)
            {
              i = this.a;
              if (i == 1) {
                paramObject.mShowMsgFlag = i;
              }
            }
            else if (this.b.a.g == 3)
            {
              paramObject.isSyncLbs = true;
              if (this.b.a.f != 1) {
                bool = false;
              }
              paramObject.isAgreeSyncLbs = bool;
            }
            ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailGroupListContainer.14.1.1(this, paramObject), 10L);
            AccountDetailGroupListContainer.a(this.b.c, this.b.a);
            ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).sendDetailInfoRequest(this.b.c.b, this.b.c.b.getApplication(), this.b.c.g);
          }
          return;
        }
      }
    }
    b(paramObject);
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("success:");
      paramObject.append(paramBoolean);
      QLog.d("AccountDetailGroupListContainer", 2, paramObject.toString());
    }
  }
  
  public void b(Object paramObject)
  {
    AccountDetailGroupListContainer.a(this.b.c, 2131892951);
  }
  
  public void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.14.1
 * JD-Core Version:    0.7.0.1
 */