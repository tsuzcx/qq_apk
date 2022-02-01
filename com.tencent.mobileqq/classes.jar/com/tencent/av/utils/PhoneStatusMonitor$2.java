package com.tencent.av.utils;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import msz;
import mtd;

public class PhoneStatusMonitor$2
  implements Runnable
{
  public PhoneStatusMonitor$2(msz parammsz) {}
  
  public void run()
  {
    boolean bool = mtd.d(msz.a(this.this$0));
    if (QLog.isColorLevel()) {
      QLog.d("PhoneStatusMonitor", 2, "checkCalling, end, pre[" + msz.a(this.this$0) + "], cur[" + bool + "]");
    }
    msz.a(this.this$0, bool);
    Handler localHandler = msz.a(this.this$0);
    if ((localHandler != null) && (msz.a(this.this$0).get())) {
      localHandler.postDelayed(msz.a(this.this$0), 10000L);
    }
    msz.b(this.this$0).set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.av.utils.PhoneStatusMonitor.2
 * JD-Core Version:    0.7.0.1
 */