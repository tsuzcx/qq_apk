package com.tencent.mobileqq.activity.contact.addcontact;

import ahfc;
import ahrh;
import ahva;
import android.support.v4.app.FragmentManager;
import android.util.SparseArray;
import com.tencent.mobileqq.activity.contacts.adapter.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.fragment.ContactsBaseFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public class AddContactFindTroopViewPagerAdapter
  extends ContactsViewPagerAdapter
{
  public AddContactFindTroopViewPagerAdapter(FragmentManager paramFragmentManager, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ArrayList<ahrh> paramArrayList)
  {
    super(paramFragmentManager, paramQQAppInterface, paramBaseActivity, paramArrayList);
  }
  
  public ContactsBaseFragment a(int paramInt, boolean paramBoolean)
  {
    ahrh localahrh = a(paramInt);
    Object localObject;
    if ((localahrh != null) && ((localahrh instanceof ahfc)))
    {
      ahfc localahfc = (ahfc)localahrh;
      localObject = a(localahrh.c);
      if ((localObject == null) && (paramBoolean))
      {
        localObject = new AddContactViewPagerTroopFragment();
        ((AddContactViewPagerTroopFragment)localObject).jdField_a_of_type_Int = localahfc.jdField_a_of_type_Int;
        ((AddContactViewPagerTroopFragment)localObject).jdField_a_of_type_JavaLangString = localahfc.jdField_a_of_type_JavaLangString;
        ((AddContactViewPagerTroopFragment)localObject).b = localahfc.d;
        ((ContactsBaseFragment)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        ((ContactsBaseFragment)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        ((ContactsBaseFragment)localObject).a(this);
        ((ContactsBaseFragment)localObject).a(this.jdField_a_of_type_Ahsy);
        ((ContactsBaseFragment)localObject).e(paramInt);
        if ((localObject instanceof ahva)) {
          this.jdField_b_of_type_JavaUtilArrayList.add((ahva)localObject);
        }
        this.jdField_a_of_type_AndroidUtilSparseArray.put(localahrh.c, localObject);
      }
    }
    for (;;)
    {
      if ((localObject != null) && ((localObject instanceof ahva)) && (this.jdField_b_of_type_Int > 0)) {
        ((ahva)localObject).a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
      return localObject;
      continue;
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactFindTroopViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */