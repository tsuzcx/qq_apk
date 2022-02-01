package com.tencent.mobileqq.app.lifecycle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class BaseActivityInjectImpl$MyScreenReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 0;
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if (localQBaseActivity == null) {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, paramIntent.getAction());
      }
    }
    for (;;)
    {
      return;
      if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
      {
        paramIntent = (ILoginRegisterApi)QRoute.api(ILoginRegisterApi.class);
        if ((localQBaseActivity.getStopFlag() == 0) && (localQBaseActivity.isCanLock()) && (GesturePWDUtils.getGesturePWDState(localQBaseActivity, localQBaseActivity.getCurrentAccountUinFromRuntime()) == 2) && (GesturePWDUtils.getGesturePWDMode(localQBaseActivity, localQBaseActivity.getCurrentAccountUinFromRuntime()) == 21) && (!(localQBaseActivity instanceof GesturePWDUnlockActivity)) && (!paramIntent.getLoginActivityClass().isInstance(localQBaseActivity)) && (!GesturePWDUtils.getGestureLocking(localQBaseActivity)))
        {
          QBaseActivity.mAppForground = false;
          GesturePWDUtils.setAppForground(paramContext, QBaseActivity.mAppForground);
          QBaseActivity.isUnLockSuccess = false;
          if (QBaseActivity.getShakeListener() == null) {
            continue;
          }
          if (SettingCloneUtil.readValue(paramContext, null, paramContext.getString(2131694985), "qqsetting_screenshot_key", false)) {
            break label181;
          }
        }
        for (;;)
        {
          if (i == 0) {
            break label184;
          }
          localQBaseActivity.turnOffShake();
          return;
          localQBaseActivity.receiveScreenOff();
          break;
          label181:
          i = 1;
        }
      }
      else
      {
        label184:
        if ((paramIntent.getAction().equals("android.intent.action.SCREEN_ON")) && (QBaseActivity.getShakeListener() == null))
        {
          if (!SettingCloneUtil.readValue(paramContext, null, paramContext.getString(2131694985), "qqsetting_screenshot_key", false)) {}
          for (i = 0; i != 0; i = 1)
          {
            localQBaseActivity.turnOnShake();
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.lifecycle.BaseActivityInjectImpl.MyScreenReceiver
 * JD-Core Version:    0.7.0.1
 */