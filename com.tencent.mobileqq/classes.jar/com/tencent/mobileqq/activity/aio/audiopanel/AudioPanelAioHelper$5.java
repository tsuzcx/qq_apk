package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XEditTextEx;

class AudioPanelAioHelper$5
  implements Runnable
{
  AudioPanelAioHelper$5(AudioPanelAioHelper paramAudioPanelAioHelper, boolean paramBoolean) {}
  
  public void run()
  {
    AudioPanelAioHelper.a(this.this$0).d(true);
    AudioPanelAioHelper.a(this.this$0).be();
    ((AudioPanelAioHelper)AudioPanelAioHelper.a(this.this$0).q(128)).h(0);
    AudioPanelAioHelper.a(this.this$0).Y.setEnabled(true);
    if (this.a)
    {
      ((AudioPanelAioHelper)AudioPanelAioHelper.a(this.this$0).q(128)).j();
      return;
    }
    QQToast.makeText(AudioPanelAioHelper.b(this.this$0).getApp(), 2131886619, 1).show(AudioPanelAioHelper.a(this.this$0).e.getResources().getDimensionPixelSize(2131299920));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAioHelper.5
 * JD-Core Version:    0.7.0.1
 */