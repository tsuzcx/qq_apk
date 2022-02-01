package com.tencent.avgame.qav;

import android.text.TextUtils;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.qphone.base.util.QLog;
import ndt;

class SecurityPolicyChecker$CheckCameraTask
  implements Runnable
{
  public void run()
  {
    ndt localndt = ndt.b();
    if (localndt == null) {}
    AVGameSession localAVGameSession;
    SecurityPolicyChecker localSecurityPolicyChecker;
    do
    {
      do
      {
        return;
        localAVGameSession = localndt.a();
      } while (localAVGameSession == null);
      localSecurityPolicyChecker = SecurityPolicyChecker.a();
      if (QLog.isColorLevel()) {
        QLog.i("SecurityPolicyChecker", 2, "CheckCameraTask, player[" + SecurityPolicyChecker.a(localSecurityPolicyChecker) + "], self[" + localAVGameSession.b + "], auto[" + localAVGameSession.g + "], hasLocalVideo[" + localAVGameSession.a(1) + "]");
      }
    } while ((!localAVGameSession.g) || (!localAVGameSession.a(1)) || (TextUtils.equals(SecurityPolicyChecker.a(localSecurityPolicyChecker), String.valueOf(localAVGameSession.b))));
    localndt.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.qav.SecurityPolicyChecker.CheckCameraTask
 * JD-Core Version:    0.7.0.1
 */