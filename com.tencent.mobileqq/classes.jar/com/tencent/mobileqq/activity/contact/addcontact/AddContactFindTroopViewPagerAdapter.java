package com.tencent.mobileqq.activity.contact.addcontact;

import ahan;
import ahms;
import ahql;
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
  public AddContactFindTroopViewPagerAdapter(FragmentManager paramFragmentManager, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ArrayList<ahms> paramArrayList)
  {
    super(paramFragmentManager, paramQQAppInterface, paramBaseActivity, paramArrayList);
  }
  
  public ContactsBaseFragment a(int paramInt, boolean paramBoolean)
  {
    ahms localahms = a(paramInt);
    Object localObject;
    if ((localahms != null) && ((localahms instanceof ahan)))
    {
      ahan localahan = (ahan)localahms;
      localObject = a(localahms.c);
      if ((localObject == null) && (paramBoolean))
      {
        localObject = new AddContactViewPagerTroopFragment();
        ((AddContactViewPagerTroopFragment)localObject).jdField_a_of_type_Int = localahan.jdField_a_of_type_Int;
        ((AddContactViewPagerTroopFragment)localObject).jdField_a_of_type_JavaLangString = localahan.jdField_a_of_type_JavaLangString;
        ((AddContactViewPagerTroopFragment)localObject).b = localahan.d;
        ((ContactsBaseFragment)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        ((ContactsBaseFragment)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        ((ContactsBaseFragment)localObject).a(this);
        ((ContactsBaseFragment)localObject).a(this.jdField_a_of_type_Ahoj);
        ((ContactsBaseFragment)localObject).e(paramInt);
        if ((localObject instanceof ahql)) {
          this.jdField_b_of_type_JavaUtilArrayList.add((ahql)localObject);
        }
        this.jdField_a_of_type_AndroidUtilSparseArray.put(localahms.c, localObject);
      }
    }
    for (;;)
    {
      if ((localObject != null) && ((localObject instanceof ahql)) && (this.jdField_b_of_type_Int > 0)) {
        ((ahql)localObject).a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
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