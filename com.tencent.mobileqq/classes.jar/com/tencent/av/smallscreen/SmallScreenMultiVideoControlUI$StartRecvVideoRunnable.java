package com.tencent.av.smallscreen;

import com.tencent.qphone.base.util.QLog;

class SmallScreenMultiVideoControlUI$StartRecvVideoRunnable
  implements Runnable
{
  public String a;
  
  SmallScreenMultiVideoControlUI$StartRecvVideoRunnable(SmallScreenMultiVideoControlUI paramSmallScreenMultiVideoControlUI) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "StartRecvAllVideoRunnable-->FunctionName=" + this.a);
    }
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI.StartRecvVideoRunnable
 * JD-Core Version:    0.7.0.1
 */