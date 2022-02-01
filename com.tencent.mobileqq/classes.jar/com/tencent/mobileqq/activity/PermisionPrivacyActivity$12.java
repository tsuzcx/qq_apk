package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.qphone.base.util.QLog;

class PermisionPrivacyActivity$12
  extends LBSObserver
{
  PermisionPrivacyActivity$12(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.security", 2, "onUpdateGetSwitch| isSuc = " + paramBoolean1 + ", userType = " + paramInt + ", curSwitch = " + paramBoolean2);
    }
    if ((paramBoolean1) && (paramInt == 64)) {
      this.a.a(paramBoolean2);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.security", 2, "onUpdateSetShareStatus| isSuc = " + paramBoolean1 + ", beShare = " + paramBoolean2);
    }
    if (!paramBoolean1) {
      this.a.a(2131719116, 1);
    }
    this.a.a(paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.12
 * JD-Core Version:    0.7.0.1
 */