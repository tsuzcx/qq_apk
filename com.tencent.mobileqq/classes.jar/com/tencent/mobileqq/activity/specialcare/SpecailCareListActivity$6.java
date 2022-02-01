package com.tencent.mobileqq.activity.specialcare;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;

class SpecailCareListActivity$6
  extends CardObserver
{
  SpecailCareListActivity$6(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void onGetCareBarEnable(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.onGetCareBarEnable(paramBoolean1, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.i("SpecailCareListActivity", 2, "onGetCareBarEnable: invoked.  barEnable: " + paramBoolean2);
    }
    SpecailCareListActivity.a(this.a).setChecked(paramBoolean2);
  }
  
  public void onSetCareBarEnable(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.onSetCareBarEnable(paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.6
 * JD-Core Version:    0.7.0.1
 */