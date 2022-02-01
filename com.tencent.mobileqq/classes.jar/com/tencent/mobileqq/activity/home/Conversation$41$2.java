package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.widget.IPullRefreshHeaderControl;
import com.tencent.qphone.base.util.QLog;

class Conversation$41$2
  implements Runnable
{
  Conversation$41$2(Conversation.41 param41, boolean paramBoolean) {}
  
  public void run()
  {
    this.b.a.b(800L);
    if (this.b.a.x != null)
    {
      IPullRefreshHeaderControl localIPullRefreshHeaderControl = this.b.a.x;
      int i;
      if (this.a) {
        i = 0;
      } else {
        i = 2;
      }
      localIPullRefreshHeaderControl.a(i);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AutoMonitor", 2, "ConversationTab[onRefleshRecentListFinished_ui]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.41.2
 * JD-Core Version:    0.7.0.1
 */