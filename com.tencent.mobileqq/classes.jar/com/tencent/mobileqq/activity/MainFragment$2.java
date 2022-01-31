package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import arxu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import java.util.HashMap;

class MainFragment$2
  implements Runnable
{
  MainFragment$2(MainFragment paramMainFragment) {}
  
  public void run()
  {
    if (this.this$0.getActivity() == null) {
      return;
    }
    MainFragment.a(this.this$0, PreferenceManager.getDefaultSharedPreferences(MainFragment.a(this.this$0).getApp()));
    if (MainFragment.a(this.this$0).getBoolean("theme_voice_setting_" + MainFragment.a(this.this$0).getCurrentAccountUin(), true))
    {
      Object localObject = ThemeUtil.getUserCurrentThemeId(MainFragment.a(this.this$0));
      localObject = ThemeUtil.getThemeInfo(this.this$0.getActivity(), (String)localObject);
      if ((localObject == null) || (!((ThemeUtil.ThemeInfo)localObject).status.equals("5")) || (!((ThemeUtil.ThemeInfo)localObject).isVoiceTheme)) {}
    }
    for (boolean bool = false;; bool = true)
    {
      if (MainFragment.a(this.this$0) != null)
      {
        if (MainFragment.a(this.this$0).get(MainFragment.a) != null) {
          ((View)MainFragment.a(this.this$0).get(MainFragment.a)).setSoundEffectsEnabled(bool);
        }
        if (MainFragment.a(this.this$0).get(MainFragment.b) != null) {
          ((View)MainFragment.a(this.this$0).get(MainFragment.b)).setSoundEffectsEnabled(bool);
        }
        if (MainFragment.a(this.this$0).get(MainFragment.c) != null) {
          ((View)MainFragment.a(this.this$0).get(MainFragment.c)).setSoundEffectsEnabled(bool);
        }
        if (MainFragment.a(this.this$0).get("NOW") != null) {
          ((View)MainFragment.a(this.this$0).get("NOW")).setSoundEffectsEnabled(bool);
        }
        if (MainFragment.a(this.this$0).get(MainFragment.d) != null) {
          ((View)MainFragment.a(this.this$0).get(MainFragment.d)).setSoundEffectsEnabled(bool);
        }
        if (MainFragment.a(this.this$0).get("动态") != null) {
          ((View)MainFragment.a(this.this$0).get("动态")).setSoundEffectsEnabled(bool);
        }
      }
      if (arxu.a().a()) {
        break;
      }
      arxu.a().a(MainFragment.a(this.this$0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MainFragment.2
 * JD-Core Version:    0.7.0.1
 */