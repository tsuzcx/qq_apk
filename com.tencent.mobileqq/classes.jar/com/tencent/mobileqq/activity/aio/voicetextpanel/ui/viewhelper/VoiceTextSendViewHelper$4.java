package com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.CheckBox;

class VoiceTextSendViewHelper$4
  implements Runnable
{
  VoiceTextSendViewHelper$4(VoiceTextSendViewHelper paramVoiceTextSendViewHelper, int paramInt, View paramView) {}
  
  public void run()
  {
    Rect localRect = new Rect();
    VoiceTextSendViewHelper.d(this.this$0).getHitRect(localRect);
    localRect.top -= this.a;
    localRect.bottom += this.a;
    localRect.left -= this.a * 2;
    localRect.right += this.a;
    this.b.setTouchDelegate(new TouchDelegate(localRect, VoiceTextSendViewHelper.d(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextSendViewHelper.4
 * JD-Core Version:    0.7.0.1
 */