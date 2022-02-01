package com.tencent.mobileqq.activity.specialcare;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;

class SpecailCareListActivity$6
  extends CardObserver
{
  SpecailCareListActivity$6(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  protected void onGetCareBarEnable(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.onGetCareBarEnable(paramBoolean1, paramBoolean2);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetCareBarEnable: invoked.  barEnable: ");
      localStringBuilder.append(paramBoolean2);
      QLog.i("SpecailCareListActivity", 2, localStringBuilder.toString());
    }
    SpecailCareListActivity.a(this.a).setChecked(paramBoolean2);
  }
  
  protected void onSetCareBarEnable(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.onSetCareBarEnable(paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.6
 * JD-Core Version:    0.7.0.1
 */