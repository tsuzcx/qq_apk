package com.tencent.mobileqq.activity.aio.audiopanel;

import ajjy;
import android.content.Context;
import android.content.res.Resources;
import android.widget.EditText;
import bbmy;
import java.util.concurrent.atomic.AtomicInteger;

class VoiceTextEditPanel$10
  implements Runnable
{
  VoiceTextEditPanel$10(VoiceTextEditPanel paramVoiceTextEditPanel) {}
  
  public void run()
  {
    VoiceTextEditPanel.a(this.this$0).setText("");
    VoiceTextEditPanel.a(this.this$0).setFocusableInTouchMode(true);
    VoiceTextEditPanel.a(this.this$0).set(5);
    bbmy.a(this.this$0.getContext(), ajjy.a(2131651063), 0).b(this.this$0.getContext().getResources().getDimensionPixelSize(2131167766));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel.10
 * JD-Core Version:    0.7.0.1
 */