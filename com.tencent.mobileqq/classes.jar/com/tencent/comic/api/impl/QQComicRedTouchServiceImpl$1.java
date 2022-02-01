package com.tencent.comic.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class QQComicRedTouchServiceImpl$1
  extends BroadcastReceiver
{
  QQComicRedTouchServiceImpl$1(QQComicRedTouchServiceImpl paramQQComicRedTouchServiceImpl) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicRedTouchService", 2, "Received red touch push");
    }
    QQComicRedTouchServiceImpl.access$001(this.a);
    QQComicRedTouchServiceImpl.access$101(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.api.impl.QQComicRedTouchServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */