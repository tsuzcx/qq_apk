package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;

class Conversation$38$2
  implements Runnable
{
  Conversation$38$2(Conversation.38 param38, boolean paramBoolean) {}
  
  public void run()
  {
    Conversation.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$38.a, 800L);
    PullRefreshHeader localPullRefreshHeader;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$38.a.a != null)
    {
      localPullRefreshHeader = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$38.a.a;
      if (!this.jdField_a_of_type_Boolean) {
        break label66;
      }
    }
    label66:
    for (int i = 0;; i = 2)
    {
      localPullRefreshHeader.a(i);
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ConversationTab[onRefleshRecentListFinished_ui]");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.38.2
 * JD-Core Version:    0.7.0.1
 */