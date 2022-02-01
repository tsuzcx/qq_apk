package com.tencent.av.app;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class QAVNotifyActionMonitor
{
  private VideoAppInterface a;
  private BroadcastReceiver b;
  private boolean c;
  
  QAVNotifyActionMonitor(VideoAppInterface paramVideoAppInterface)
  {
    this.a = paramVideoAppInterface;
    this.b = new QAVNotifyActionMonitor.QAVNotifyActionReceiver(paramVideoAppInterface, null);
    this.c = false;
  }
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.qav.notify.accept");
    localIntentFilter.addAction("com.tencent.qav.notify.refuse");
    localIntentFilter.addAction("tencent.video.q2v.ptusoDownloadRet");
    localIntentFilter.addAction("tencent.video.q2v.avReceivePushMsg");
    localIntentFilter.addAction("com.tencent.qqhead.getheadresp2");
    this.a.getApplication().registerReceiver(this.b, localIntentFilter);
    this.c = true;
    if (QLog.isColorLevel()) {
      QLog.i("QAVNotifyActionMonitor", 2, "register");
    }
  }
  
  public void b()
  {
    if (this.c)
    {
      this.a.getApplication().unregisterReceiver(this.b);
      this.c = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QAVNotifyActionMonitor", 2, "unRegister");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.QAVNotifyActionMonitor
 * JD-Core Version:    0.7.0.1
 */