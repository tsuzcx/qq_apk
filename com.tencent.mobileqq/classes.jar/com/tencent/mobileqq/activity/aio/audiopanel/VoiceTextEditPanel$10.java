package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.Resources;
import android.widget.EditText;
import anni;
import com.tencent.mobileqq.widget.QQToast;
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
    QQToast.a(this.this$0.getContext(), anni.a(2131715526), 0).b(this.this$0.getContext().getResources().getDimensionPixelSize(2131298998));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel.10
 * JD-Core Version:    0.7.0.1
 */