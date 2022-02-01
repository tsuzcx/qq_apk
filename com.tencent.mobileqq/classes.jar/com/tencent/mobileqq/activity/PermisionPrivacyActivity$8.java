package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.friends.intimate.IntimateInfoObserver;
import com.tencent.qphone.base.util.QLog;

class PermisionPrivacyActivity$8
  extends IntimateInfoObserver
{
  PermisionPrivacyActivity$8(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    super.a(paramBoolean, paramString);
    if (QLog.isColorLevel()) {
      QLog.i("Q.security", 2, "onBandIntimateRelationship");
    }
    PermisionPrivacyActivity.a(this.a);
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramString, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.i("Q.security", 2, "onDisbandIntimateRelationship");
    }
    PermisionPrivacyActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.8
 * JD-Core Version:    0.7.0.1
 */