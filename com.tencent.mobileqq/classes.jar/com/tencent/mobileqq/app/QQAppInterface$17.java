package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;

class QQAppInterface$17
  implements Runnable
{
  QQAppInterface$17(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.this$0.getApp()).edit();
    localEditor.putString("LastScreenShotUri", "");
    localEditor.commit();
    this.this$0.clearLebaResourceInfoList();
    try
    {
      QQAppInterface.access$3300(this.this$0).unregisterReceiver(QQAppInterface.access$3200(this.this$0));
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.17
 * JD-Core Version:    0.7.0.1
 */