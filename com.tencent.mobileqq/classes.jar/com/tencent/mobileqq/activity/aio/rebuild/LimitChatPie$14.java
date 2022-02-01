package com.tencent.mobileqq.activity.aio.rebuild;

import aimd;
import asvi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class LimitChatPie$14
  implements Runnable
{
  public LimitChatPie$14(aimd paramaimd) {}
  
  public void run()
  {
    asvi localasvi;
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localasvi = (asvi)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264);
      if (localasvi != null) {
        break label45;
      }
      QLog.e(this.this$0.jdField_a_of_type_JavaLangString, 2, "saveExtendFriendInfoInSubThread  extendFriendManager Is null");
    }
    label45:
    while (aimd.a(this.this$0) == null) {
      return;
    }
    localasvi.a(aimd.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.14
 * JD-Core Version:    0.7.0.1
 */