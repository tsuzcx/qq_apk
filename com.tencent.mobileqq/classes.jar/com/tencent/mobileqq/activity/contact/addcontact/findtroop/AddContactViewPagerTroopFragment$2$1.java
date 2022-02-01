package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.widget.LinearLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import mqq.app.QQPermissionCallback;

class AddContactViewPagerTroopFragment$2$1
  implements QQPermissionCallback
{
  AddContactViewPagerTroopFragment$2$1(AddContactViewPagerTroopFragment.2 param2) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "requestLBSPermissionOnClickListener deny");
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "onclick requestLBSPermissionOnClickListener grant");
    }
    this.a.a.h.setVisibility(8);
    this.a.a.a.setVisibility(0);
    if (((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("recommend_troop") == null)
    {
      ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new AddContactViewPagerTroopFragment.2.1.1(this, "recommend_troop"));
      return;
    }
    this.a.a.b.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment.2.1
 * JD-Core Version:    0.7.0.1
 */