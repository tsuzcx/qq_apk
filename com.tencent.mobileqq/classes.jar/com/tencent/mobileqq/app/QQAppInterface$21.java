package com.tencent.mobileqq.app;

import nmb;
import sgi;

class QQAppInterface$21
  implements Runnable
{
  QQAppInterface$21(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    nmb localnmb = (nmb)this.this$0.getManager(238);
    if (localnmb != null) {
      localnmb.a(1);
    }
    this.this$0.E();
    QQAppInterface.b(this.this$0);
    sgi.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.21
 * JD-Core Version:    0.7.0.1
 */