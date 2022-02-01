package com.tencent.mobileqq.app;

import nyd;
import szr;

class QQAppInterface$19
  implements Runnable
{
  QQAppInterface$19(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    nyd localnyd = (nyd)this.this$0.getManager(238);
    if (localnyd != null) {
      localnyd.a(1);
    }
    this.this$0.setTalkbackSwitch();
    QQAppInterface.access$3700(this.this$0);
    szr.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.19
 * JD-Core Version:    0.7.0.1
 */