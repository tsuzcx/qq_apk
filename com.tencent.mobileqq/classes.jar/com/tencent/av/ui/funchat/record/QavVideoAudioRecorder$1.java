package com.tencent.av.ui.funchat.record;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeInputSurface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;

class QavVideoAudioRecorder$1
  implements Runnable
{
  QavVideoAudioRecorder$1(QavVideoAudioRecorder paramQavVideoAudioRecorder, EncodeInputSurface paramEncodeInputSurface, HandlerThread paramHandlerThread) {}
  
  public void run()
  {
    EncodeInputSurface localEncodeInputSurface = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeInputSurface;
    if (localEncodeInputSurface != null) {
      localEncodeInputSurface.a();
    }
    try
    {
      if (VersionUtils.h())
      {
        this.jdField_a_of_type_AndroidOsHandlerThread.getLooper().quitSafely();
        QLog.i("QavVideoAudioRecorder", 1, "onDestroy quitSafely");
        return;
      }
      this.jdField_a_of_type_AndroidOsHandlerThread.getLooper().quit();
      QLog.i("QavVideoAudioRecorder", 1, "onDestroy quit");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QavVideoAudioRecorder", 1, "onDestroy Exception", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.QavVideoAudioRecorder.1
 * JD-Core Version:    0.7.0.1
 */