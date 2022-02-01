package com.tencent.av.utils;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import msb;
import msf;

public class PhoneStatusMonitor$2
  implements Runnable
{
  public PhoneStatusMonitor$2(msb parammsb) {}
  
  public void run()
  {
    boolean bool = msf.d(msb.a(this.this$0));
    if (QLog.isColorLevel()) {
      QLog.d("PhoneStatusMonitor", 2, "checkCalling, end, pre[" + msb.a(this.this$0) + "], cur[" + bool + "]");
    }
    msb.a(this.this$0, bool);
    Handler localHandler = msb.a(this.this$0);
    if ((localHandler != null) && (msb.a(this.this$0).get())) {
      localHandler.postDelayed(msb.a(this.this$0), 10000L);
    }
    msb.b(this.this$0).set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.av.utils.PhoneStatusMonitor.2
 * JD-Core Version:    0.7.0.1
 */