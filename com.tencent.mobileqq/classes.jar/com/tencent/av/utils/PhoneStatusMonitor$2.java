package com.tencent.av.utils;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class PhoneStatusMonitor$2
  implements Runnable
{
  PhoneStatusMonitor$2(PhoneStatusMonitor paramPhoneStatusMonitor) {}
  
  public void run()
  {
    boolean bool = PhoneStatusTools.e(PhoneStatusMonitor.a(this.this$0));
    if (QLog.isColorLevel()) {
      QLog.d("PhoneStatusMonitor", 2, "checkCalling, end, pre[" + PhoneStatusMonitor.a(this.this$0) + "], cur[" + bool + "]");
    }
    PhoneStatusMonitor.a(this.this$0, bool);
    Handler localHandler = PhoneStatusMonitor.a(this.this$0);
    if ((localHandler != null) && (PhoneStatusMonitor.a(this.this$0).get())) {
      localHandler.postDelayed(PhoneStatusMonitor.a(this.this$0), 10000L);
    }
    PhoneStatusMonitor.b(this.this$0).set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.av.utils.PhoneStatusMonitor.2
 * JD-Core Version:    0.7.0.1
 */