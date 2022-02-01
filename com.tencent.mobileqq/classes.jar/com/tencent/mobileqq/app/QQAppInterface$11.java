package com.tencent.mobileqq.app;

import bbjb;
import mqq.manager.Manager;

class QQAppInterface$11
  implements Runnable
{
  QQAppInterface$11(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.this$0.mqqService != null) {
      this.this$0.mqqService.b();
    }
    int i = 0;
    while (i < QQAppInterface.access$2600(this.this$0).length)
    {
      Manager localManager = QQAppInterface.access$2600(this.this$0)[i];
      if (localManager != null) {
        localManager.onDestroy();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.11
 * JD-Core Version:    0.7.0.1
 */