package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class Conversation$4
  implements Runnable
{
  Conversation$4(Conversation paramConversation) {}
  
  public void run()
  {
    boolean bool = ((IPhoneContactService)this.this$0.a.getRuntimeService(IPhoneContactService.class, "")).checkAndUploadContact(true);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("REQ_FOR_SETTING : ");
      localStringBuilder.append(bool);
      QLog.i("BindMsgConstant", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.4
 * JD-Core Version:    0.7.0.1
 */