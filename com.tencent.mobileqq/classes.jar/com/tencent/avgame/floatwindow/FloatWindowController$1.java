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
    FloatWindowController localFloatWindowController = this.this$0;
    localFloatWindowController.a += 1;
    if (FloatWindowController.a(this.this$0)) {
      this.this$0.a(null, false, this.this$0.d);
    }
    if (this.this$0.a >= 3)
    {
      this.this$0.b = false;
      this.this$0.a = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.floatwindow.FloatWindowController.1
 * JD-Core Version:    0.7.0.1
 */