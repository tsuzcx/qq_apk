package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import lfe;

class DoubleVideoCtrlUI$5
  implements Runnable
{
  DoubleVideoCtrlUI$5(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    lfe locallfe = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.this$0.jdField_d_of_type_JavaLangString, 1, "CheckRemoteCameraRunnable, 5s has past, 对方视频数据没来, mRecvVideoData[" + this.this$0.jdField_a_of_type_Boolean + "], SessionType[" + locallfe.jdField_d_of_type_Int + "], shutCameraAnswer[" + locallfe.n + "], cameraPermission[" + locallfe.o + "]");
    if ((!this.this$0.jdField_a_of_type_Boolean) && (locallfe.jdField_d_of_type_Int == 2))
    {
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.e(locallfe.jdField_d_of_type_JavaLangString);
      if ((locallfe.n) || (!locallfe.o))
      {
        locallfe.a(-1011L, "CheckRemoteCameraRunnable", 1);
        this.this$0.a("CheckRemoteCameraRunnable", 1);
      }
      this.this$0.D(-1011L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.5
 * JD-Core Version:    0.7.0.1
 */