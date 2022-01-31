package com.tencent.mobileqq.app;

import avys;
import mqq.manager.Manager;

class QQAppInterface$10
  implements Runnable
{
  QQAppInterface$10(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.this$0.a != null) {
      this.this$0.a.c();
    }
    int i = 0;
    while (i < QQAppInterface.a(this.this$0).length)
    {
      Manager localManager = QQAppInterface.a(this.this$0)[i];
      if (localManager != null) {
        localManager.onDestroy();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.10
 * JD-Core Version:    0.7.0.1
 */