package com.tencent.avgame.qav;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import nnm;
import nof;

class SecurityPolicyChecker$CheckCameraTask
  implements Runnable
{
  public void run()
  {
    nnm localnnm = nnm.b();
    if (localnnm == null) {}
    nof localnof;
    SecurityPolicyChecker localSecurityPolicyChecker;
    do
    {
      do
      {
        return;
        localnof = localnnm.a();
      } while (localnof == null);
      localSecurityPolicyChecker = SecurityPolicyChecker.a();
      if (QLog.isColorLevel()) {
        QLog.i("SecurityPolicyChecker", 2, "CheckCameraTask, player[" + SecurityPolicyChecker.a(localSecurityPolicyChecker) + "], self[" + localnof.b + "], auto[" + localnof.g + "], hasLocalVideo[" + localnof.a(1) + "]");
      }
    } while ((!localnof.g) || (!localnof.a(1)) || (TextUtils.equals(SecurityPolicyChecker.a(localSecurityPolicyChecker), String.valueOf(localnof.b))));
    localnnm.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.qav.SecurityPolicyChecker.CheckCameraTask
 * JD-Core Version:    0.7.0.1
 */