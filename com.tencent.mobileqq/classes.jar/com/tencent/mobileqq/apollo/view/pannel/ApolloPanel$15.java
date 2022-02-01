package com.tencent.mobileqq.apollo.view.pannel;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ApolloPanel$15
  implements Runnable
{
  public void run()
  {
    if (ApolloPanel.a(this.this$0) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "clear bindList");
      }
      ApolloPanel.b(this.this$0).clear();
      ApolloPanel.a(this.this$0).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.15
 * JD-Core Version:    0.7.0.1
 */