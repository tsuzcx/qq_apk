package com.tencent.mobileqq.activity.aio.audiopanel;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class RecordSoundPanel$1
  extends Handler
{
  RecordSoundPanel$1(RecordSoundPanel paramRecordSoundPanel, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    ((AudioPanelAioHelper)this.a.a.q(128)).g(1);
    this.a.a();
    QQToast.makeText(this.a.a.aX(), this.a.a.aX().getString(2131896535), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.RecordSoundPanel.1
 * JD-Core Version:    0.7.0.1
 */