package com.tencent.avgame.floatwindow;

import com.tencent.qphone.base.util.QLog;
import ndx;

public class FloatWindowController$1
  implements Runnable
{
  public FloatWindowController$1(ndx paramndx) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatWindowController", 2, "mDelayCheckPermissionShowFloatRunnable callback");
    }
    ndx localndx = this.this$0;
    localndx.a += 1;
    if (ndx.a(this.this$0)) {
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