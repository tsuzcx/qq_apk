package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.studymode.KidModeObserver;
import com.tencent.mobileqq.studymode.KidModeVerifyFragment;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;

class GeneralSettingActivity$1
  extends KidModeObserver
{
  GeneralSettingActivity$1(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (!this.a.isResume())
    {
      if (QLog.isColorLevel()) {
        QLog.d("KidModeObserver", 1, "onSmsCodeSuccess but setting Activity is not resume");
      }
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("FIRST_TIME_RES", paramBundle.getInt("REQ_RESULT"));
    if (QLog.isColorLevel()) {
      QLog.d("KidModeObserver", 2, "KidMode onRecvVerifyCode");
    }
    localIntent.putExtra("COUNT_TIME", paramBundle.getInt("RESENT_INTERVAL_TIMEOUT", 0));
    paramBundle = paramBundle.getBundle("extensionField");
    if ((paramBundle != null) && (paramBundle.getInt("target") == 1))
    {
      localIntent.putExtra("target", 1);
      localIntent.putExtra("RESULT_CODE", 2);
      int i = paramBundle.getInt("ExtraTargetMode");
      localIntent.putExtra("ExtraTargetMode", i);
      if (QLog.isColorLevel()) {
        QLog.d("KidModeObserver", 2, new Object[] { "onSendSmsCodeSuccess targetMode:", Integer.valueOf(i) });
      }
    }
    KidModeVerifyFragment.a(this.a, localIntent);
  }
  
  public void b(boolean paramBoolean, Bundle paramBundle)
  {
    if (!this.a.isResume()) {
      if (QLog.isColorLevel()) {
        QLog.d("KidModeObserver", 1, "onSendGetKidModeStatusSuccess but setting Activity is not resume");
      }
    }
    while (!paramBoolean) {
      return;
    }
    StudyModeManager.a(paramBundle.getInt("KID_MODE_NEED_VERIFY"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity.1
 * JD-Core Version:    0.7.0.1
 */