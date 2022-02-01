package com.tencent.av.utils;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class PhoneStatusMonitor$3
  implements Runnable
{
  PhoneStatusMonitor$3(PhoneStatusMonitor paramPhoneStatusMonitor) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkEndCallTask, calling[");
      localStringBuilder.append(PhoneStatusMonitor.b(this.this$0));
      localStringBuilder.append("], tillEnd[");
      localStringBuilder.append(PhoneStatusMonitor.e(this.this$0).get());
      localStringBuilder.append("]");
      QLog.i("PhoneStatusMonitor", 2, localStringBuilder.toString());
    }
    if (!PhoneStatusMonitor.b(this.this$0))
    {
      this.this$0.e();
      return;
    }
    if (PhoneStatusMonitor.e(this.this$0).get()) {
      this.this$0.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.PhoneStatusMonitor.3
 * JD-Core Version:    0.7.0.1
 */