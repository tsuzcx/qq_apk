package com.tencent.mobileqq.apollo.view.pannel;

import com.tencent.qphone.base.util.QLog;

class ApolloPanel$6
  implements Runnable
{
  ApolloPanel$6(ApolloPanel paramApolloPanel) {}
  
  public void run()
  {
    try
    {
      this.this$0.e();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloPanel", 1, "[reportTabExposure] failed, excetion2=", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.6
 * JD-Core Version:    0.7.0.1
 */