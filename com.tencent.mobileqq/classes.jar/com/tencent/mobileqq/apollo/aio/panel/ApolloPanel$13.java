package com.tencent.mobileqq.apollo.aio.panel;

import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ApolloPanel$13
  implements Runnable
{
  ApolloPanel$13(ApolloPanel paramApolloPanel) {}
  
  public void run()
  {
    if (ApolloPanel.a(this.this$0) != null)
    {
      if (ApolloPanel.a(this.this$0) == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("func initLastApolloPanel begins. Thread id = ");
        localStringBuilder.append(Thread.currentThread().getId());
        QLog.d("[cmshow]ApolloPanel", 2, localStringBuilder.toString());
      }
      ApolloPanel.b(this.this$0).clear();
      ApolloPanel.b(this.this$0).add(ApolloPanel.a(this.this$0));
      ApolloPanel.a(this.this$0).setVisibility(8);
      ApolloPanel.a(this.this$0).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.13
 * JD-Core Version:    0.7.0.1
 */