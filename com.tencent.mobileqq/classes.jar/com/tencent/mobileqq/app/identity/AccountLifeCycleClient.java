package com.tencent.mobileqq.app.identity;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class AccountLifeCycleClient
  implements IAccountLifecycle
{
  private static final AccountLifeCycleClient a;
  public List<IAccountLifecycle> a;
  protected AtomicBoolean a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqAppIdentityAccountLifeCycleClient = new AccountLifeCycleClient();
  }
  
  private AccountLifeCycleClient()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
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
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
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
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void af_()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((IAccountLifecycle)localIterator.next()).af_();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((IAccountLifecycle)localIterator.next()).b();
    }
  }
  
  public void b(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((IAccountLifecycle)localIterator.next()).b(paramActivity);
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((IAccountLifecycle)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((IAccountLifecycle)localIterator.next()).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.AccountLifeCycleClient
 * JD-Core Version:    0.7.0.1
 */