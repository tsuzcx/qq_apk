package com.tencent.mobileqq.activity.registerGuideLogin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class GuideVideoHandler$1
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.GuideVideoHandler", 2, "onReceive ===>" + paramContext);
    }
    if (("android.intent.action.SCREEN_OFF".equals(paramContext)) || ("tencent.av.v2q.StartVideoChat".equals(paramContext)))
    {
      GuideVideoHandler.a(this.a, true);
      if (!GuideVideoHandler.a(GuideVideoHandler.a())) {
        this.a.a();
      }
    }
    while ((!"android.intent.action.USER_PRESENT".equals(paramContext)) || (!GuideVideoHandler.a(GuideVideoHandler.b()))) {
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.GuideVideoHandler.1
 * JD-Core Version:    0.7.0.1
 */