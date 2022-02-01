package com.tencent.mobileqq.activity;

import android.os.Bundle;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

class GeneralSettingActivity$21
  extends SecSvcObserver
{
  GeneralSettingActivity$21(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SecSvcObserver", 2, "onGetPhoneUnityInfo isSuc: " + paramBoolean);
    }
    String str;
    if ((this.a.isResume()) && (paramBundle != null))
    {
      str = paramBundle.getString("phone");
      paramBundle = paramBundle.getString("mibao_set_url");
      if (!StringUtil.a(str)) {
        break label78;
      }
    }
    label78:
    for (int i = 1;; i = 0)
    {
      StudyModeManager.a(i, str, paramBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity.21
 * JD-Core Version:    0.7.0.1
 */