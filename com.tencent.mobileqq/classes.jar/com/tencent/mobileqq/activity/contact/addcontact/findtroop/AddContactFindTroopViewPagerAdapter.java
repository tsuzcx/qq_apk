package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import aivj;
import ajjn;
import ajki;
import android.support.v4.app.FragmentManager;
import android.util.SparseArray;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public class AddContactFindTroopViewPagerAdapter
  extends ContactsViewPagerAdapter
{
  public AddContactFindTroopViewPagerAdapter(FragmentManager paramFragmentManager, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ArrayList<ajki> paramArrayList)
  {
    super(paramFragmentManager, paramQQAppInterface, paramBaseActivity, paramArrayList);
  }
  
  public ContactsBaseFragment a(int paramInt, boolean paramBoolean)
  {
    ajki localajki = a(paramInt);
    Object localObject;
    if ((localajki != null) && ((localajki instanceof aivj)))
    {
      aivj localaivj = (aivj)localajki;
      localObject = a(localajki.c);
      if ((localObject == null) && (paramBoolean))
      {
        localObject = new AddContactViewPagerTroopFragment();
        ((AddContactViewPagerTroopFragment)localObject).jdField_a_of_type_Int = localaivj.jdField_a_of_type_Int;
        ((AddContactViewPagerTroopFragment)localObject).jdField_a_of_type_JavaLangString = localaivj.jdField_a_of_type_JavaLangString;
        ((AddContactViewPagerTroopFragment)localObject).b = localaivj.d;
        ((ContactsBaseFragment)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        ((ContactsBaseFragment)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        ((ContactsBaseFragment)localObject).a(this);
        ((ContactsBaseFragment)localObject).a(this.jdField_a_of_type_Ajju);
        ((ContactsBaseFragment)localObject).e(paramInt);
        if ((localObject instanceof ajjn)) {
          this.jdField_b_of_type_JavaUtilArrayList.add((ajjn)localObject);
        }
        this.jdField_a_of_type_AndroidUtilSparseArray.put(localajki.c, localObject);
      }
    }
    for (;;)
    {
      if ((localObject != null) && ((localObject instanceof ajjn)) && (this.jdField_b_of_type_Int > 0)) {
        ((ajjn)localObject).a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
      return localObject;
      continue;
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactFindTroopViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */