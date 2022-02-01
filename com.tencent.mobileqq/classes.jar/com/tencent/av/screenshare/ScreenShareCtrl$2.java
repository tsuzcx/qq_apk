package com.tencent.av.screenshare;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class ScreenShareCtrl$2
  implements Runnable
{
  ScreenShareCtrl$2(ScreenShareCtrl paramScreenShareCtrl) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVShare", 2, "SetTimeOut_Double2Meeting timeOut ");
    }
    long l = AudioHelper.b();
    String str = ScreenShareCtrl.a(this.this$0).a().d;
    ScreenShareCtrl.a(this.this$0).a.a(new Object[] { Integer.valueOf(14), Integer.valueOf(2), str, Long.valueOf(l) });
    ScreenShareCtrl.a(this.this$0).a.a(new Object[] { Integer.valueOf(106), Long.valueOf(l) });
    ScreenShareCtrl.a(this.this$0).a(str, 202);
    ScreenShareCtrl.a(this.this$0).b(str, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareCtrl.2
 * JD-Core Version:    0.7.0.1
 */