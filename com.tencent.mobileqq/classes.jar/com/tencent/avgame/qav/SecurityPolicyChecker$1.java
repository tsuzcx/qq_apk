package com.tencent.avgame.qav;

import android.os.Handler;
import com.tencent.avgame.config.AvGameConfigUtil;
import com.tencent.avgame.config.data.AvGameConfBean;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class SecurityPolicyChecker$1
  implements Runnable
{
  SecurityPolicyChecker$1(SecurityPolicyChecker paramSecurityPolicyChecker, WeakReference paramWeakReference) {}
  
  public void run()
  {
    boolean bool1 = SecurityPolicyChecker.a(this.this$0);
    Object localObject = AvGameConfigUtil.a();
    boolean bool2 = false;
    if (localObject != null) {
      if (((AvGameConfBean)localObject).f() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkSecurityPolicy, [");
      ((StringBuilder)localObject).append(SecurityPolicyChecker.a(this.this$0));
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append("], Init[");
      ((StringBuilder)localObject).append(SecurityPolicyChecker.b(this.this$0));
      ((StringBuilder)localObject).append("]");
      QLog.i("SecurityPolicyChecker", 2, ((StringBuilder)localObject).toString());
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
    AVGameHandler.a().c().post(new SecurityPolicyChecker.1.1(this, bool2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.SecurityPolicyChecker.1
 * JD-Core Version:    0.7.0.1
 */