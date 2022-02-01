package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.os.Build;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.widget.ToastStyleDialog;
import com.tencent.qphone.base.util.QLog;

class AudioPanelAioHelper$1
  implements Runnable
{
  AudioPanelAioHelper$1(AudioPanelAioHelper paramAudioPanelAioHelper, int paramInt) {}
  
  public void run()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("recorderVolumeChange ");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("AudioPanelAioHelper", 2, ((StringBuilder)localObject).toString());
    }
    int i = this.a;
    if (i == 1)
    {
      if (!this.this$0.g())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("volueme state err");
        ((StringBuilder)localObject).append(Build.MANUFACTURER);
        ((StringBuilder)localObject).append(Build.MODEL);
        QLog.i("AudioPanelAioHelper", 1, ((StringBuilder)localObject).toString());
        return;
      }
      if ((this.this$0.g == null) || (!this.this$0.g.isShowing()))
      {
        localObject = this.this$0;
        ((AudioPanelAioHelper)localObject).g = new ToastStyleDialog(AudioPanelAioHelper.a((AudioPanelAioHelper)localObject).e);
        this.this$0.g.a(AudioPanelAioHelper.a(this.this$0).e.getString(2131896536));
        this.this$0.g.show();
      }
    }
    else if (((i == 2) || (i == 0)) && (this.this$0.g != null) && (this.this$0.g.isShowing()) && (this.this$0.g.getWindow() != null))
    {
      this.this$0.g.dismiss();
      this.this$0.g = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAioHelper.1
 * JD-Core Version:    0.7.0.1
 */