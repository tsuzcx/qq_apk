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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getview onLocationFinish info = ");
      localStringBuilder.append(paramSosoLbsInfo);
      QLog.i("ac_ft.AddContactViewPagerTroopFragment", 2, localStringBuilder.toString());
    }
    if (paramInt != 0)
    {
      paramSosoLbsInfo = new StringBuilder();
      paramSosoLbsInfo.append("getview onLocationFinish, errorCode=");
      paramSosoLbsInfo.append(paramInt);
      QLog.i("ac_ft.AddContactViewPagerTroopFragment", 1, paramSosoLbsInfo.toString());
      this.a.h.post(new AddContactViewPagerTroopFragment.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment.4
 * JD-Core Version:    0.7.0.1
 */