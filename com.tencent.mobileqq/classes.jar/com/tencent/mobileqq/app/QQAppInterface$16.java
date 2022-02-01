package com.tencent.mobileqq.app;

import com.tencent.common.app.BaseApplicationImpl;

class QQAppInterface$16
  implements Runnable
{
  QQAppInterface$16(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      QQAppInterface.f(this.this$0).unregisterReceiver(QQAppInterface.b(this.this$0));
      try
      {
        label17:
        QQAppInterface.g(this.this$0).unregisterReceiver(QQAppInterface.a(this.this$0));
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
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.16
 * JD-Core Version:    0.7.0.1
 */