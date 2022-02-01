package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.qphone.base.util.QLog;

class PermisionPrivacyActivity$12
  extends LBSObserver
{
  PermisionPrivacyActivity$12(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  protected void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateGetSwitch| isSuc = ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(", userType = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", curSwitch = ");
      localStringBuilder.append(paramBoolean2);
      QLog.i("Q.security", 2, localStringBuilder.toString());
    }
    if ((paramBoolean1) && (paramInt == 64)) {
      this.a.a(paramBoolean2);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateSetShareStatus| isSuc = ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(", beShare = ");
      localStringBuilder.append(paramBoolean2);
      QLog.i("Q.security", 2, localStringBuilder.toString());
    }
    if (!paramBoolean1) {
      this.a.a(2131718834, 1);
    }
    this.a.a(paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.12
 * JD-Core Version:    0.7.0.1
 */