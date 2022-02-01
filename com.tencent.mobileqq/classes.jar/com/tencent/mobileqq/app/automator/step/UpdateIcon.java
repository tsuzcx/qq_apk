package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class UpdateIcon
  extends AsyncStep
{
  protected int doStep()
  {
    if (!BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).getBoolean("enableUpdateIconStep", false)) {
      return 7;
    }
    SharedPreferences localSharedPreferences = this.mAutomator.a.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
    if (localSharedPreferences.getBoolean("updateShortcutIcon8.7.0.5295", true))
    {
      QQUtils.a(this.mAutomator.a, "sid");
      localSharedPreferences.edit().putBoolean("updateShortcutIcon8.7.0.5295", false).commit();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateIcon
 * JD-Core Version:    0.7.0.1
 */