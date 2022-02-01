package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import lez;

public class DoubleVideoCtrlUI$1
  implements Runnable
{
  DoubleVideoCtrlUI$1(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    lez locallez = this.this$0.a.a();
    QLog.w(this.this$0.jdField_d_of_type_JavaLangString, 1, "CheckRemoteCameraRunnable, 5s has past, 对方视频数据没来, mRecvVideoData[" + this.this$0.e + "], SessionType[" + locallez.jdField_d_of_type_Int + "], shutCameraAnswer[" + locallez.n + "], cameraPermission[" + locallez.o + "]");
    if ((!this.this$0.e) && (locallez.jdField_d_of_type_Int == 2))
    {
      this.this$0.a.e(locallez.jdField_d_of_type_JavaLangString);
      if ((locallez.n) || (!locallez.o))
      {
        locallez.a(-1011L, "CheckRemoteCameraRunnable", 1);
        this.this$0.a("CheckRemoteCameraRunnable", 1);
      }
      this.this$0.C(-1011L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.1
 * JD-Core Version:    0.7.0.1
 */