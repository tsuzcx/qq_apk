package com.tencent.mobileqq.activity.contacts.base.tabs;

import android.util.SparseArray;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.activity.contacts.base.HeadViewScrollListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ContactsViewPagerAdapter
  extends CustomFragmentStatePagerAdapter
  implements ContactsBaseFragment.FragmentLifeListener
{
  protected int a;
  protected SparseArray<ContactsBaseFragment> a;
  protected ContactsBaseFragment.RefreshDataListener a;
  protected BaseActivity a;
  protected QQAppInterface a;
  protected ArrayList<TabInfo> a;
  private boolean a;
  protected int b;
  protected ArrayList<HeadViewScrollListener> b;
  
  public ContactsViewPagerAdapter(FragmentManager paramFragmentManager, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ArrayList<TabInfo> paramArrayList)
  {
    super(paramFragmentManager);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_Boolean = false;
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
      if (((TabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  protected ContactsBaseFragment a(int paramInt)
  {
    return (ContactsBaseFragment)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt, null);
  }
  
  public ContactsBaseFragment a(int paramInt, boolean paramBoolean)
  {
    TabInfo localTabInfo = a(paramInt);
    Object localObject2;
    Object localObject1;
    if (localTabInfo != null)
    {
      localObject2 = a(localTabInfo.c);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramBoolean)
        {
          localObject1 = ContactsFragmentFactory.a(localTabInfo.c);
          ((ContactsBaseFragment)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          ((ContactsBaseFragment)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          ((ContactsBaseFragment)localObject1).a(this);
          ((ContactsBaseFragment)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsBaseFragment$RefreshDataListener);
          ((ContactsBaseFragment)localObject1).e(paramInt);
          if ((localObject1 instanceof HeadViewScrollListener)) {
            this.jdField_b_of_type_JavaUtilArrayList.add((HeadViewScrollListener)localObject1);
          }
          this.jdField_a_of_type_AndroidUtilSparseArray.put(localTabInfo.c, localObject1);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getFragment ..... create ");
          ((StringBuilder)localObject2).append(paramInt);
          ((StringBuilder)localObject2).append("  ");
          ((StringBuilder)localObject2).append(localTabInfo.c);
          QLog.d("Contacts.ContactsViewPagerAdapter", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
    else
    {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getFragment ..... pos:");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("  id:");
      ((StringBuilder)localObject2).append(((ContactsBaseFragment)localObject1).a());
      ((StringBuilder)localObject2).append("  isDetached: ");
      ((StringBuilder)localObject2).append(((ContactsBaseFragment)localObject1).isDetached());
      ((StringBuilder)localObject2).append(" contactsViewPager:");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131365120));
      ((StringBuilder)localObject2).append("  isAdd: ");
      ((StringBuilder)localObject2).append(((ContactsBaseFragment)localObject1).isAdded());
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, ((StringBuilder)localObject2).toString());
    }
    if ((localObject1 != null) && ((localObject1 instanceof HeadViewScrollListener)))
    {
      paramInt = this.jdField_b_of_type_Int;
      if (paramInt > 0) {
        ((HeadViewScrollListener)localObject1).a(this.jdField_a_of_type_Int, paramInt);
      }
    }
    return localObject1;
  }
  
  protected TabInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return (TabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public BaseFragment a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getItem:");
      localStringBuilder.append(paramInt);
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, localStringBuilder.toString());
    }
    return a(paramInt, true);
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject = a(i);
      if (localObject != null)
      {
        localObject = a(((TabInfo)localObject).c);
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
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("remove fragment cache :");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("Contacts.ContactsViewPagerAdapter", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = a(paramInt);
      if (localObject != null)
      {
        ((ContactsBaseFragment)localObject).a();
        this.jdField_a_of_type_AndroidUtilSparseArray.delete(paramInt);
        this.jdField_b_of_type_JavaUtilArrayList.remove(localObject);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("headViewScrollChanged currentY:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("  maxY:");
      localStringBuilder.append(paramInt2);
      QLog.i("Contacts.ContactsViewPagerAdapter", 2, localStringBuilder.toString());
    }
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      ((HeadViewScrollListener)this.jdField_b_of_type_JavaUtilArrayList.get(i)).a(paramInt1, paramInt2);
      i += 1;
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnResume:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" tabChange:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramInt, false);
    if (localObject != null) {
      ((ContactsBaseFragment)localObject).a(false);
    }
  }
  
  public void a(ContactsBaseFragment.RefreshDataListener paramRefreshDataListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsBaseFragment$RefreshDataListener = paramRefreshDataListener;
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
          localObject = a(((TabInfo)localObject).c);
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
  
  public void a(ArrayList<TabInfo> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    c();
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("tabDatasUpdated. size:");
      paramArrayList.append(this.jdField_a_of_type_JavaUtilArrayList.size());
      QLog.i("Contacts.ContactsViewPagerAdapter", 2, paramArrayList.toString());
    }
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onThemeChange:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, ((StringBuilder)localObject).toString());
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject = a(i);
      if (localObject != null)
      {
        localObject = a(((TabInfo)localObject).c);
        if (localObject != null) {
          ((ContactsBaseFragment)localObject).b(paramBoolean, paramInt);
        }
      }
      i += 1;
    }
  }
  
  public void b()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnDestroy  mFragmentsCache.size() = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidUtilSparseArray.size());
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, ((StringBuilder)localObject).toString());
    }
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      localObject = (ContactsBaseFragment)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localObject != null) {
        ((ContactsBaseFragment)localObject).a();
      }
      i += 1;
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onFrameTabClick:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramInt, false);
    if (localObject != null) {
      ((ContactsBaseFragment)localObject).f();
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPageSelected. curPos:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" prePos:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramInt1, false);
    if (localObject != null) {
      ((ContactsBaseFragment)localObject).d(true);
    }
    localObject = a(paramInt2, false);
    if (localObject != null) {
      ((ContactsBaseFragment)localObject).d(false);
    }
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refresh:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramInt, false);
    if (localObject != null) {
      ((ContactsBaseFragment)localObject).ae_();
    }
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnPause:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramInt, false);
    if (localObject != null) {
      ((ContactsBaseFragment)localObject).b(false);
    }
  }
  
  public int getCount()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCount. size:");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList.size());
      QLog.i("Contacts.ContactsViewPagerAdapter", 2, localStringBuilder.toString());
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getItemPosition ");
    localStringBuilder.append(paramObject);
    QLog.d("Contacts.ContactsViewPagerAdapter", 2, localStringBuilder.toString());
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
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getItemPosition newPos");
        localStringBuilder.append(i);
        localStringBuilder.append(" oldPos:");
        localStringBuilder.append(paramObject.b());
        QLog.d("Contacts.ContactsViewPagerAdapter", 2, localStringBuilder.toString());
        paramObject.e(i);
        return i;
      }
    }
    QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getItemPosition POSITION_NONE");
    return -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */