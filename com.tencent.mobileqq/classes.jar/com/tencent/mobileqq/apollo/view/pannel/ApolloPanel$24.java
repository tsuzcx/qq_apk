package com.tencent.mobileqq.apollo.view.pannel;

import com.tencent.qphone.base.util.QLog;

class ApolloPanel$24
  implements Runnable
{
  ApolloPanel$24(ApolloPanel paramApolloPanel) {}
  
  public void run()
  {
    if ((ApolloPanel.a(this.this$0) != null) && (ApolloPanel.a(this.this$0) != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "refreshPanel. Thread id = " + Thread.currentThread().getId());
      }
      ApolloPanel.a(this.this$0).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.24
 * JD-Core Version:    0.7.0.1
 */