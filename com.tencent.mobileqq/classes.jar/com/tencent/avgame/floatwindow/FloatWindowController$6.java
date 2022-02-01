package com.tencent.avgame.floatwindow;

import com.tencent.qphone.base.util.QLog;
import ndx;

public class FloatWindowController$6
  implements Runnable
{
  public FloatWindowController$6(ndx paramndx) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatWindowController", 2, "mIsForeGroundTrueRunnable run");
    }
    ndx.a(this.this$0).a = true;
    if (ndx.b(this.this$0))
    {
      if (ndx.a(this.this$0)) {
        break label67;
      }
      this.this$0.c();
      if (QLog.isColorLevel()) {
        QLog.d("FloatWindowController", 2, "ACTION_QQ_FOREGROUND no permission hideFloatWindow");
      }
    }
    return;
    label67:
    ndx.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.floatwindow.FloatWindowController.6
 * JD-Core Version:    0.7.0.1
 */