package com.tencent.av.ui.funchat.record;

import android.os.HandlerThread;
import android.os.Looper;
import avyz;
import bfni;
import com.tencent.qphone.base.util.QLog;
import mnv;

public class QavVideoAudioRecorder$1
  implements Runnable
{
  public QavVideoAudioRecorder$1(mnv parammnv, avyz paramavyz, HandlerThread paramHandlerThread) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Avyz != null) {
      this.jdField_a_of_type_Avyz.a();
    }
    try
    {
      if (bfni.i())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.QavVideoAudioRecorder.1
 * JD-Core Version:    0.7.0.1
 */