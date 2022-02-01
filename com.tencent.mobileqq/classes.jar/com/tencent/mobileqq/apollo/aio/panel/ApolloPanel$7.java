package com.tencent.mobileqq.apollo.aio.panel;

import com.tencent.qphone.base.util.QLog;

class ApolloPanel$7
  implements Runnable
{
  ApolloPanel$7(ApolloPanel paramApolloPanel) {}
  
  public void run()
  {
    try
    {
      ApolloPanel.p(this.this$0);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow]ApolloPanel", 1, "[reportTabExposure] failed, excetion2=", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.7
 * JD-Core Version:    0.7.0.1
 */