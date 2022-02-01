package com.bumptech.glide.manager;

import android.support.annotation.NonNull;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public final class TargetTracker
  implements LifecycleListener
{
  private final Set<Target<?>> a = Collections.newSetFromMap(new WeakHashMap());
  
  @NonNull
  public List<Target<?>> a()
  {
    return Util.a(this.a);
  }
  
  public void a(@NonNull Target<?> paramTarget)
  {
    this.a.add(paramTarget);
  }
  
  public void b()
  {
    this.a.clear();
  }
  
  public void b(@NonNull Target<?> paramTarget)
  {
    this.a.remove(paramTarget);
  }
  
  public void c()
  {
    Iterator localIterator = Util.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((Target)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    Iterator localIterator = Util.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((Target)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    Iterator localIterator = Util.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((Target)localIterator.next()).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.manager.TargetTracker
 * JD-Core Version:    0.7.0.1
 */