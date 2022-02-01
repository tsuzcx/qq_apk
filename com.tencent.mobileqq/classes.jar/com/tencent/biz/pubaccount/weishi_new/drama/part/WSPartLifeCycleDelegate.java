package com.tencent.biz.pubaccount.weishi_new.drama.part;

import java.util.HashSet;
import java.util.Iterator;

public class WSPartLifeCycleDelegate
  implements IWSPartLifeCycle
{
  private HashSet<IWSPartLifeCycle> a = new HashSet();
  
  public void E_()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((IWSPartLifeCycle)localIterator.next()).E_();
    }
  }
  
  public void F_()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((IWSPartLifeCycle)localIterator.next()).F_();
    }
  }
  
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
  
  public void h()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((IWSPartLifeCycle)localIterator.next()).h();
    }
  }
  
  public void i()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((IWSPartLifeCycle)localIterator.next()).i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.part.WSPartLifeCycleDelegate
 * JD-Core Version:    0.7.0.1
 */