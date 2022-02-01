package com.tencent.mobileqq.apollo.aio.panel;

import com.tencent.qphone.base.util.QLog;

class ApolloPanel$23
  implements Runnable
{
  ApolloPanel$23(ApolloPanel paramApolloPanel) {}
  
  public void run()
  {
    if ((ApolloPanel.a(this.this$0) != null) && (ApolloPanel.a(this.this$0) != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("refreshPanel. Thread id = ");
        localStringBuilder.append(Thread.currentThread().getId());
        QLog.d("[cmshow]ApolloPanel", 2, localStringBuilder.toString());
      }
      ApolloPanel.a(this.this$0).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.23
 * JD-Core Version:    0.7.0.1
 */