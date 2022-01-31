package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;

class MultiVideoCtrlLayerUIBase$StartRecvVideoRunnable
  implements Runnable
{
  public String a;
  
  MultiVideoCtrlLayerUIBase$StartRecvVideoRunnable(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.d, 2, "StartRecvAllVideoRunnable-->FunctionName=" + this.a);
    }
    this.this$0.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.StartRecvVideoRunnable
 * JD-Core Version:    0.7.0.1
 */