package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bahj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.BaseApplication;

public class UpdateIcon
  extends AsyncStep
{
  public int a()
  {
    if (!BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).getBoolean("enableUpdateIconStep", false)) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return 7;
      localSharedPreferences = this.a.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
    } while (!localSharedPreferences.getBoolean("updateShortcutIcon8.2.6.4370", true));
    bahj.a(this.a.app, "sid");
    localSharedPreferences.edit().putBoolean("updateShortcutIcon8.2.6.4370", false).commit();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateIcon
 * JD-Core Version:    0.7.0.1
 */