package com.tencent.mobileqq.activity.contact.addcontact;

import afdi;
import afpb;
import afst;
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
  public AddContactFindTroopViewPagerAdapter(FragmentManager paramFragmentManager, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ArrayList<afpb> paramArrayList)
  {
    super(paramFragmentManager, paramQQAppInterface, paramBaseActivity, paramArrayList);
  }
  
  public ContactsBaseFragment a(int paramInt, boolean paramBoolean)
  {
    afpb localafpb = a(paramInt);
    Object localObject;
    if ((localafpb != null) && ((localafpb instanceof afdi)))
    {
      afdi localafdi = (afdi)localafpb;
      localObject = a(localafpb.c);
      if ((localObject == null) && (paramBoolean))
      {
        localObject = new AddContactViewPagerTroopFragment();
        ((AddContactViewPagerTroopFragment)localObject).jdField_a_of_type_Int = localafdi.jdField_a_of_type_Int;
        ((AddContactViewPagerTroopFragment)localObject).jdField_a_of_type_JavaLangString = localafdi.jdField_a_of_type_JavaLangString;
        ((AddContactViewPagerTroopFragment)localObject).b = localafdi.d;
        ((ContactsBaseFragment)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        ((ContactsBaseFragment)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        ((ContactsBaseFragment)localObject).a(this);
        ((ContactsBaseFragment)localObject).a(this.jdField_a_of_type_Afqs);
        ((ContactsBaseFragment)localObject).e(paramInt);
        if ((localObject instanceof afst)) {
          this.jdField_b_of_type_JavaUtilArrayList.add((afst)localObject);
        }
        this.jdField_a_of_type_AndroidUtilSparseArray.put(localafpb.c, localObject);
      }
    }
    for (;;)
    {
      if ((localObject != null) && ((localObject instanceof afst)) && (this.jdField_b_of_type_Int > 0)) {
        ((afst)localObject).a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
      return localObject;
      continue;
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactFindTroopViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */