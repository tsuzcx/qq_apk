package com.tencent.avgame.gamelogic.listener;

import android.app.Activity;
import java.lang.ref.WeakReference;

public abstract class GameActivityLifeCycleListener
{
  private int a = -1;
  private WeakReference<Activity> b;
  
  public void a()
  {
    this.a = 5;
  }
  
  public void a(int paramInt, Activity paramActivity)
  {
    WeakReference localWeakReference = this.b;
    if ((localWeakReference == null) || (localWeakReference.get() != paramActivity)) {
      this.b = new WeakReference(paramActivity);
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5)
              {
                a();
                return;
              }
              a();
              return;
            }
            g();
            return;
          }
          f();
          return;
        }
        e();
        return;
      }
      d();
      return;
    }
    c();
  }
  
  public Activity b()
  {
    WeakReference localWeakReference = this.b;
    if (localWeakReference != null) {
      return (Activity)localWeakReference.get();
    }
    return null;
  }
  
  public void c()
  {
    this.a = 0;
  }
  
  public void d()
  {
    this.a = 1;
  }
  
  public void e()
  {
    this.a = 2;
  }
  
  public void f()
  {
    this.a = 3;
  }
  
  public void g()
  {
    this.a = 4;
  }
  
  public boolean h()
  {
    int i = this.a;
    return (i == 5) || (i == -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.listener.GameActivityLifeCycleListener
 * JD-Core Version:    0.7.0.1
 */