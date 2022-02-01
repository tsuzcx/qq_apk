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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onclick tipswording3 grant onLocationFinish info = ");
      localStringBuilder.append(paramSosoLbsInfo);
      QLog.i("ac_ft.AddContactViewPagerTroopFragment", 2, localStringBuilder.toString());
    }
    if (paramInt != 0)
    {
      paramSosoLbsInfo = new StringBuilder();
      paramSosoLbsInfo.append("onclick tipswording3 grant onLocationFinish, errorCode=");
      paramSosoLbsInfo.append(paramInt);
      QLog.i("ac_ft.AddContactViewPagerTroopFragment", 1, paramSosoLbsInfo.toString());
    }
    this.a.a.a.a.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment.2.1.1
 * JD-Core Version:    0.7.0.1
 */