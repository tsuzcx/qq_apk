package com.tencent.mobileqq.app;

import ofd;
import tmz;

class QQAppInterface$19
  implements Runnable
{
  QQAppInterface$19(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ofd localofd = (ofd)this.this$0.getManager(QQManagerFactory.PUBLIC_ACCOUNT_VIDEO_PRELOAD_MANAGER);
    if (localofd != null) {
      localofd.a(1);
    }
    this.this$0.setTalkbackSwitch();
    QQAppInterface.access$3700(this.this$0);
    tmz.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.19
 * JD-Core Version:    0.7.0.1
 */