package com.tencent.mobileqq.app.face;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.qphone.base.util.QLog;

class GroupIconHelper$1
  implements Runnable
{
  GroupIconHelper$1(GroupIconHelper paramGroupIconHelper, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.a.addObserver(this.this$0);
    try
    {
      ((IPhoneContactService)this.a.getRuntimeService(IPhoneContactService.class, "")).addListener(this.this$0);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("Q.qqhead.dih", 2, "init phoneContactService", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.GroupIconHelper.1
 * JD-Core Version:    0.7.0.1
 */