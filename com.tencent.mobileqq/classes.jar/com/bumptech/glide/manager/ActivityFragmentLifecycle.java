package com.bumptech.glide.manager;

import android.support.annotation.NonNull;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

class ActivityFragmentLifecycle
  implements Lifecycle
{
  private final Set<LifecycleListener> a = Collections.newSetFromMap(new WeakHashMap());
  private boolean b;
  private boolean c;
  
  void a()
  {
    this.b = true;
    Iterator localIterator = Util.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((LifecycleListener)localIterator.next()).c();
    }
  }
  
  public void a(@NonNull LifecycleListener paramLifecycleListener)
  {
    this.a.add(paramLifecycleListener);
    if (this.c)
    {
      paramLifecycleListener.e();
      return;
    }
    if (this.b)
    {
      paramLifecycleListener.c();
      return;
    }
    paramLifecycleListener.d();
  }
  
  void b()
  {
    this.b = false;
    Iterator localIterator = Util.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((LifecycleListener)localIterator.next()).d();
    }
  }
  
  public void b(@NonNull LifecycleListener paramLifecycleListener)
  {
    this.a.remove(paramLifecycleListener);
  }
  
  void c()
  {
    this.c = true;
    Iterator localIterator = Util.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((LifecycleListener)localIterator.next()).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.manager.ActivityFragmentLifecycle
 * JD-Core Version:    0.7.0.1
 */