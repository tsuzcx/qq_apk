package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator.OnTabListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class TroopView$4
  implements SimpleSlidingIndicator.OnTabListener
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
    Object localObject = TroopView.a(this.a).a(i, false);
    if (localObject != null)
    {
      localObject = (AddContactViewPagerTroopFragment)localObject;
      AddContactFindTroopClassifyInfo localAddContactFindTroopClassifyInfo = (AddContactFindTroopClassifyInfo)this.a.a.get(i);
      if ((paramInt >= 0) && (paramInt < localAddContactFindTroopClassifyInfo.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        localAddContactFindTroopClassifyInfo.b = paramInt;
        AddContactFindTroopClassifyInfo.TagInfo localTagInfo = (AddContactFindTroopClassifyInfo.TagInfo)localAddContactFindTroopClassifyInfo.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        ((AddContactViewPagerTroopFragment)localObject).a(localTagInfo.b, localTagInfo.jdField_a_of_type_JavaLangString);
        ReportController.b(null, "dc00899", "Grp_find_new", "", "grptab", "sub_tag_clk", 0, 0, localTagInfo.jdField_a_of_type_JavaLangString, localAddContactFindTroopClassifyInfo.jdField_a_of_type_JavaLangString, "", "");
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView.4
 * JD-Core Version:    0.7.0.1
 */