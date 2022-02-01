package com.tencent.mobileqq.activity.aio.rebuild;

import ahiu;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import ocw;
import ugf;

public class PublicAccountChatPie$29
  implements Runnable
{
  public PublicAccountChatPie$29(ahiu paramahiu, AccountDetail paramAccountDetail) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.tag, 2, "updateUnfollowInfo");
    }
    if (this.this$0.i)
    {
      int i = ugf.a(this.a.accountFlag);
      if ((i == -3) || (i == -4)) {
        ocw.a().a(this.this$0.app, this.a.uin);
      }
    }
    if (this.this$0.a != null) {
      this.this$0.a.b(this.a);
    }
    ahiu.b(this.this$0, this.a);
    ahiu.a(this.this$0).post(new PublicAccountChatPie.29.1(this));
    this.this$0.app.getMessageFacade().clearHistory(this.this$0.sessionInfo.curFriendUin, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.29
 * JD-Core Version:    0.7.0.1
 */