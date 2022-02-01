package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class QavPanel$ScreenBroadcastReceiver
  extends BroadcastReceiver
{
  QavPanel$ScreenBroadcastReceiver(QavPanel paramQavPanel) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (paramIntent.getAction() == null) {
        return;
      }
      if ("android.intent.action.SCREEN_ON".equals(paramIntent.getAction()))
      {
        if ((this.a.a != null) && (this.a.b) && (this.a.a.getVisibility() == 0)) {
          this.a.a.f();
        }
      }
      else if (("android.intent.action.SCREEN_OFF".equals(paramIntent.getAction())) && (this.a.a != null)) {
        this.a.a.g();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavPanel.ScreenBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */