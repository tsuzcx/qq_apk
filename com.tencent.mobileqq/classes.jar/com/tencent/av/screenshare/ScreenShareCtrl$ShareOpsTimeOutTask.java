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
    VideoController localVideoController = (VideoController)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localVideoController != null) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo != null))
    {
      int i;
      if (this.jdField_a_of_type_Int == 1) {
        i = 86;
      } else {
        i = 89;
      }
      int j;
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_j_of_type_Boolean) {
        j = 2;
      } else {
        j = 1;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ShareOpsTimeOutTask, actionResult[");
        localStringBuilder.append(i);
        localStringBuilder.append("], session[");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentAvAppSessionInfo);
        localStringBuilder.append("], multiAVSubType[");
        localStringBuilder.append(j);
        localStringBuilder.append("]");
        QLog.i("AVShare", 2, localStringBuilder.toString());
      }
      localVideoController.onShareOpsCallback(i, this.b, this.jdField_a_of_type_ComTencentAvAppSessionInfo.E, this.jdField_a_of_type_ComTencentAvAppSessionInfo.f, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_j_of_type_Int, j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareCtrl.ShareOpsTimeOutTask
 * JD-Core Version:    0.7.0.1
 */