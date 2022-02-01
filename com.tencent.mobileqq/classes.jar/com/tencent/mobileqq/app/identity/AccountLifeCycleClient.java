package com.tencent.mobileqq.app.identity;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class AccountLifeCycleClient
  implements IAccountLifecycle
{
  private static final AccountLifeCycleClient c = new AccountLifeCycleClient();
  public List<IAccountLifecycle> a = new ArrayList();
  protected AtomicBoolean b = new AtomicBoolean(true);
  
  private AccountLifeCycleClient()
  {
    this.a.add(new AccountPhoneUnityManager());
    this.a.add(AccountIdentityManager.a());
    this.a.add(new DelayReportManager());
  }
  
  public static AccountLifeCycleClient a()
  {
    return c;
  }
  
  public IAccountLifecycle a(Class<? extends IAccountLifecycle> paramClass)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      IAccountLifecycle localIAccountLifecycle = (IAccountLifecycle)localIterator.next();
      if (localIAccountLifecycle.getClass() == paramClass) {
        return localIAccountLifecycle;
      }
    }
    return null;
  }
  
  public void a(Activity paramActivity)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((IAccountLifecycle)localIterator.next()).a(paramActivity);
    }
  }
  
  public void b()
  {
    this.b.set(false);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((IAccountLifecycle)localIterator.next()).b();
    }
  }
  
  public void b(Activity paramActivity)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((IAccountLifecycle)localIterator.next()).b(paramActivity);
    }
  }
  
  public void bX_()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((IAccountLifecycle)localIterator.next()).bX_();
    }
  }
  
  public void c()
  {
    this.b.set(false);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((IAccountLifecycle)localIterator.next()).c();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((IAccountLifecycle)localIterator.next()).e();
    }
  }
  
  public void f()
  {
    this.b.set(true);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((IAccountLifecycle)localIterator.next()).f();
    }
  }
  
  public boolean g()
  {
    return this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.AccountLifeCycleClient
 * JD-Core Version:    0.7.0.1
 */