package com.tencent.avgame.floatwindow;

import com.tencent.qphone.base.util.QLog;
import myl;

public class FloatWindowController$1
  implements Runnable
{
  public FloatWindowController$1(myl parammyl) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatWindowController", 2, "mDelayCheckPermissionShowFloatRunnable callback");
    }
    myl localmyl = this.this$0;
    localmyl.a += 1;
    if (myl.a(this.this$0)) {
      this.this$0.a(null, false, this.this$0.d);
    }
    if (this.this$0.a >= 3)
    {
      this.this$0.b = false;
      this.this$0.a = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.floatwindow.FloatWindowController.1
 * JD-Core Version:    0.7.0.1
 */