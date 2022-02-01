package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import axpf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;

class MainFragment$2
  implements Runnable
{
  MainFragment$2(MainFragment paramMainFragment) {}
  
  public void run()
  {
    boolean bool2 = true;
    if (this.this$0.getActivity() == null) {}
    do
    {
      return;
      MainFragment.a(this.this$0, PreferenceManager.getDefaultSharedPreferences(MainFragment.a(this.this$0).getApp()));
      boolean bool1 = bool2;
      if (MainFragment.a(this.this$0).getBoolean("theme_voice_setting_" + MainFragment.a(this.this$0).getCurrentAccountUin(), true))
      {
        Object localObject = ThemeUtil.getUserCurrentThemeId(MainFragment.a(this.this$0));
        localObject = ThemeUtil.getThemeInfo(this.this$0.getActivity(), (String)localObject);
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (((ThemeUtil.ThemeInfo)localObject).status.equals("5"))
          {
            bool1 = bool2;
            if (((ThemeUtil.ThemeInfo)localObject).isVoiceTheme) {
              bool1 = false;
            }
          }
        }
      }
      MainFragment.a(this.this$0, bool1, MainFragment.a);
      MainFragment.a(this.this$0, bool1, MainFragment.b);
      MainFragment.a(this.this$0, bool1, MainFragment.c);
      MainFragment.a(this.this$0, bool1, "NOW");
      MainFragment.a(this.this$0, bool1, MainFragment.d);
      MainFragment.a(this.this$0, bool1, "动态");
    } while (axpf.a().a());
    axpf.a().a(MainFragment.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MainFragment.2
 * JD-Core Version:    0.7.0.1
 */