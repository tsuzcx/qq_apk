package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class MultiVideoCtrlLayerUIBase$RefreshNoiseStateRunnable
  implements Runnable
{
  MultiVideoCtrlLayerUIBase$RefreshNoiseStateRunnable(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void run()
  {
    if (this.this$0.am.L())
    {
      this.this$0.am.onGAudioUserAudioSuspectNoisy(0L, false, 0L);
      if (QLog.isColorLevel()) {
        QLog.e(this.this$0.X, 2, "RefreshNoiseStateRunnable refreshUserNoiseState return true");
      }
    }
    if (this.this$0.z != null)
    {
      Handler localHandler = this.this$0.al.a();
      Runnable localRunnable = this.this$0.z;
      long l2 = this.this$0.am.u;
      long l1 = 2000L;
      if (l2 >= 2000L) {
        l1 = this.this$0.am.u;
      }
      localHandler.postDelayed(localRunnable, l1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.RefreshNoiseStateRunnable
 * JD-Core Version:    0.7.0.1
 */