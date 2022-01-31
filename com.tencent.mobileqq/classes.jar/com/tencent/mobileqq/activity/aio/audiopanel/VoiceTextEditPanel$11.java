package com.tencent.mobileqq.activity.aio.audiopanel;

import acrv;
import ajjy;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.widget.CheckBox;
import android.widget.EditText;
import baip;
import bbmy;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

class VoiceTextEditPanel$11
  implements Runnable
{
  VoiceTextEditPanel$11(VoiceTextEditPanel paramVoiceTextEditPanel) {}
  
  public void run()
  {
    if (VoiceTextEditPanel.a(this.this$0).get() == 1)
    {
      localSpannableString = VoiceTextEditPanel.a(this.this$0).a();
      VoiceTextEditPanel.a(this.this$0).setText(localSpannableString);
    }
    do
    {
      return;
      if (VoiceTextEditPanel.a(this.this$0).get() == 3)
      {
        localSpannableString = VoiceTextEditPanel.a(this.this$0).a(VoiceTextEditPanel.a(this.this$0));
        VoiceTextEditPanel.a(this.this$0).setText(localSpannableString);
        VoiceTextEditPanel.a(this.this$0).setSelection(VoiceTextEditPanel.a(this.this$0).a(), VoiceTextEditPanel.a(this.this$0).a());
        return;
      }
    } while (VoiceTextEditPanel.a(this.this$0).get() != 4);
    if (baip.a(VoiceTextEditPanel.a(this.this$0)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEditPanel", 2, "no word state= " + VoiceTextEditPanel.a(this.this$0).get());
      }
      VoiceTextEditPanel.a(this.this$0).setText("");
      VoiceTextEditPanel.a(this.this$0).set(5);
      VoiceTextEditPanel.a(this.this$0).setFocusableInTouchMode(true);
      VoiceTextEditPanel.a(this.this$0).b();
      if (!VoiceTextEditPanel.a(this.this$0).isChecked()) {
        this.this$0.setSendEnable(false);
      }
      for (;;)
      {
        bbmy.a(this.this$0.getContext(), ajjy.a(2131651058), 0).b(this.this$0.getContext().getResources().getDimensionPixelSize(2131167766));
        return;
        this.this$0.setSendEnable(true);
      }
    }
    if (VoiceTextEditPanel.a(this.this$0).a(VoiceTextEditPanel.a(this.this$0)))
    {
      if (ThemeUtil.isNowThemeIsNight(VoiceTextEditPanel.a(this.this$0), false, null)) {
        VoiceTextEditPanel.a(this.this$0).setTextColor(Color.parseColor("#777777"));
      }
      for (;;)
      {
        VoiceTextEditPanel.a(this.this$0).setText(VoiceTextEditPanel.a(this.this$0));
        VoiceTextEditPanel.a(this.this$0).b();
        VoiceTextEditPanel.a(this.this$0).setFocusableInTouchMode(true);
        VoiceTextEditPanel.a(this.this$0).set(5);
        VoiceTextEditPanel.a(this.this$0).setSelection(VoiceTextEditPanel.a(this.this$0).length(), VoiceTextEditPanel.a(this.this$0).length());
        return;
        VoiceTextEditPanel.a(this.this$0).setTextColor(Color.parseColor("#03081a"));
      }
    }
    SpannableString localSpannableString = VoiceTextEditPanel.a(this.this$0).a(VoiceTextEditPanel.a(this.this$0));
    VoiceTextEditPanel.a(this.this$0).setText(localSpannableString);
    VoiceTextEditPanel.a(this.this$0).setSelection(VoiceTextEditPanel.a(this.this$0).a(), VoiceTextEditPanel.a(this.this$0).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel.11
 * JD-Core Version:    0.7.0.1
 */