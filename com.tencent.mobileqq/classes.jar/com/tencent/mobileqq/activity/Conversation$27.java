package com.tencent.mobileqq.activity;

import ajls;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class Conversation$27
  implements Runnable
{
  Conversation$27(Conversation paramConversation) {}
  
  public void run()
  {
    ajls localajls = (ajls)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    this.this$0.p = localajls.b("sp_mayknow_entry_list_msg");
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, " shouldShowConversationMayknow = " + this.this$0.p);
    }
    ArrayList localArrayList = localajls.c();
    if ((this.this$0.p) && (localArrayList != null) && (localArrayList.size() > 0)) {
      localajls.d();
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      return;
      localajls.e();
      this.this$0.p = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.27
 * JD-Core Version:    0.7.0.1
 */