package com.tencent.mobileqq.activity.contacts.base.tabs;

import ajtb;
import ajth;
import ajti;
import ajtj;
import ajtw;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.SparseArray;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ContactsViewPagerAdapter
  extends CustomFragmentStatePagerAdapter
  implements ajth
{
  protected int a;
  protected ajti a;
  protected SparseArray<ContactsBaseFragment> a;
  protected BaseActivity a;
  protected QQAppInterface a;
  protected ArrayList<ajtw> a;
  protected int b;
  protected ArrayList<ajtb> b;
  
  public ContactsViewPagerAdapter(FragmentManager paramFragmentManager, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ArrayList<ajtw> paramArrayList)
  {
    super(paramFragmentManager);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
  }
  
  protected int a(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((ajtw)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  protected ajtw a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return (ajtw)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public Fragment a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getItem:" + paramInt);
    }
    return a(paramInt, true);
  }
  
  protected ContactsBaseFragment a(int paramInt)
  {
    return (ContactsBaseFragment)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt, null);
  }
  
  public ContactsBaseFragment a(int paramInt, boolean paramBoolean)
  {
    ajtw localajtw = a(paramInt);
    Object localObject = null;
    if (localajtw != null)
    {
      ContactsBaseFragment localContactsBaseFragment = a(localajtw.c);
      localObject = localContactsBaseFragment;
      if (localContactsBaseFragment == null)
      {
        localObject = localContactsBaseFragment;
        if (paramBoolean)
        {
          localObject = ajtj.a(localajtw.c);
          ((ContactsBaseFragment)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          ((ContactsBaseFragment)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          ((ContactsBaseFragment)localObject).a(this);
          ((ContactsBaseFragment)localObject).a(this.jdField_a_of_type_Ajti);
          ((ContactsBaseFragment)localObject).e(paramInt);
          if ((localObject instanceof ajtb)) {
            this.jdField_b_of_type_JavaUtilArrayList.add((ajtb)localObject);
          }
          this.jdField_a_of_type_AndroidUtilSparseArray.put(localajtw.c, localObject);
          QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getFragment ..... create " + paramInt + "  " + localajtw.c);
        }
      }
    }
    if (localObject != null) {
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getFragment ..... pos:" + paramInt + "  id:" + ((ContactsBaseFragment)localObject).a() + "  isDetached: " + ((ContactsBaseFragment)localObject).isDetached() + " contactsViewPager:" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131364996) + "  isAdd: " + ((ContactsBaseFragment)localObject).isAdded() + " " + localObject);
    }
    if ((localObject != null) && ((localObject instanceof ajtb)) && (this.jdField_b_of_type_Int > 0)) {
      ((ajtb)localObject).a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    }
    return localObject;
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject = a(i);
      if (localObject != null)
      {
        localObject = a(((ajtw)localObject).c);
        if (localObject != null) {
          ((ContactsBaseFragment)localObject).g();
        }
      }
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Contacts.ContactsViewPagerAdapter", 2, "remove fragment cache :" + paramInt);
      }
      ContactsBaseFragment localContactsBaseFragment = a(paramInt);
      if (localContactsBaseFragment != null)
      {
        localContactsBaseFragment.a();
        this.jdField_a_of_type_AndroidUtilSparseArray.delete(paramInt);
        this.jdField_b_of_type_JavaUtilArrayList.remove(localContactsBaseFragment);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Contacts.ContactsViewPagerAdapter", 2, "headViewScrollChanged currentY:" + paramInt1 + "  maxY:" + paramInt2);
    }
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      ((ajtb)this.jdField_b_of_type_JavaUtilArrayList.get(i)).a(paramInt1, paramInt2);
      i += 1;
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
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
  
  public void a(ajti paramajti)
  {
    this.jdField_a_of_type_Ajti = paramajti;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        Object localObject = a(i);
        if (localObject != null)
        {
          localObject = a(((ajtw)localObject).c);
          if (localObject != null)
          {
            ((ContactsBaseFragment)localObject).a(paramQQAppInterface);
            ((ContactsBaseFragment)localObject).c();
          }
        }
        i += 1;
      }
    }
  }
  
  public void a(ArrayList<ajtw> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    c();
    if (QLog.isColorLevel()) {
      QLog.i("Contacts.ContactsViewPagerAdapter", 2, "tabDatasUpdated. size:" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, "onThemeChange:" + paramBoolean);
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject = a(i);
      if (localObject != null)
      {
        localObject = a(((ajtw)localObject).c);
        if (localObject != null) {
          ((ContactsBaseFragment)localObject).e(paramBoolean);
        }
      }
      i += 1;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, "doOnDestroy  mFragmentsCache.size() = " + this.jdField_a_of_type_AndroidUtilSparseArray.size());
    }
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ContactsBaseFragment localContactsBaseFragment = (ContactsBaseFragment)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localContactsBaseFragment != null) {
        localContactsBaseFragment.a();
      }
      i += 1;
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, "onFrameTabClick:" + paramInt);
    }
    ContactsBaseFragment localContactsBaseFragment = a(paramInt, false);
    if (localContactsBaseFragment != null) {
      localContactsBaseFragment.f();
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, "onPageSelected. curPos:" + paramInt1 + " prePos:" + paramInt2);
    }
    ContactsBaseFragment localContactsBaseFragment = a(paramInt1, false);
    if (localContactsBaseFragment != null) {
      localContactsBaseFragment.d(true);
    }
    localContactsBaseFragment = a(paramInt2, false);
    if (localContactsBaseFragment != null) {
      localContactsBaseFragment.d(false);
    }
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, "refresh:" + paramInt);
    }
    ContactsBaseFragment localContactsBaseFragment = a(paramInt, false);
    if (localContactsBaseFragment != null) {
      localContactsBaseFragment.ap_();
    }
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, "doOnPause:" + paramInt);
    }
    ContactsBaseFragment localContactsBaseFragment = a(paramInt, false);
    if (localContactsBaseFragment != null) {
      localContactsBaseFragment.b(false);
    }
  }
  
  public int getCount()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Contacts.ContactsViewPagerAdapter", 2, "getCount. size:" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getItemPosition " + paramObject);
    paramObject = (ContactsBaseFragment)paramObject;
    if (paramObject != null)
    {
      int i = a(paramObject.a());
      if (i >= 0)
      {
        if (paramObject.b() == i)
        {
          QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getItemPosition POSITION_UNCHANGED");
          return -1;
        }
        QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getItemPosition newPos" + i + " oldPos:" + paramObject.b());
        paramObject.e(i);
        return i;
      }
    }
    QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getItemPosition POSITION_NONE");
    return -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */