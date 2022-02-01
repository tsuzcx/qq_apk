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
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.a.i(1);
    this.a.a();
    QQToast.a(this.a.a.a(), this.a.a.a().getString(2131698522), 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.RecordSoundPanel.1
 * JD-Core Version:    0.7.0.1
 */