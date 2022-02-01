package com.tencent.mobileqq.apollo.aio.panel;

import com.tencent.qphone.base.util.QLog;

class ApolloPanel$18
  implements Runnable
{
  ApolloPanel$18(ApolloPanel paramApolloPanel) {}
  
  public void run()
  {
    if ((ApolloPanel.v(this.this$0) != null) && (ApolloPanel.u(this.this$0) != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("refreshPanel. Thread id = ");
        localStringBuilder.append(Thread.currentThread().getId());
        QLog.d("[cmshow]ApolloPanel", 2, localStringBuilder.toString());
      }
      ApolloPanel.v(this.this$0).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.18
 * JD-Core Version:    0.7.0.1
 */