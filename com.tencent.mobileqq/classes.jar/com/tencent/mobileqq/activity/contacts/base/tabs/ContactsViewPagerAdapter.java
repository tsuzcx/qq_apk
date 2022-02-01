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
  protected SparseArray<ContactsBaseFragment> a = new SparseArray();
  protected ContactsBaseFragment.RefreshDataListener b;
  protected QQAppInterface c;
  protected BaseActivity d;
  protected ArrayList<TabInfo> e = new ArrayList();
  protected ArrayList<HeadViewScrollListener> f = new ArrayList();
  protected int g = -1;
  protected int h = -1;
  private boolean i = false;
  
  public ContactsViewPagerAdapter(FragmentManager paramFragmentManager, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ArrayList<TabInfo> paramArrayList)
  {
    super(paramFragmentManager);
    this.c = paramQQAppInterface;
    this.d = paramBaseActivity;
    this.e.clear();
    this.e.addAll(paramArrayList);
  }
  
  public ContactsBaseFragment a(int paramInt, boolean paramBoolean)
  {
    TabInfo localTabInfo = c(paramInt);
    Object localObject2;
    Object localObject1;
    if (localTabInfo != null)
    {
      localObject2 = f(localTabInfo.j);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramBoolean)
        {
          localObject1 = ContactsFragmentFactory.a(localTabInfo.j);
          ((ContactsBaseFragment)localObject1).a(this.d);
          ((ContactsBaseFragment)localObject1).a(this.c);
          ((ContactsBaseFragment)localObject1).a(this);
          ((ContactsBaseFragment)localObject1).a(this.b);
          ((ContactsBaseFragment)localObject1).e(paramInt);
          if ((localObject1 instanceof HeadViewScrollListener)) {
            this.f.add((HeadViewScrollListener)localObject1);
          }
          this.a.put(localTabInfo.j, localObject1);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getFragment ..... create ");
          ((StringBuilder)localObject2).append(paramInt);
          ((StringBuilder)localObject2).append("  ");
          ((StringBuilder)localObject2).append(localTabInfo.j);
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
      ((StringBuilder)localObject2).append(((ContactsBaseFragment)localObject1).h());
      ((StringBuilder)localObject2).append("  isDetached: ");
      ((StringBuilder)localObject2).append(((ContactsBaseFragment)localObject1).isDetached());
      ((StringBuilder)localObject2).append(" contactsViewPager:");
      ((StringBuilder)localObject2).append(this.d.findViewById(2131431267));
      ((StringBuilder)localObject2).append("  isAdd: ");
      ((StringBuilder)localObject2).append(((ContactsBaseFragment)localObject1).isAdded());
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, ((StringBuilder)localObject2).toString());
    }
    if ((localObject1 != null) && ((localObject1 instanceof HeadViewScrollListener)))
    {
      paramInt = this.h;
      if (paramInt > 0) {
        ((HeadViewScrollListener)localObject1).a(this.g, paramInt);
      }
    }
    return localObject1;
  }
  
  public void a()
  {
    int j = 0;
    while (j < this.e.size())
    {
      Object localObject = c(j);
      if (localObject != null)
      {
        localObject = f(((TabInfo)localObject).j);
        if (localObject != null) {
          ((ContactsBaseFragment)localObject).g();
        }
      }
      j += 1;
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
      Object localObject = f(paramInt);
      if (localObject != null)
      {
        ((ContactsBaseFragment)localObject).a();
        this.a.delete(paramInt);
        this.f.remove(localObject);
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
    int j = 0;
    while (j < this.f.size())
    {
      ((HeadViewScrollListener)this.f.get(j)).a(paramInt1, paramInt2);
      j += 1;
    }
    this.g = paramInt1;
    this.h = paramInt2;
  }
  
  public void a(ContactsBaseFragment.RefreshDataListener paramRefreshDataListener)
  {
    this.b = paramRefreshDataListener;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.c != paramQQAppInterface)
    {
      this.c = paramQQAppInterface;
      int j = 0;
      while (j < this.e.size())
      {
        Object localObject = c(j);
        if (localObject != null)
        {
          localObject = f(((TabInfo)localObject).j);
          if (localObject != null)
          {
            ((ContactsBaseFragment)localObject).a(paramQQAppInterface);
            ((ContactsBaseFragment)localObject).c();
          }
        }
        j += 1;
      }
    }
  }
  
  public void a(ArrayList<TabInfo> paramArrayList)
  {
    this.e.clear();
    this.e.addAll(paramArrayList);
    c();
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("tabDatasUpdated. size:");
      paramArrayList.append(this.e.size());
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
    int j = 0;
    while (j < this.e.size())
    {
      localObject = c(j);
      if (localObject != null)
      {
        localObject = f(((TabInfo)localObject).j);
        if (localObject != null) {
          ((ContactsBaseFragment)localObject).b(paramBoolean, paramInt);
        }
      }
      j += 1;
    }
  }
  
  public BaseFragment b(int paramInt)
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
  
  public void b()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnDestroy  mFragmentsCache.size() = ");
      ((StringBuilder)localObject).append(this.a.size());
      QLog.d("Contacts.ContactsViewPagerAdapter", 2, ((StringBuilder)localObject).toString());
    }
    int j = 0;
    while (j < this.a.size())
    {
      localObject = (ContactsBaseFragment)this.a.valueAt(j);
      if (localObject != null) {
        ((ContactsBaseFragment)localObject).a();
      }
      j += 1;
    }
    this.a.clear();
    this.f.clear();
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
  
  public void b(int paramInt, boolean paramBoolean)
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
  
  protected TabInfo c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.e.size())) {
      return (TabInfo)this.e.get(paramInt);
    }
    return null;
  }
  
  protected int d(int paramInt)
  {
    int j = 0;
    while (j < this.e.size())
    {
      if (((TabInfo)this.e.get(j)).j == paramInt) {
        return j;
      }
      j += 1;
    }
    return -1;
  }
  
  public void e(int paramInt)
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
  
  protected ContactsBaseFragment f(int paramInt)
  {
    return (ContactsBaseFragment)this.a.get(paramInt, null);
  }
  
  public void g(int paramInt)
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
      ((ContactsBaseFragment)localObject).bU_();
    }
  }
  
  public int getCount()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCount. size:");
      localStringBuilder.append(this.e.size());
      QLog.i("Contacts.ContactsViewPagerAdapter", 2, localStringBuilder.toString());
    }
    return this.e.size();
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
      int j = d(paramObject.h());
      if (j >= 0)
      {
        if (paramObject.i() == j)
        {
          QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getItemPosition POSITION_UNCHANGED");
          return -1;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getItemPosition newPos");
        localStringBuilder.append(j);
        localStringBuilder.append(" oldPos:");
        localStringBuilder.append(paramObject.i());
        QLog.d("Contacts.ContactsViewPagerAdapter", 2, localStringBuilder.toString());
        paramObject.e(j);
        return j;
      }
    }
    QLog.d("Contacts.ContactsViewPagerAdapter", 2, "getItemPosition POSITION_NONE");
    return -2;
  }
  
  public void h(int paramInt)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */