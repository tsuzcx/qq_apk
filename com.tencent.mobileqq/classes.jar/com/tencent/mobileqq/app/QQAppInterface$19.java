package com.tencent.mobileqq.app;

import nws;
import svr;

class QQAppInterface$19
  implements Runnable
{
  QQAppInterface$19(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    nws localnws = (nws)this.this$0.getManager(238);
    if (localnws != null) {
      localnws.a(1);
    }
    this.this$0.F();
    QQAppInterface.b(this.this$0);
    svr.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.19
 * JD-Core Version:    0.7.0.1
 */