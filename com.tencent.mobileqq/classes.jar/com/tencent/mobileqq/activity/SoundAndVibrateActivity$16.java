package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.utils.VipUtils;

class SoundAndVibrateActivity$16
  extends ClickableSpan
{
  SoundAndVibrateActivity$16(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onClick(View paramView)
  {
    SoundAndVibrateActivity.a(this.a);
    VipUtils.a(this.a.app, "Vip_SpecialCare", "0X80049EE", "0X80049EE", 0, 1, null);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(this.a.getResources().getColor(2131167041));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SoundAndVibrateActivity.16
 * JD-Core Version:    0.7.0.1
 */