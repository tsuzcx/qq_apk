package com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.listeners.VoiceTextUserOpListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.utils.ReportUtils;

class VoiceTextEditViewHelper$2
  implements TextView.OnEditorActionListener
{
  VoiceTextEditViewHelper$2(VoiceTextEditViewHelper paramVoiceTextEditViewHelper) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 4)
    {
      if (this.a.a != null) {
        this.a.a.a();
      }
      ReportUtils.a("0X800A89F", 0, 0);
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextEditViewHelper.2
 * JD-Core Version:    0.7.0.1
 */