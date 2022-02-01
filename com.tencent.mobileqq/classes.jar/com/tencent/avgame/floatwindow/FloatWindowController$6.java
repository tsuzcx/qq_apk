package com.tencent.avgame.floatwindow;

import com.tencent.qphone.base.util.QLog;
import mxb;

public class FloatWindowController$6
  implements Runnable
{
  public FloatWindowController$6(mxb parammxb) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatWindowController", 2, "mIsForeGroundTrueRunnable run");
    }
    mxb.a(this.this$0).a = true;
    if (mxb.b(this.this$0))
    {
      if (mxb.a(this.this$0)) {
        break label67;
      }
      this.this$0.c();
      if (QLog.isColorLevel()) {
        QLog.d("FloatWindowController", 2, "ACTION_QQ_FOREGROUND no permission hideFloatWindow");
      }
    }
    return;
    label67:
    mxb.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.floatwindow.FloatWindowController.6
 * JD-Core Version:    0.7.0.1
 */