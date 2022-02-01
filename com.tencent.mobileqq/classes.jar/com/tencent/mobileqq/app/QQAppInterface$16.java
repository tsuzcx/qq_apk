package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import mqq.app.MobileQQ;

class QQAppInterface$16
  implements Runnable
{
  QQAppInterface$16(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.this$0.getApp()).edit();
    localEditor.putString("LastScreenShotUri", "");
    localEditor.commit();
    try
    {
      QQAppInterface.access$2700(this.this$0).unregisterReceiver(QQAppInterface.access$2600(this.this$0));
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.16
 * JD-Core Version:    0.7.0.1
 */