package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class AddContactViewPagerTroopFragment$2$1$1
  extends LbsManagerServiceOnLocationChangeListener
{
  AddContactViewPagerTroopFragment$2$1$1(AddContactViewPagerTroopFragment.2.1 param1, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ac_ft.AddContactViewPagerTroopFragment", 2, "onclick tipswording3 grant onLocationFinish info = " + paramSosoLbsInfo);
    }
    if (paramInt != 0) {
      QLog.i("ac_ft.AddContactViewPagerTroopFragment", 1, "onclick tipswording3 grant onLocationFinish, errorCode=" + paramInt);
    }
    this.a.a.a.a.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment.2.1.1
 * JD-Core Version:    0.7.0.1
 */