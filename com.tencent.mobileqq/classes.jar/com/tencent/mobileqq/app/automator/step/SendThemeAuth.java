package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThemeHandler;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.app.MobileQQ;

public class SendThemeAuth
  extends AsyncStep
{
  protected int a()
  {
    ThemeHandler localThemeHandler = (ThemeHandler)this.a.b.a(14);
    if (localThemeHandler != null) {
      localThemeHandler.a(null, null);
    }
    Object localObject = this.a.b.getAccount();
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      return 7;
      localObject = this.a.b.getApplication().getSharedPreferences((String)localObject, 0);
    } while ((localThemeHandler == null) || (!((SharedPreferences)localObject).getBoolean("need_check_theme_ver", false)));
    localThemeHandler.a(null, null, false);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.SendThemeAuth
 * JD-Core Version:    0.7.0.1
 */