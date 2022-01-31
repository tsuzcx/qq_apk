package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.Looper;
import mqq.manager.Manager;

public class QQWiFiMainManager
  implements Manager
{
  public QQWiFiMainManager.RemoteResultReceiver a;
  
  QQWiFiMainManager(QQAppInterface paramQQAppInterface)
  {
    this.a = new QQWiFiMainManager.RemoteResultReceiver(paramQQAppInterface, new Handler(Looper.getMainLooper()));
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQWiFiMainManager
 * JD-Core Version:    0.7.0.1
 */