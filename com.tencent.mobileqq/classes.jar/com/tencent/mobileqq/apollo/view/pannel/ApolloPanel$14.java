package com.tencent.mobileqq.apollo.view.pannel;

import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ApolloPanel$14
  implements Runnable
{
  ApolloPanel$14(ApolloPanel paramApolloPanel) {}
  
  public void run()
  {
    if ((ApolloPanel.a(this.this$0) != null) && (ApolloPanel.a(this.this$0) != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "func initLastApolloPanel begins. Thread id = " + Thread.currentThread().getId());
      }
      ApolloPanel.b(this.this$0).clear();
      ApolloPanel.b(this.this$0).add(ApolloPanel.a(this.this$0));
      ApolloPanel.a(this.this$0).setVisibility(8);
      ApolloPanel.a(this.this$0).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.14
 * JD-Core Version:    0.7.0.1
 */