package com.tencent.avgame.floatwindow;

import com.tencent.qphone.base.util.QLog;

class FloatWindowController$6
  implements Runnable
{
  FloatWindowController$6(FloatWindowController paramFloatWindowController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatWindowController", 2, "mIsForeGroundTrueRunnable run");
    }
    FloatWindowController.a(this.this$0).a = true;
    if (FloatWindowController.b(this.this$0)) {
      if (!FloatWindowController.a(this.this$0))
      {
        this.this$0.c();
        if (QLog.isColorLevel()) {
          QLog.d("FloatWindowController", 2, "ACTION_QQ_FOREGROUND no permission hideFloatWindow");
        }
      }
      else
      {
        FloatWindowController.a(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.floatwindow.FloatWindowController.6
 * JD-Core Version:    0.7.0.1
 */