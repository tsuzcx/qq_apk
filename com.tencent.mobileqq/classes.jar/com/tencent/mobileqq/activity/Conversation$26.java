package com.tencent.mobileqq.activity;

import akaa;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class Conversation$26
  implements Runnable
{
  Conversation$26(Conversation paramConversation) {}
  
  public void run()
  {
    akaa localakaa = (akaa)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    this.this$0.p = localakaa.b("sp_mayknow_entry_list_msg");
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, " shouldShowConversationMayknow = " + this.this$0.p);
    }
    ArrayList localArrayList = localakaa.c();
    if ((this.this$0.p) && (localArrayList != null) && (localArrayList.size() > 0)) {
      localakaa.d();
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      return;
      localakaa.e();
      this.this$0.p = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.26
 * JD-Core Version:    0.7.0.1
 */