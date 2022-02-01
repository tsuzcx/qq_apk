package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

class AgeSelectionActivity$2
  implements BirthdayPickHelper.BirthdayChangeListener
{
  AgeSelectionActivity$2(AgeSelectionActivity paramAgeSelectionActivity) {}
  
  public void a()
  {
    if ((AgeSelectionActivity.c(this.a) != null) && (AgeSelectionActivity.c(this.a).isShowing())) {
      AgeSelectionActivity.c(this.a).dismiss();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    AgeSelectionActivity localAgeSelectionActivity = this.a;
    localAgeSelectionActivity.c = paramInt1;
    localAgeSelectionActivity.d = paramInt2;
    localAgeSelectionActivity.e = paramInt3;
    if (QLog.isColorLevel()) {
      QLog.d("AgeSelectionActivity", 2, String.format("onBirthdayChange newBirthdayYear:%s,newBirthdayMonth:%s,newBirthdayDay:%s", new Object[] { Integer.valueOf(this.a.c), Integer.valueOf(this.a.d), Integer.valueOf(this.a.e) }));
    }
    localAgeSelectionActivity = this.a;
    AgeSelectionActivity.a(localAgeSelectionActivity, localAgeSelectionActivity.c, this.a.d, this.a.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AgeSelectionActivity.2
 * JD-Core Version:    0.7.0.1
 */