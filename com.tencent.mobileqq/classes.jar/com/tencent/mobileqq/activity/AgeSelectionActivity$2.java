package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

class AgeSelectionActivity$2
  implements BirthdayPickHelper.BirthdayChangeListener
{
  AgeSelectionActivity$2(AgeSelectionActivity paramAgeSelectionActivity) {}
  
  public void a()
  {
    if ((AgeSelectionActivity.a(this.a) != null) && (AgeSelectionActivity.a(this.a).isShowing())) {
      AgeSelectionActivity.a(this.a).dismiss();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    AgeSelectionActivity localAgeSelectionActivity = this.a;
    localAgeSelectionActivity.b = paramInt1;
    localAgeSelectionActivity.c = paramInt2;
    localAgeSelectionActivity.d = paramInt3;
    if (QLog.isColorLevel()) {
      QLog.d("AgeSelectionActivity", 2, String.format("onBirthdayChange newBirthdayYear:%s,newBirthdayMonth:%s,newBirthdayDay:%s", new Object[] { Integer.valueOf(this.a.b), Integer.valueOf(this.a.c), Integer.valueOf(this.a.d) }));
    }
    localAgeSelectionActivity = this.a;
    AgeSelectionActivity.a(localAgeSelectionActivity, localAgeSelectionActivity.b, this.a.c, this.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AgeSelectionActivity.2
 * JD-Core Version:    0.7.0.1
 */