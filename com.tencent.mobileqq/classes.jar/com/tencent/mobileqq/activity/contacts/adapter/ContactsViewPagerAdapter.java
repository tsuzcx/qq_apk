package com.tencent.mobileqq.activity.contacts.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.contacts.ContactsConstant;
import com.tencent.mobileqq.activity.contacts.fragment.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.fragment.ContactsBaseFragment.FragmentLifeListener;
import com.tencent.mobileqq.activity.contacts.fragment.ContactsBaseFragment.RefreshDataListener;
import com.tencent.mobileqq.activity.contacts.fragment.ContactsFragmentFactory;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ContactsViewPagerAdapter
  extends FragmentStatePagerAdapter
  implements ContactsBaseFragment.FragmentLifeListener
{
  protected SparseArray a;
  protected ContactsBaseFragment.RefreshDataListener a;
  private BaseActivity a;
  protected QQAppInterface a;
  
  public ContactsViewPagerAdapter(FragmentManager paramFragmentManager, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    super(paramFragmentManager);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(ContactsConstant.a.length);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public ContactsBaseFragment a(int paramInt, boolean paramBoolean)
  {
    ContactsBaseFragment localContactsBaseFragment2 = (ContactsBaseFragment)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    ContactsBaseFragment localContactsBaseFragment1 = localContactsBaseFragment2;
    if (localContactsBaseFragment2 == null)
    {
      localContactsBaseFragment1 = localContactsBaseFragment2;
      if (paramBoolean)
      {
        localContactsBaseFragment1 = ContactsFragmentFactory.a(paramInt);
        localContactsBaseFragment1.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        localContactsBaseFragment1.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localContactsBaseFragment1.a(this);
        localContactsBaseFragment1.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentContactsBaseFragment$RefreshDataListener);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localContactsBaseFragment1);
      }
    }
    return localContactsBaseFragment1;
  }
  
  public void a()
  {
    int i = 0;
    while (i < 6)
    {
      ContactsBaseFragment localContactsBaseFragment = (ContactsBaseFragment)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      if (localContactsBaseFragment != null) {
        localContactsBaseFragment.f();
      }
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, "onFrameTabClick:" + paramInt);
    }
    ContactsBaseFragment localContactsBaseFragment = a(paramInt, false);
    if (localContactsBaseFragment != null) {
      localContactsBaseFragment.g();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, "onPageSelected. curPos:" + paramInt1 + " prePos:" + paramInt2);
    }
    ContactsBaseFragment localContactsBaseFragment = a(paramInt1, false);
    if (localContactsBaseFragment != null) {
      localContactsBaseFragment.c(true);
    }
    localContactsBaseFragment = a(paramInt2, false);
    if (localContactsBaseFragment != null) {
      localContactsBaseFragment.c(false);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, "doOnResume:" + paramInt + " tabChange:" + paramBoolean);
    }
    ContactsBaseFragment localContactsBaseFragment = a(paramInt, false);
    if (localContactsBaseFragment != null) {
      localContactsBaseFragment.a(false);
    }
  }
  
  public void a(ContactsBaseFragment.RefreshDataListener paramRefreshDataListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentContactsBaseFragment$RefreshDataListener = paramRefreshDataListener;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      int i = 0;
      while (i < 6)
      {
        ContactsBaseFragment localContactsBaseFragment = (ContactsBaseFragment)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (localContactsBaseFragment != null)
        {
          localContactsBaseFragment.a(paramQQAppInterface);
          localContactsBaseFragment.c();
        }
        i += 1;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, "onThemeChange:" + paramBoolean);
    }
    int i = 0;
    while (i < 6)
    {
      ContactsBaseFragment localContactsBaseFragment = (ContactsBaseFragment)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      if (localContactsBaseFragment != null) {
        localContactsBaseFragment.d(paramBoolean);
      }
      i += 1;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, "doOnDestroy");
    }
    int i = 0;
    while (i < 6)
    {
      ContactsBaseFragment localContactsBaseFragment = (ContactsBaseFragment)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      if (localContactsBaseFragment != null) {
        localContactsBaseFragment.a();
      }
      i += 1;
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, "refresh:" + paramInt);
    }
    ContactsBaseFragment localContactsBaseFragment = a(paramInt, false);
    if (localContactsBaseFragment != null) {
      localContactsBaseFragment.b();
    }
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, "doOnPause:" + paramInt);
    }
    ContactsBaseFragment localContactsBaseFragment = a(paramInt, false);
    if (localContactsBaseFragment != null) {
      localContactsBaseFragment.b(false);
    }
  }
  
  public void d(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Contacts.ContactsViewPagerAdapter", 2, "remove fragment cache :" + paramInt);
      }
      ContactsBaseFragment localContactsBaseFragment = (ContactsBaseFragment)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      if (localContactsBaseFragment != null)
      {
        localContactsBaseFragment.a();
        this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
      }
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, "destroyItem:" + paramInt);
    }
    super.destroyItem(paramViewGroup, paramInt, paramObject);
  }
  
  public int getCount()
  {
    return ContactsConstant.a.length;
  }
  
  public Fragment getItem(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getItem:" + paramInt);
    }
    return a(paramInt, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.adapter.ContactsViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */