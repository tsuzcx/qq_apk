package com.tencent.aelight.camera.aebase;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.qphone.base.util.QLog;

class PeakService$2
  implements Runnable
{
  PeakService$2(PeakService paramPeakService) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PeakService", 2, "peak service start MediaScanner.doScan()");
    }
    MediaScanner.getInstance(BaseApplicationImpl.getContext()).doScan();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.PeakService.2
 * JD-Core Version:    0.7.0.1
 */