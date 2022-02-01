package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.qphone.base.util.QLog;

class ForwardTroopListFragment$5
  extends AutomatorObserver
{
  ForwardTroopListFragment$5(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
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
      this.a.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardTroopListFragment.5
 * JD-Core Version:    0.7.0.1
 */