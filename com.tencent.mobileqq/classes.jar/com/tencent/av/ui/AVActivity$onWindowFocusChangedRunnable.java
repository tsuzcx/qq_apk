package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;

class AVActivity$onWindowFocusChangedRunnable
  implements Runnable
{
  AVActivity$onWindowFocusChangedRunnable(AVActivity paramAVActivity) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(this.this$0.b, 4, "onWindowFocusChangedRunnable, nfonWindowFocus[" + this.this$0.j + "->true]");
    }
    this.this$0.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.onWindowFocusChangedRunnable
 * JD-Core Version:    0.7.0.1
 */