package com.tencent.av.screenshare;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class ScreenShareCtrl$ShareOpsTimeOutTask
  implements Runnable
{
  private final int jdField_a_of_type_Int;
  private final SessionInfo jdField_a_of_type_ComTencentAvAppSessionInfo;
  private final WeakReference<VideoController> jdField_a_of_type_MqqUtilWeakReference;
  private final int b;
  
  public ScreenShareCtrl$ShareOpsTimeOutTask(VideoController paramVideoController, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramVideoController);
    this.jdField_a_of_type_ComTencentAvAppSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void run()
  {
    int j = 1;
    VideoController localVideoController = (VideoController)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localVideoController != null) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo != null)) {
      if (this.jdField_a_of_type_Int != 1) {
        break label136;
      }
    }
    label136:
    for (int i = 86;; i = 89)
    {
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.j) {
        j = 2;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AVShare", 2, "ShareOpsTimeOutTask, actionResult[" + i + "], session[" + this.jdField_a_of_type_ComTencentAvAppSessionInfo + "], multiAVSubType[" + j + "]");
      }
      localVideoController.onShareOpsCallback(i, this.b, this.jdField_a_of_type_ComTencentAvAppSessionInfo.F, this.jdField_a_of_type_ComTencentAvAppSessionInfo.g, this.jdField_a_of_type_ComTencentAvAppSessionInfo.D, j);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareCtrl.ShareOpsTimeOutTask
 * JD-Core Version:    0.7.0.1
 */