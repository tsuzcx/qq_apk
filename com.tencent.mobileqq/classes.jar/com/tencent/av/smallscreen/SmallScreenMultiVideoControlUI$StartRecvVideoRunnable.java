package com.tencent.av.smallscreen;

import com.tencent.qphone.base.util.QLog;

class SmallScreenMultiVideoControlUI$StartRecvVideoRunnable
  implements Runnable
{
  public String a = null;
  
  SmallScreenMultiVideoControlUI$StartRecvVideoRunnable(SmallScreenMultiVideoControlUI paramSmallScreenMultiVideoControlUI) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StartRecvAllVideoRunnable-->FunctionName=");
      localStringBuilder.append(this.a);
      QLog.d("SmallScreenMultiVideoControlUI", 2, localStringBuilder.toString());
    }
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI.StartRecvVideoRunnable
 * JD-Core Version:    0.7.0.1
 */