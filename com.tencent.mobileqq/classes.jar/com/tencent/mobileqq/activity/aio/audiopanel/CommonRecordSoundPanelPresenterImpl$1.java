package com.tencent.mobileqq.activity.aio.audiopanel;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.ptt.IQQRecorder;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;

class CommonRecordSoundPanelPresenterImpl$1
  extends Handler
{
  CommonRecordSoundPanelPresenterImpl$1(CommonRecordSoundPanelPresenterImpl paramCommonRecordSoundPanelPresenterImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ICommonRecordSoundPanelView localICommonRecordSoundPanelView = this.a.a();
    int i = paramMessage.what;
    if (i != 1)
    {
      switch (i)
      {
      default: 
        return;
      case 16711687: 
        this.a.a(102);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("QQRecorder stop() is called,time is:");
        paramMessage.append(System.currentTimeMillis());
        QLog.d("QQRecorder", 2, paramMessage.toString());
      }
      this.a.d.c();
      AudioUtil.b(2131230816, false);
      if (localICommonRecordSoundPanelView != null)
      {
        localICommonRecordSoundPanelView.getCallBack().sendEmptyMessage(16711686);
        QQAudioUtils.a(localICommonRecordSoundPanelView.getViewContext(), false);
      }
    }
    else
    {
      this.a.a(1);
      if (localICommonRecordSoundPanelView != null)
      {
        localICommonRecordSoundPanelView.e();
        QQToast.makeText(localICommonRecordSoundPanelView.getViewContext(), localICommonRecordSoundPanelView.getViewContext().getString(2131896535), 1).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanelPresenterImpl.1
 * JD-Core Version:    0.7.0.1
 */