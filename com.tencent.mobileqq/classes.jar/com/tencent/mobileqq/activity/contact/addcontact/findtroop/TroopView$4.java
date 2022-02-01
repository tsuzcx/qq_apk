package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.AbsSlidingIndicator.OnTabListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class TroopView$4
  implements AbsSlidingIndicator.OnTabListener
{
  TroopView$4(TroopView paramTroopView) {}
  
  public int a(int paramInt, boolean paramBoolean)
  {
    int i = TroopView.a(this.a).getCurrentItem();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onTabChanged. position:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" currentClassifyPos:");
      ((StringBuilder)localObject).append(i);
      QLog.i("addContacts.TroopView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = TroopView.e(this.a).a(i, false);
    if (localObject != null)
    {
      localObject = (AddContactViewPagerTroopFragment)localObject;
      AddContactFindTroopClassifyInfo localAddContactFindTroopClassifyInfo = (AddContactFindTroopClassifyInfo)this.a.e.get(i);
      if ((paramInt >= 0) && (paramInt < localAddContactFindTroopClassifyInfo.h.size()))
      {
        localAddContactFindTroopClassifyInfo.g = paramInt;
        AddContactFindTroopClassifyInfo.TagInfo localTagInfo = (AddContactFindTroopClassifyInfo.TagInfo)localAddContactFindTroopClassifyInfo.h.get(paramInt);
        ((AddContactViewPagerTroopFragment)localObject).a(localTagInfo.b, localTagInfo.a);
        ReportController.b(null, "dc00899", "Grp_find_new", "", "grptab", "sub_tag_clk", 0, 0, localTagInfo.a, localAddContactFindTroopClassifyInfo.a, "", "");
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView.4
 * JD-Core Version:    0.7.0.1
 */