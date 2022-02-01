package com.tencent.mobileqq.app;

import com.tencent.mobileqq.service.MobileQQServiceExtend;
import mqq.manager.Manager;

class QQAppInterface$10
  implements Runnable
{
  QQAppInterface$10(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.this$0.mqqService != null) {
      this.this$0.mqqService.destroy();
    }
    int i = 0;
    while (i < QQAppInterface.access$2000(this.this$0).length)
    {
      Manager localManager = QQAppInterface.access$2000(this.this$0)[i];
      if (localManager != null) {
        localManager.onDestroy();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.10
 * JD-Core Version:    0.7.0.1
 */