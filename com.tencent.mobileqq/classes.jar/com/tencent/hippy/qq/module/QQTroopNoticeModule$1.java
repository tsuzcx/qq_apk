package com.tencent.hippy.qq.module;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;

class QQTroopNoticeModule$1
  extends BroadcastReceiver
{
  QQTroopNoticeModule$1(QQTroopNoticeModule paramQQTroopNoticeModule, Promise paramPromise) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("callback");
    QLog.d("TroopReceiver", 4, paramContext);
    this.val$promise.resolve(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQTroopNoticeModule.1
 * JD-Core Version:    0.7.0.1
 */