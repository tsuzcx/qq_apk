package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import lga;

public class DoubleVideoCtrlUI$1
  implements Runnable
{
  DoubleVideoCtrlUI$1(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    lga locallga = this.this$0.a.a();
    QLog.w(this.this$0.c, 1, "CheckRemoteCameraRunnable, 5s has past, 对方视频数据没来, mRecvVideoData[" + this.this$0.e + "], SessionType[" + locallga.jdField_d_of_type_Int + "], shutCameraAnswer[" + locallga.m + "], cameraPermission[" + locallga.n + "]");
    if ((!this.this$0.e) && (locallga.jdField_d_of_type_Int == 2))
    {
      this.this$0.a.e(locallga.jdField_d_of_type_JavaLangString);
      if ((locallga.m) || (!locallga.n))
      {
        locallga.a(-1011L, "CheckRemoteCameraRunnable", 1);
        this.this$0.a("CheckRemoteCameraRunnable", 1);
      }
      this.this$0.z(-1011L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.1
 * JD-Core Version:    0.7.0.1
 */