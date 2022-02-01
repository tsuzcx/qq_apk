package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class ReadinjoySPEventReport$ScreenReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
      {
        QLog.d("ReadinjoySPEventReport", 2, "receive screen off broadcast");
        ReadinjoySPEventReport.e(false);
        return;
      }
      if (paramIntent.getAction().equals("android.intent.action.SCREEN_ON"))
      {
        QLog.d("ReadinjoySPEventReport", 2, "receive screen on broadcast");
        ReadinjoySPEventReport.e(true);
        return;
      }
      if ("mqq.intent.action.QQ_FOREGROUND".equals(paramIntent.getAction()))
      {
        ReadinjoySPEventReport.c(false);
        ReadinjoySPEventReport.o();
        return;
      }
    } while (!"mqq.intent.action.QQ_BACKGROUND".equals(paramIntent.getAction()));
    ReadinjoySPEventReport.d(false);
    ReadinjoySPEventReport.o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.ScreenReceiver
 * JD-Core Version:    0.7.0.1
 */