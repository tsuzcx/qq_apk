package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.support.v4.app.FragmentManager;
import android.util.SparseArray;
import com.tencent.mobileqq.activity.contacts.base.HeadViewScrollListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.base.tabs.TabInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public class AddContactFindTroopViewPagerAdapter
  extends ContactsViewPagerAdapter
{
  public AddContactFindTroopViewPagerAdapter(FragmentManager paramFragmentManager, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ArrayList<TabInfo> paramArrayList)
  {
    super(paramFragmentManager, paramQQAppInterface, paramBaseActivity, paramArrayList);
  }
  
  public ContactsBaseFragment a(int paramInt, boolean paramBoolean)
  {
    TabInfo localTabInfo = a(paramInt);
    Object localObject;
    if ((localTabInfo != null) && ((localTabInfo instanceof AddContactFindTroopClassifyInfo)))
    {
      AddContactFindTroopClassifyInfo localAddContactFindTroopClassifyInfo = (AddContactFindTroopClassifyInfo)localTabInfo;
      localObject = a(localTabInfo.c);
      if ((localObject == null) && (paramBoolean))
      {
        localObject = new AddContactViewPagerTroopFragment();
        ((AddContactViewPagerTroopFragment)localObject).jdField_a_of_type_Int = localAddContactFindTroopClassifyInfo.jdField_a_of_type_Int;
        ((AddContactViewPagerTroopFragment)localObject).jdField_a_of_type_JavaLangString = localAddContactFindTroopClassifyInfo.jdField_a_of_type_JavaLangString;
        ((AddContactViewPagerTroopFragment)localObject).b = localAddContactFindTroopClassifyInfo.d;
        ((ContactsBaseFragment)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        ((ContactsBaseFragment)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        ((ContactsBaseFragment)localObject).a(this);
        ((ContactsBaseFragment)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsBaseFragment$RefreshDataListener);
        ((ContactsBaseFragment)localObject).e(paramInt);
        if ((localObject instanceof HeadViewScrollListener)) {
          this.jdField_b_of_type_JavaUtilArrayList.add((HeadViewScrollListener)localObject);
        }
        this.jdField_a_of_type_AndroidUtilSparseArray.put(localTabInfo.c, localObject);
      }
    }
    for (;;)
    {
      if ((localObject != null) && ((localObject instanceof HeadViewScrollListener)) && (this.jdField_b_of_type_Int > 0)) {
        ((HeadViewScrollListener)localObject).a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
      return localObject;
      continue;
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactFindTroopViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */