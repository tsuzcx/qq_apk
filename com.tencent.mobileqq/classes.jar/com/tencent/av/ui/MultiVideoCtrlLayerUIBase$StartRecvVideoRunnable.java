package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;

class MultiVideoCtrlLayerUIBase$StartRecvVideoRunnable
  implements Runnable
{
  public String a = null;
  
  MultiVideoCtrlLayerUIBase$StartRecvVideoRunnable(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      String str = this.this$0.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StartRecvAllVideoRunnable-->FunctionName=");
      localStringBuilder.append(this.a);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.this$0.K();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.StartRecvVideoRunnable
 * JD-Core Version:    0.7.0.1
 */