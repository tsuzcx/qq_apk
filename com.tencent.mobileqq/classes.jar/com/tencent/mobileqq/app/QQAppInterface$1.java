package com.tencent.mobileqq.app;

import android.content.IntentFilter;
import mqq.app.MobileQQ;

class QQAppInterface$1
  implements Runnable
{
  QQAppInterface$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    QQAppInterface.access$1400(this.this$0);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.qzone.cleanunreadcount");
    localIntentFilter.addAction("com.tecent.qzone.clearAlbumRedTouch");
    QQAppInterface.access$1600(this.this$0).registerReceiver(QQAppInterface.access$1500(this.this$0), localIntentFilter);
    VideoBroadcastReceiver.a(this.this$0);
    if (this.this$0.isAccLoginSuccess()) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.1
 * JD-Core Version:    0.7.0.1
 */