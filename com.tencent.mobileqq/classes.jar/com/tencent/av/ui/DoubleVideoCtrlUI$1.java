package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import kvq;

public class DoubleVideoCtrlUI$1
  implements Runnable
{
  DoubleVideoCtrlUI$1(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    kvq localkvq = this.this$0.a.a();
    QLog.w(this.this$0.c, 1, "CheckRemoteCameraRunnable, 5s has past, 对方视频数据没来, mRecvVideoData[" + this.this$0.e + "], SessionType[" + localkvq.jdField_d_of_type_Int + "], shutCameraAnswer[" + localkvq.m + "], cameraPermission[" + localkvq.n + "]");
    if ((!this.this$0.e) && (localkvq.jdField_d_of_type_Int == 2))
    {
      this.this$0.a.f(localkvq.jdField_d_of_type_JavaLangString);
      if ((localkvq.m) || (!localkvq.n))
      {
        localkvq.a(-1011L, "CheckRemoteCameraRunnable", 1);
        this.this$0.a("CheckRemoteCameraRunnable", 1);
      }
      this.this$0.y(-1011L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.1
 * JD-Core Version:    0.7.0.1
 */