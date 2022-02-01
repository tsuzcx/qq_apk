package com.tencent.mobileqq.activity.contacts.troop;

import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.qphone.base.util.QLog;

class TroopFragment$3
  extends AutomatorObserver
{
  TroopFragment$3(TroopFragment paramTroopFragment) {}
  
  protected void a(int paramInt)
  {
    if (paramInt != 2) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCacheInited ");
      localStringBuilder.append(paramInt);
      QLog.d("contacts.fragment.TroopFragment", 2, localStringBuilder.toString());
    }
    if (this.a.a != null) {
      this.a.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.TroopFragment.3
 * JD-Core Version:    0.7.0.1
 */