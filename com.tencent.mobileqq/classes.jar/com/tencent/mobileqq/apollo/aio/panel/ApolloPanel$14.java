package com.tencent.mobileqq.apollo.aio.panel;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ApolloPanel$14
  implements Runnable
{
  public void run()
  {
    if (ApolloPanel.v(this.this$0) == null) {
      return;
    }
    QLog.d("[cmshow]ApolloPanel", 2, "clear bindList");
    ApolloPanel.r(this.this$0).clear();
    ApolloPanel.v(this.this$0).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.14
 * JD-Core Version:    0.7.0.1
 */