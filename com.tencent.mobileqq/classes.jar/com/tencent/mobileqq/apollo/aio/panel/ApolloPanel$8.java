package com.tencent.mobileqq.apollo.aio.panel;

import com.tencent.qphone.base.util.QLog;

class ApolloPanel$8
  implements Runnable
{
  ApolloPanel$8(ApolloPanel paramApolloPanel) {}
  
  public void run()
  {
    try
    {
      ApolloPanel.a(this.this$0);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow]ApolloPanel", 1, "[reportTabExposure] failed, excetion2=", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.8
 * JD-Core Version:    0.7.0.1
 */