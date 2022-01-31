package com.tencent.mobileqq.app;

import com.tencent.common.app.BaseApplicationImpl;

class QQAppInterface$18
  implements Runnable
{
  QQAppInterface$18(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      QQAppInterface.g(this.this$0).unregisterReceiver(QQAppInterface.b(this.this$0));
      try
      {
        label17:
        QQAppInterface.h(this.this$0).unregisterReceiver(QQAppInterface.a(this.this$0));
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
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.18
 * JD-Core Version:    0.7.0.1
 */