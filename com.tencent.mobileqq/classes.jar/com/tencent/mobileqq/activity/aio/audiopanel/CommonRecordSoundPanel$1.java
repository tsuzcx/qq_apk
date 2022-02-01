package com.tencent.mobileqq.activity.aio.audiopanel;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class CommonRecordSoundPanel$1
  extends Handler
{
  CommonRecordSoundPanel$1(CommonRecordSoundPanel paramCommonRecordSoundPanel, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 16711687: 
      this.a.a(102);
      return;
    case 16711686: 
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "QQRecorder stop() is called,time is:" + System.currentTimeMillis());
      }
      CommonRecordSoundPanel.a(this.a).c();
      AudioUtil.b(2131230744, false);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(16711686);
      QQAudioUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, false);
      return;
    }
    this.a.a(1);
    this.a.a();
    QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698522), 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel.1
 * JD-Core Version:    0.7.0.1
 */