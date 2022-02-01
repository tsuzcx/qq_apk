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
      QQAppInterface.access$3000(this.this$0).unregisterReceiver(QQAppInterface.access$2900(this.this$0));
      try
      {
        label17:
        QQAppInterface.access$3100(this.this$0).unregisterReceiver(QQAppInterface.access$1500(this.this$0));
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