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
    boolean bool = PhoneStatusTools.e(PhoneStatusMonitor.c(this.this$0));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkCalling, end, pre[");
      ((StringBuilder)localObject).append(PhoneStatusMonitor.b(this.this$0));
      ((StringBuilder)localObject).append("], cur[");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("]");
      QLog.d("PhoneStatusMonitor", 2, ((StringBuilder)localObject).toString());
    }
    PhoneStatusMonitor.a(this.this$0, bool);
    Object localObject = PhoneStatusMonitor.d(this.this$0);
    if ((localObject != null) && (PhoneStatusMonitor.e(this.this$0).get())) {
      ((Handler)localObject).postDelayed(PhoneStatusMonitor.f(this.this$0), 10000L);
    }
    PhoneStatusMonitor.g(this.this$0).set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.PhoneStatusMonitor.2
 * JD-Core Version:    0.7.0.1
 */