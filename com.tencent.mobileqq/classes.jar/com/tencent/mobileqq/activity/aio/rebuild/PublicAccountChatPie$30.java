package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class PublicAccountChatPie$30
  implements Runnable
{
  PublicAccountChatPie$30(PublicAccountChatPie paramPublicAccountChatPie, IPublicAccountDetail paramIPublicAccountDetail) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.c, 2, "updateUnfollowInfo");
    }
    if (this.this$0.bG)
    {
      int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(this.a.getAccountFlag());
      if ((i == -3) || (i == -4)) {
        ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).removeMsgID(this.this$0.d, this.a.getUin());
      }
    }
    if (this.this$0.bo != null) {
      this.this$0.bo.onUnfollowPublicAccount(this.a);
    }
    PublicAccountChatPie.b(this.this$0, this.a);
    PublicAccountChatPie.r(this.this$0).post(new PublicAccountChatPie.30.1(this));
    this.this$0.d.getMessageFacade().c(this.this$0.ah.b, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.30
 * JD-Core Version:    0.7.0.1
 */