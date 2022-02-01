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
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if (localQBaseActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, paramIntent.getAction());
      }
      return;
    }
    boolean bool = paramIntent.getAction().equals("android.intent.action.SCREEN_OFF");
    int j = 1;
    int i = 1;
    if (bool)
    {
      paramIntent = (ILoginRegisterApi)QRoute.api(ILoginRegisterApi.class);
      if ((localQBaseActivity.getStopFlag() != 0) || (!localQBaseActivity.isCanLock()) || (GesturePWDUtils.getGesturePWDState(localQBaseActivity, localQBaseActivity.getCurrentAccountUinFromRuntime()) != 2) || (GesturePWDUtils.getGesturePWDMode(localQBaseActivity, localQBaseActivity.getCurrentAccountUinFromRuntime()) != 21) || ((localQBaseActivity instanceof GesturePWDUnlockActivity)) || (paramIntent.getLoginActivityClass().isInstance(localQBaseActivity)) || (GesturePWDUtils.getGestureLocking(localQBaseActivity))) {
        localQBaseActivity.receiveScreenOff();
      }
      QBaseActivity.mAppForground = false;
      GesturePWDUtils.setAppForground(paramContext, QBaseActivity.mAppForground);
      QBaseActivity.isUnLockSuccess = false;
      if (QBaseActivity.getShakeListener() != null)
      {
        if (!SettingCloneUtil.readValue(paramContext, null, paramContext.getString(2131694975), "qqsetting_screenshot_key", false)) {
          i = 0;
        }
        if (i != 0) {
          localQBaseActivity.turnOffShake();
        }
      }
    }
    else if ((paramIntent.getAction().equals("android.intent.action.SCREEN_ON")) && (QBaseActivity.getShakeListener() == null))
    {
      i = j;
      if (!SettingCloneUtil.readValue(paramContext, null, paramContext.getString(2131694975), "qqsetting_screenshot_key", false)) {
        i = 0;
      }
      if (i != 0) {
        localQBaseActivity.turnOnShake();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.lifecycle.BaseActivityInjectImpl.MyScreenReceiver
 * JD-Core Version:    0.7.0.1
 */