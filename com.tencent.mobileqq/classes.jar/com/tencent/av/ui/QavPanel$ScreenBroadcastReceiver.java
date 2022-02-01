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
        if ((this.a.f != null) && (this.a.T) && (this.a.f.getVisibility() == 0)) {
          this.a.f.f();
        }
      }
      else if (("android.intent.action.SCREEN_OFF".equals(paramIntent.getAction())) && (this.a.f != null)) {
        this.a.f.g();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavPanel.ScreenBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */