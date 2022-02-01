package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import ajgb;
import ajtb;
import ajtw;
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
  public AddContactFindTroopViewPagerAdapter(FragmentManager paramFragmentManager, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ArrayList<ajtw> paramArrayList)
  {
    super(paramFragmentManager, paramQQAppInterface, paramBaseActivity, paramArrayList);
  }
  
  public ContactsBaseFragment a(int paramInt, boolean paramBoolean)
  {
    ajtw localajtw = a(paramInt);
    Object localObject;
    if ((localajtw != null) && ((localajtw instanceof ajgb)))
    {
      ajgb localajgb = (ajgb)localajtw;
      localObject = a(localajtw.c);
      if ((localObject == null) && (paramBoolean))
      {
        localObject = new AddContactViewPagerTroopFragment();
        ((AddContactViewPagerTroopFragment)localObject).jdField_a_of_type_Int = localajgb.jdField_a_of_type_Int;
        ((AddContactViewPagerTroopFragment)localObject).jdField_a_of_type_JavaLangString = localajgb.jdField_a_of_type_JavaLangString;
        ((AddContactViewPagerTroopFragment)localObject).b = localajgb.d;
        ((ContactsBaseFragment)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        ((ContactsBaseFragment)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        ((ContactsBaseFragment)localObject).a(this);
        ((ContactsBaseFragment)localObject).a(this.jdField_a_of_type_Ajti);
        ((ContactsBaseFragment)localObject).e(paramInt);
        if ((localObject instanceof ajtb)) {
          this.jdField_b_of_type_JavaUtilArrayList.add((ajtb)localObject);
        }
        this.jdField_a_of_type_AndroidUtilSparseArray.put(localajtw.c, localObject);
      }
    }
    for (;;)
    {
      if ((localObject != null) && ((localObject instanceof ajtb)) && (this.jdField_b_of_type_Int > 0)) {
        ((ajtb)localObject).a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
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