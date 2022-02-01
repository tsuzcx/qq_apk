package com.tencent.avgame.qav;

import android.text.TextUtils;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.qphone.base.util.QLog;

class SecurityPolicyChecker$CheckCameraTask
  implements Runnable
{
  public void run()
  {
    IAVGameBusinessCtrl localIAVGameBusinessCtrl = IAVGameBusinessCtrl.p();
    if (localIAVGameBusinessCtrl == null) {
      return;
    }
    AVGameSession localAVGameSession = localIAVGameBusinessCtrl.j();
    if (localAVGameSession == null) {
      return;
    }
    SecurityPolicyChecker localSecurityPolicyChecker = SecurityPolicyChecker.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CheckCameraTask, player[");
      localStringBuilder.append(SecurityPolicyChecker.c(localSecurityPolicyChecker));
      localStringBuilder.append("], self[");
      localStringBuilder.append(localAVGameSession.l);
      localStringBuilder.append("], auto[");
      localStringBuilder.append(localAVGameSession.o);
      localStringBuilder.append("], hasLocalVideo[");
      localStringBuilder.append(localAVGameSession.c(1));
      localStringBuilder.append("]");
      QLog.i("SecurityPolicyChecker", 2, localStringBuilder.toString());
    }
    if ((localAVGameSession.o) && (localAVGameSession.c(1)) && (!TextUtils.equals(SecurityPolicyChecker.c(localSecurityPolicyChecker), String.valueOf(localAVGameSession.l)))) {
      localIAVGameBusinessCtrl.l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.SecurityPolicyChecker.CheckCameraTask
 * JD-Core Version:    0.7.0.1
 */