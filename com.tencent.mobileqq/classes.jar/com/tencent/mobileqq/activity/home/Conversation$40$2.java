package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;

class Conversation$40$2
  implements Runnable
{
  Conversation$40$2(Conversation.40 param40, boolean paramBoolean) {}
  
  public void run()
  {
    Conversation.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$40.a, 800L);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$40.a.a != null)
    {
      PullRefreshHeader localPullRefreshHeader = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$40.a.a;
      int i;
      if (this.jdField_a_of_type_Boolean) {
        i = 0;
      } else {
        i = 2;
      }
      localPullRefreshHeader.a(i);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AutoMonitor", 2, "ConversationTab[onRefleshRecentListFinished_ui]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.40.2
 * JD-Core Version:    0.7.0.1
 */