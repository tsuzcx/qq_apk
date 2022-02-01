package com.tencent.avgame.floatwindow;

import com.tencent.qphone.base.util.QLog;

class FloatWindowController$1
  implements Runnable
{
  FloatWindowController$1(FloatWindowController paramFloatWindowController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatWindowController", 2, "mDelayCheckPermissionShowFloatRunnable callback");
    }
    if (FloatWindowController.a(this.this$0))
    {
      FloatWindowController localFloatWindowController = this.this$0;
      localFloatWindowController.a(null, false, localFloatWindowController.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.floatwindow.FloatWindowController.1
 * JD-Core Version:    0.7.0.1
 */