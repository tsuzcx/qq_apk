package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import axqw;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;

class MainFragment$6
  implements Runnable
{
  MainFragment$6(MainFragment paramMainFragment, int paramInt) {}
  
  public void run()
  {
    String str2 = MainFragment.a(this.this$0);
    if ((MainFragment.a.equals(str2)) || (MainFragment.b.equals(str2))) {
      if (!MainFragment.a.equals(str2)) {
        break label193;
      }
    }
    label193:
    for (String str1 = "Msg_tab";; str1 = "Contacts_tab")
    {
      axqw.b(MainFragment.a(this.this$0), "CliOper", "", "", str1, str1, 0, 0, "", "", "", "");
      if ((MainFragment.a(this.this$0) != null) && (MainFragment.a(this.this$0).getBoolean("theme_voice_setting_" + MainFragment.a(this.this$0).getCurrentAccountUin(), true))) {
        MainFragment.a(this.this$0).b(this.a + 1);
      }
      if ((str2 != null) && (AppSetting.d))
      {
        MainFragment.a(this.this$0, MainFragment.a, str2);
        MainFragment.a(this.this$0, MainFragment.b, str2);
        MainFragment.a(this.this$0, MainFragment.c, str2);
        MainFragment.a(this.this$0, "NOW", str2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MainFragment.6
 * JD-Core Version:    0.7.0.1
 */