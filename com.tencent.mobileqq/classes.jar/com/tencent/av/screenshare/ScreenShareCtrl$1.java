package com.tencent.av.screenshare;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import lid;

class ScreenShareCtrl$1
  implements Runnable
{
  ScreenShareCtrl$1(ScreenShareCtrl paramScreenShareCtrl) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVShare", 2, "SetTimeOut_Double2Meeting timeOut ");
    }
    ScreenShareCtrl.a(this.this$0).b(ScreenShareCtrl.a(this.this$0).a().d, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareCtrl.1
 * JD-Core Version:    0.7.0.1
 */