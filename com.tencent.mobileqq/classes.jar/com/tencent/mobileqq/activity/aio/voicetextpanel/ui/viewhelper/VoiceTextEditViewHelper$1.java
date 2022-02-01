package com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.aio.voicetextpanel.listeners.VoiceTextUserOpListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextInfoState;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextStateModel;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextSttState;

class VoiceTextEditViewHelper$1
  implements TextWatcher
{
  VoiceTextEditViewHelper$1(VoiceTextEditViewHelper paramVoiceTextEditViewHelper) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.a.c.c().f())
    {
      paramEditable = paramEditable.toString();
      this.a.c.d().a(paramEditable);
      if (this.a.d != null) {
        this.a.d.a(paramEditable);
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextEditViewHelper.1
 * JD-Core Version:    0.7.0.1
 */