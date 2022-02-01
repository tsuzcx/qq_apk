package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;

class DoubleVideoCtrlUI$5
  implements Runnable
{
  DoubleVideoCtrlUI$5(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    SessionInfo localSessionInfo = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.this$0.jdField_d_of_type_JavaLangString, 1, "CheckRemoteCameraRunnable, 5s has past, 对方视频数据没来, mRecvVideoData[" + this.this$0.jdField_a_of_type_Boolean + "], SessionType[" + localSessionInfo.jdField_d_of_type_Int + "], shutCameraAnswer[" + localSessionInfo.n + "], cameraPermission[" + localSessionInfo.o + "]");
    if ((!this.this$0.jdField_a_of_type_Boolean) && (localSessionInfo.jdField_d_of_type_Int == 2))
    {
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.onPauseVideo(localSessionInfo.jdField_d_of_type_JavaLangString);
      if ((localSessionInfo.n) || (!localSessionInfo.o))
      {
        localSessionInfo.a(-1011L, "CheckRemoteCameraRunnable", 1);
        this.this$0.a("CheckRemoteCameraRunnable", 1);
      }
      this.this$0.D(-1011L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.5
 * JD-Core Version:    0.7.0.1
 */