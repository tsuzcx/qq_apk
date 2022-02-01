package com.tencent.avgame.qav;

import mqq.util.WeakReference;

class SecurityPolicyChecker$1$1
  implements Runnable
{
  SecurityPolicyChecker$1$1(SecurityPolicyChecker.1 param1, boolean paramBoolean) {}
  
  public void run()
  {
    SecurityPolicyChecker.CheckSecurityPolicyCallback localCheckSecurityPolicyCallback = (SecurityPolicyChecker.CheckSecurityPolicyCallback)this.jdField_a_of_type_ComTencentAvgameQavSecurityPolicyChecker$1.a.get();
    if (localCheckSecurityPolicyCallback != null) {
      localCheckSecurityPolicyCallback.a(this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.qav.SecurityPolicyChecker.1.1
 * JD-Core Version:    0.7.0.1
 */