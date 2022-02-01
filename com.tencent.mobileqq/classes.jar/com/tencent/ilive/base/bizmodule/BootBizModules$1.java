package com.tencent.ilive.base.bizmodule;

import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ilive.uicomponent.PageLifeCycle;
import java.util.Iterator;
import java.util.Set;

class BootBizModules$1
  implements PageLifeCycle
{
  BootBizModules$1(BootBizModules paramBootBizModules) {}
  
  private boolean a()
  {
    return (this.a.bizModules == null) || (this.a.bizModules.isEmpty());
  }
  
  public void onActivityCreate(LifecycleOwner paramLifecycleOwner)
  {
    if (!a())
    {
      Iterator localIterator = this.a.bizModules.iterator();
      while (localIterator.hasNext()) {
        ((BaseBizModule)localIterator.next()).onRealActivityCreate(paramLifecycleOwner);
      }
    }
  }
  
  public void onActivityDestroy(LifecycleOwner paramLifecycleOwner)
  {
    if (!a())
    {
      Iterator localIterator = this.a.bizModules.iterator();
      while (localIterator.hasNext()) {
        ((BaseBizModule)localIterator.next()).onRealActivityDestroy(paramLifecycleOwner);
      }
    }
  }
  
  public void onActivityPause(LifecycleOwner paramLifecycleOwner)
  {
    if (!a())
    {
      Iterator localIterator = this.a.bizModules.iterator();
      while (localIterator.hasNext()) {
        ((BaseBizModule)localIterator.next()).onRealActivityPause(paramLifecycleOwner);
      }
    }
  }
  
  public void onActivityResume(LifecycleOwner paramLifecycleOwner)
  {
    if (!a())
    {
      Iterator localIterator = this.a.bizModules.iterator();
      while (localIterator.hasNext()) {
        ((BaseBizModule)localIterator.next()).onRealActivityResume(paramLifecycleOwner);
      }
    }
  }
  
  public void onActivityStart(LifecycleOwner paramLifecycleOwner)
  {
    if (!a())
    {
      Iterator localIterator = this.a.bizModules.iterator();
      while (localIterator.hasNext()) {
        ((BaseBizModule)localIterator.next()).onRealActivityStart(paramLifecycleOwner);
      }
    }
  }
  
  public void onActivityStop(LifecycleOwner paramLifecycleOwner)
  {
    if (!a())
    {
      Iterator localIterator = this.a.bizModules.iterator();
      while (localIterator.hasNext()) {
        ((BaseBizModule)localIterator.next()).onRealActivityStop(paramLifecycleOwner);
      }
    }
  }
  
  public void onLifecycleChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.base.bizmodule.BootBizModules.1
 * JD-Core Version:    0.7.0.1
 */