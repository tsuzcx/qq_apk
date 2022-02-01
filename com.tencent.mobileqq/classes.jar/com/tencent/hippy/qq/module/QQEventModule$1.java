package com.tencent.hippy.qq.module;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class QQEventModule$1
  extends BroadcastReceiver
{
  QQEventModule$1(QQEventModule paramQQEventModule) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init onReceive getAction:");
      localStringBuilder.append(paramIntent.getAction());
      QLog.d("QQEventModule", 2, localStringBuilder.toString());
    }
    QQEventModule.access$000(this.this$0, paramContext, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQEventModule.1
 * JD-Core Version:    0.7.0.1
 */