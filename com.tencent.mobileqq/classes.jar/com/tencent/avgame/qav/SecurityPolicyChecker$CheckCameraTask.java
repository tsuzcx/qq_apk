package com.tencent.avgame.qav;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import ngu;
import nhn;

class SecurityPolicyChecker$CheckCameraTask
  implements Runnable
{
  public void run()
  {
    ngu localngu = ngu.b();
    if (localngu == null) {}
    nhn localnhn;
    SecurityPolicyChecker localSecurityPolicyChecker;
    do
    {
      do
      {
        return;
        localnhn = localngu.a();
      } while (localnhn == null);
      localSecurityPolicyChecker = SecurityPolicyChecker.a();
      if (QLog.isColorLevel()) {
        QLog.i("SecurityPolicyChecker", 2, "CheckCameraTask, player[" + SecurityPolicyChecker.a(localSecurityPolicyChecker) + "], self[" + localnhn.b + "], auto[" + localnhn.g + "], hasLocalVideo[" + localnhn.a(1) + "]");
      }
    } while ((!localnhn.g) || (!localnhn.a(1)) || (TextUtils.equals(SecurityPolicyChecker.a(localSecurityPolicyChecker), String.valueOf(localnhn.b))));
    localngu.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.qav.SecurityPolicyChecker.CheckCameraTask
 * JD-Core Version:    0.7.0.1
 */