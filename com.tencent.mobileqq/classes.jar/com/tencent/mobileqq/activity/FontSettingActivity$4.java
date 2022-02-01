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
      paramMessage = this.a;
      FontSettingManager.setCustomDensity(paramMessage, FontSettingActivity.a(paramMessage), false);
      paramMessage = this.a;
      paramMessage.c = true;
      paramMessage.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FontSettingActivity.4
 * JD-Core Version:    0.7.0.1
 */