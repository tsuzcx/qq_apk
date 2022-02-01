package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import com.tencent.qphone.base.util.QLog;

class ApolloTagActionViewBinder$6
  implements Runnable
{
  ApolloTagActionViewBinder$6(ApolloTagActionViewBinder paramApolloTagActionViewBinder, String paramString) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPreSelectedText ");
    localStringBuilder.append(this.a);
    QLog.i("[cmshow]ApolloActionWithTagsViewBinder", 1, localStringBuilder.toString());
    if (ApolloTagActionViewBinder.c(this.this$0) != null) {
      ApolloTagActionViewBinder.ApolloActionTagsAdapter.b(ApolloTagActionViewBinder.c(this.this$0), this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloTagActionViewBinder.6
 * JD-Core Version:    0.7.0.1
 */