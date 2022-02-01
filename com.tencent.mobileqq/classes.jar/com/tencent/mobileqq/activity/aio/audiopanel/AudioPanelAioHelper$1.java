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
      if (!this.this$0.b())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("volueme state err");
        ((StringBuilder)localObject).append(Build.MANUFACTURER);
        ((StringBuilder)localObject).append(Build.MODEL);
        QLog.i("AudioPanelAioHelper", 1, ((StringBuilder)localObject).toString());
        return;
      }
      if ((this.this$0.a == null) || (!this.this$0.a.isShowing()))
      {
        localObject = this.this$0;
        ((AudioPanelAioHelper)localObject).a = new ToastStyleDialog(AudioPanelAioHelper.a((AudioPanelAioHelper)localObject).a);
        this.this$0.a.a(AudioPanelAioHelper.a(this.this$0).a.getString(2131698589));
        this.this$0.a.show();
      }
    }
    else if (((i == 2) || (i == 0)) && (this.this$0.a != null) && (this.this$0.a.isShowing()) && (this.this$0.a.getWindow() != null))
    {
      this.this$0.a.dismiss();
      this.this$0.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAioHelper.1
 * JD-Core Version:    0.7.0.1
 */