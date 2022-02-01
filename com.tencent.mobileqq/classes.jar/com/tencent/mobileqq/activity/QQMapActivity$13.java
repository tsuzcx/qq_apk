package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.qphone.base.util.QLog;

class QQMapActivity$13
  extends BroadcastReceiver
{
  QQMapActivity$13(QQMapActivity paramQQMapActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equals("android.intent.action.SCREEN_OFF")) && (!this.a.hasLocked) && (!this.a.hasStoped))
    {
      paramContext = this.a;
      if (GesturePWDUtils.getGesturePWDState(paramContext, paramContext.uin) == 2)
      {
        paramContext = this.a;
        if (GesturePWDUtils.getGesturePWDMode(paramContext, paramContext.uin) == 21)
        {
          if (QLog.isColorLevel()) {
            QLog.d("qqbaseactivity", 2, "qqmapactivity.start lock. receive lock.");
          }
          paramContext = new Intent(this.a, GesturePWDUnlockActivity.class);
          QQMapActivity.access$101(this.a, paramContext);
          this.a.hasStoped = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQMapActivity.13
 * JD-Core Version:    0.7.0.1
 */