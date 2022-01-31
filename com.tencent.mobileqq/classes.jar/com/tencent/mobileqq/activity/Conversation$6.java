package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class Conversation$6
  implements Runnable
{
  Conversation$6(Conversation paramConversation) {}
  
  public void run()
  {
    boolean bool = ((PhoneContactManagerImp)this.this$0.a.getManager(11)).a(true);
    if (QLog.isColorLevel()) {
      QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING : " + bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.6
 * JD-Core Version:    0.7.0.1
 */