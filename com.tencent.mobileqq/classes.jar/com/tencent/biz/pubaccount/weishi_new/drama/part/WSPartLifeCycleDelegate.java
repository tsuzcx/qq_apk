package com.tencent.biz.pubaccount.weishi_new.drama.part;

import java.util.HashSet;
import java.util.Iterator;

public class WSPartLifeCycleDelegate
  implements IWSPartLifeCycle
{
  private HashSet<IWSPartLifeCycle> a = new HashSet();
  
  public void a(HashSet<IWSPartLifeCycle> paramHashSet)
  {
    if (paramHashSet != null) {
      this.a.addAll(paramHashSet);
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((IWSPartLifeCycle)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((IWSPartLifeCycle)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((IWSPartLifeCycle)localIterator.next()).e();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((IWSPartLifeCycle)localIterator.next()).f();
    }
  }
  
  public void m()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((IWSPartLifeCycle)localIterator.next()).m();
    }
  }
  
  public void n()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((IWSPartLifeCycle)localIterator.next()).n();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.part.WSPartLifeCycleDelegate
 * JD-Core Version:    0.7.0.1
 */