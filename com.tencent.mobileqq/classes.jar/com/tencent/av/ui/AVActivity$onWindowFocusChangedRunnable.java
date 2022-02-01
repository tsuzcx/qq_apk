package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;

class AVActivity$onWindowFocusChangedRunnable
  implements Runnable
{
  AVActivity$onWindowFocusChangedRunnable(AVActivity paramAVActivity) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel())
    {
      String str = this.this$0.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onWindowFocusChangedRunnable, nfonWindowFocus[");
      localStringBuilder.append(this.this$0.an);
      localStringBuilder.append("->true]");
      QLog.d(str, 4, localStringBuilder.toString());
    }
    this.this$0.an = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.onWindowFocusChangedRunnable
 * JD-Core Version:    0.7.0.1
 */