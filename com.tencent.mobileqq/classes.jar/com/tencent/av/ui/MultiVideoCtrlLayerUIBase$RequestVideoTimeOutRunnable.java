package com.tencent.av.ui;

import azqs;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;

class MultiVideoCtrlLayerUIBase$RequestVideoTimeOutRunnable
  implements Runnable
{
  MultiVideoCtrlLayerUIBase$RequestVideoTimeOutRunnable(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      this.this$0.a.a("Multi_RequestVideoTimeOutRunnable");
      this.this$0.w();
      if (this.this$0.e == 2) {
        azqs.b(null, "CliOper", "", "", "0X8004425", "0X8004425", 0, 0, "", "", "", "");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e(this.this$0.d, 2, "RequestVideoTimeOutRunnable, mVideoController = null!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.RequestVideoTimeOutRunnable
 * JD-Core Version:    0.7.0.1
 */