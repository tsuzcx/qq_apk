package com.tencent.mobileqq.app;

import mqq.app.MobileQQ;

class QQAppInterface$15
  implements Runnable
{
  QQAppInterface$15(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      QQAppInterface.access$2400(this.this$0).unregisterReceiver(QQAppInterface.access$2300(this.this$0));
      try
      {
        label17:
        QQAppInterface.access$2500(this.this$0).unregisterReceiver(QQAppInterface.access$1500(this.this$0));
        return;
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      break label17;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.15
 * JD-Core Version:    0.7.0.1
 */