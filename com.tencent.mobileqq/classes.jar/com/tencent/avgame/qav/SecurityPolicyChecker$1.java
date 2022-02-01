package com.tencent.avgame.qav;

import android.os.Handler;
import apub;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;
import nht;
import nji;

class SecurityPolicyChecker$1
  implements Runnable
{
  SecurityPolicyChecker$1(SecurityPolicyChecker paramSecurityPolicyChecker, WeakReference paramWeakReference) {}
  
  public void run()
  {
    boolean bool2 = false;
    boolean bool1 = SecurityPolicyChecker.a(this.this$0);
    nji localnji = (nji)apub.a().a(642);
    if (localnji != null) {
      if (localnji.a() == 1) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SecurityPolicyChecker", 2, "checkSecurityPolicy, [" + SecurityPolicyChecker.a(this.this$0) + "," + bool1 + "], Init[" + SecurityPolicyChecker.b(this.this$0) + "]");
      }
      if (bool1 != SecurityPolicyChecker.a(this.this$0)) {
        bool2 = true;
      }
      if (bool2) {
        SecurityPolicyChecker.a(this.this$0, bool1);
      }
      if (!SecurityPolicyChecker.b(this.this$0)) {
        SecurityPolicyChecker.b(this.this$0, true);
      }
      nht.a().b().post(new SecurityPolicyChecker.1.1(this, bool2));
      return;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.qav.SecurityPolicyChecker.1
 * JD-Core Version:    0.7.0.1
 */