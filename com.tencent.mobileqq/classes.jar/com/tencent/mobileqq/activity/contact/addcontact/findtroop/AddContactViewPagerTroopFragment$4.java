package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.widget.LinearLayout;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class AddContactViewPagerTroopFragment$4
  extends LbsManagerServiceOnLocationChangeListener
{
  AddContactViewPagerTroopFragment$4(AddContactViewPagerTroopFragment paramAddContactViewPagerTroopFragment, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ac_ft.AddContactViewPagerTroopFragment", 2, "getview onLocationFinish info = " + paramSosoLbsInfo);
    }
    if (paramInt != 0)
    {
      QLog.i("ac_ft.AddContactViewPagerTroopFragment", 1, "getview onLocationFinish, errorCode=" + paramInt);
      this.a.a.post(new AddContactViewPagerTroopFragment.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment.4
 * JD-Core Version:    0.7.0.1
 */