package com.huawei.hms.adapter.sysobs;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class SystemManager$1
  implements SystemNotifier
{
  private final List<SystemObserver> a = new ArrayList();
  
  public void notifyObservers(int paramInt)
  {
    synchronized ()
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        if (((SystemObserver)localIterator.next()).onUpdateResult(paramInt)) {
          localIterator.remove();
        }
      }
    }
  }
  
  public void notifyObservers(Intent paramIntent, String paramString)
  {
    synchronized ()
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        if (((SystemObserver)localIterator.next()).onSolutionResult(paramIntent, paramString)) {
          localIterator.remove();
        }
      }
    }
  }
  
  public void registerObserver(SystemObserver paramSystemObserver)
  {
    if (paramSystemObserver == null) {}
    while (this.a.contains(paramSystemObserver)) {
      return;
    }
    synchronized (SystemManager.a())
    {
      this.a.add(paramSystemObserver);
      return;
    }
  }
  
  public void unRegisterObserver(SystemObserver paramSystemObserver)
  {
    synchronized ()
    {
      this.a.remove(paramSystemObserver);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.adapter.sysobs.SystemManager.1
 * JD-Core Version:    0.7.0.1
 */