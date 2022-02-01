package com.tencent.mobileqq.app.identity;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccountLifeCycleClient
  implements IAccountLifecycle
{
  private static final AccountLifeCycleClient a;
  public List<IAccountLifecycle> a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqAppIdentityAccountLifeCycleClient = new AccountLifeCycleClient();
  }
  
  private AccountLifeCycleClient()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new AccountPhoneUnityManager());
    this.jdField_a_of_type_JavaUtilList.add(AccountIdentityManager.a());
    this.jdField_a_of_type_JavaUtilList.add(new DelayReportManager());
  }
  
  public static AccountLifeCycleClient a()
  {
    return jdField_a_of_type_ComTencentMobileqqAppIdentityAccountLifeCycleClient;
  }
  
  public IAccountLifecycle a(Class<? extends IAccountLifecycle> paramClass)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      IAccountLifecycle localIAccountLifecycle = (IAccountLifecycle)localIterator.next();
      if (localIAccountLifecycle.getClass() == paramClass) {
        return localIAccountLifecycle;
      }
    }
    return null;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((IAccountLifecycle)localIterator.next()).a();
    }
  }
  
  public void a(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((IAccountLifecycle)localIterator.next()).a(paramActivity);
    }
  }
  
  public void am_()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((IAccountLifecycle)localIterator.next()).am_();
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((IAccountLifecycle)localIterator.next()).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.AccountLifeCycleClient
 * JD-Core Version:    0.7.0.1
 */