package com.tencent.mobileqq.activity;

import aeig;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;

public class Conversation$34$2
  implements Runnable
{
  public Conversation$34$2(aeig paramaeig, boolean paramBoolean) {}
  
  public void run()
  {
    Conversation.a(this.jdField_a_of_type_Aeig.a, 800L);
    PullRefreshHeader localPullRefreshHeader;
    if (this.jdField_a_of_type_Aeig.a.a != null)
    {
      localPullRefreshHeader = this.jdField_a_of_type_Aeig.a.a;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.34.2
 * JD-Core Version:    0.7.0.1
 */