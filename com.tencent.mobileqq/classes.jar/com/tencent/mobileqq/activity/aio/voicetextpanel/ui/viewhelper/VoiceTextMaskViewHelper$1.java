package com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.listeners.VoiceTextUserOpListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;

class VoiceTextMaskViewHelper$1
  implements View.OnTouchListener
{
  VoiceTextMaskViewHelper$1(VoiceTextMaskViewHelper paramVoiceTextMaskViewHelper) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (VoiceTextMaskViewHelper.a(this.a).a() != null) {
      VoiceTextMaskViewHelper.a(this.a).a().a(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextMaskViewHelper.1
 * JD-Core Version:    0.7.0.1
 */