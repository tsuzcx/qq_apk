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
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController.i())
    {
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.onGAudioUserAudioSuspectNoisy(0L, false, 0L);
      if (QLog.isColorLevel()) {
        QLog.e(this.this$0.d, 2, "RefreshNoiseStateRunnable refreshUserNoiseState return true");
      }
    }
    Handler localHandler;
    Runnable localRunnable;
    if (this.this$0.e != null)
    {
      localHandler = this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      localRunnable = this.this$0.e;
      if (this.this$0.jdField_a_of_type_ComTencentAvVideoController.b >= 2000L) {
        break label105;
      }
    }
    label105:
    for (long l = 2000L;; l = this.this$0.jdField_a_of_type_ComTencentAvVideoController.b)
    {
      localHandler.postDelayed(localRunnable, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.RefreshNoiseStateRunnable
 * JD-Core Version:    0.7.0.1
 */