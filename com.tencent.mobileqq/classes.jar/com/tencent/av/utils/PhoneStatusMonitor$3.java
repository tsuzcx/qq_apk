package com.tencent.av.utils;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mtf;

public class PhoneStatusMonitor$3
  implements Runnable
{
  public PhoneStatusMonitor$3(mtf parammtf) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhoneStatusMonitor", 2, "checkEndCallTask, calling[" + mtf.a(this.this$0) + "], tillEnd[" + mtf.a(this.this$0).get() + "]");
    }
    if (!mtf.a(this.this$0)) {
      this.this$0.d();
    }
    while (!mtf.a(this.this$0).get()) {
      return;
    }
    this.this$0.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.av.utils.PhoneStatusMonitor.3
 * JD-Core Version:    0.7.0.1
 */