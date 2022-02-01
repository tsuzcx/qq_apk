package com.tencent.mobileqq.activity.aio.rebuild;

import aicl;
import asfu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class LimitChatPie$14
  implements Runnable
{
  public LimitChatPie$14(aicl paramaicl) {}
  
  public void run()
  {
    asfu localasfu;
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localasfu = (asfu)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264);
      if (localasfu != null) {
        break label45;
      }
      QLog.e(this.this$0.jdField_a_of_type_JavaLangString, 2, "saveExtendFriendInfoInSubThread  extendFriendManager Is null");
    }
    label45:
    while (aicl.a(this.this$0) == null) {
      return;
    }
    localasfu.a(aicl.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.14
 * JD-Core Version:    0.7.0.1
 */