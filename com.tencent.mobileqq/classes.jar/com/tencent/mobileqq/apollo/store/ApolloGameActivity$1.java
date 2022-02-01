package com.tencent.mobileqq.apollo.store;

import com.tencent.mobileqq.apollo.process.ui.framework.FrameworkView;
import com.tencent.mobileqq.apollo.process.ui.framework.FrameworkViewFactory;
import com.tencent.qphone.base.util.QLog;

class ApolloGameActivity$1
  implements Runnable
{
  ApolloGameActivity$1(ApolloGameActivity paramApolloGameActivity) {}
  
  public void run()
  {
    if ((ApolloGameActivity.a(this.this$0) != null) && (ApolloGameActivity.a(this.this$0) != null) && (ApolloGameActivity.a(this.this$0) != null)) {}
    try
    {
      ApolloGameActivity.a(this.this$0).g();
      ApolloGameActivity.a(this.this$0, FrameworkViewFactory.a(this.this$0, ApolloGameActivity.a(this.this$0), ApolloGameActivity.a(this.this$0), this.this$0, ApolloGameActivity.a(this.this$0)));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(this.this$0.a, 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGameActivity.1
 * JD-Core Version:    0.7.0.1
 */