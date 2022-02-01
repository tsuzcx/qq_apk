package com.tencent.avgame.videorecord;

import android.os.Handler;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.avgame.gameroom.video.AVGameVideoLayer;
import com.tencent.avgame.qav.AVGameCameraAssistant.CameraEventListener;
import com.tencent.qav.log.AVLog;

class ShowAndGuessGameVideoRecordCtrl$2
  implements AVGameCameraAssistant.CameraEventListener
{
  ShowAndGuessGameVideoRecordCtrl$2(ShowAndGuessGameVideoRecordCtrl paramShowAndGuessGameVideoRecordCtrl) {}
  
  public void a()
  {
    AVLog.c(this.a.a, "notifyCameraNoData ");
  }
  
  public void a(long paramLong)
  {
    AVLog.c(this.a.a, "onBeforeCloseCamera ");
    if (this.a.k()) {
      this.a.a(true);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    AVLog.c(this.a.a, "onBeforeOpenCamera ");
  }
  
  public void b(long paramLong) {}
  
  public void b(long paramLong, boolean paramBoolean)
  {
    AVLog.c(this.a.a, "onAfterOpenCamera ");
    ShowAndGuessGameVideoRecordCtrl.a(this.a, true);
    if (this.a.k()) {
      ShowAndGuessGameVideoRecordCtrl.a(this.a).sendEmptyMessageDelayed(6, 200L);
    }
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    AVLog.c(this.a.a, "onAfterCloseCamera ");
    ShowAndGuessGameVideoRecordCtrl.a(this.a, false);
    if ((this.a.k()) && (ShowAndGuessGameVideoRecordCtrl.b(this.a) != null) && (ShowAndGuessGameVideoRecordCtrl.b(this.a).i() != null))
    {
      ShowAndGuessGameVideoRecordCtrl.b(this.a).i().requestRender();
      ShowAndGuessGameVideoRecordCtrl.a(this.a).sendEmptyMessageDelayed(3, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.videorecord.ShowAndGuessGameVideoRecordCtrl.2
 * JD-Core Version:    0.7.0.1
 */