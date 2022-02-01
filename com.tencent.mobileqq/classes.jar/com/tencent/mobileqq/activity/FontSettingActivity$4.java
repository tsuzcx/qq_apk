package com.tencent.mobileqq.activity;

import android.os.Message;
import com.tencent.mobileqq.app.FontSettingManager;
import mqq.os.MqqHandler;

class FontSettingActivity$4
  extends MqqHandler
{
  FontSettingActivity$4(FontSettingActivity paramFontSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (16711697 == paramMessage.what)
    {
      FontSettingManager.setCustomDensity(this.a, FontSettingActivity.a(this.a), false);
      this.a.c = true;
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FontSettingActivity.4
 * JD-Core Version:    0.7.0.1
 */