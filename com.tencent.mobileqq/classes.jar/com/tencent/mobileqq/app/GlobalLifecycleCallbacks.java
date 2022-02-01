package com.tencent.mobileqq.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks;
import java.util.ArrayList;

public class GlobalLifecycleCallbacks
{
  private final ArrayList<BaseActivityLifecycleCallbacks> a = new ArrayList();
  
  private Object[] a()
  {
    for (;;)
    {
      synchronized (this.a)
      {
        if (this.a.size() > 0)
        {
          Object[] arrayOfObject = this.a.toArray();
          return arrayOfObject;
        }
      }
      Object localObject2 = null;
    }
  }
  
  void a(Activity paramActivity)
  {
    Object[] arrayOfObject = a();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnActivityOnStart(paramActivity);
        i += 1;
      }
    }
  }
  
  void a(Activity paramActivity, Intent paramIntent)
  {
    Object[] arrayOfObject = a();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnNewIntent(paramActivity, paramIntent);
        i += 1;
      }
    }
  }
  
  void a(Activity paramActivity, Bundle paramBundle)
  {
    Object[] arrayOfObject = a();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnActivityPostCreated(paramActivity, paramBundle);
        i += 1;
      }
    }
  }
  
  void a(Activity paramActivity, boolean paramBoolean)
  {
    Object[] arrayOfObject = a();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnWindowFocusChanged(paramActivity, paramBoolean);
        i += 1;
      }
    }
  }
  
  void a(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    Object[] arrayOfObject = a();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnActivityPreCreated(paramQBaseActivity, paramBundle);
        i += 1;
      }
    }
  }
  
  public void a(BaseActivityLifecycleCallbacks paramBaseActivityLifecycleCallbacks)
  {
    synchronized (this.a)
    {
      this.a.add(paramBaseActivityLifecycleCallbacks);
      return;
    }
  }
  
  void b(Activity paramActivity)
  {
    Object[] arrayOfObject = a();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnActivityPreResumed(paramActivity);
        i += 1;
      }
    }
  }
  
  void b(Activity paramActivity, boolean paramBoolean)
  {
    Object[] arrayOfObject = a();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).onMultiWindowModeChanged(paramActivity, paramBoolean);
        i += 1;
      }
    }
  }
  
  void b(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    Object[] arrayOfObject = a();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnActivityCreate(paramQBaseActivity, paramBundle);
        i += 1;
      }
    }
  }
  
  void c(Activity paramActivity)
  {
    Object[] arrayOfObject = a();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnActivityResume(paramActivity);
        i += 1;
      }
    }
  }
  
  void d(Activity paramActivity)
  {
    Object[] arrayOfObject = a();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnActivityPostResumed(paramActivity);
        i += 1;
      }
    }
  }
  
  void e(Activity paramActivity)
  {
    Object[] arrayOfObject = a();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnActivityPrePaused(paramActivity);
        i += 1;
      }
    }
  }
  
  void f(Activity paramActivity)
  {
    Object[] arrayOfObject = a();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnActivityPause(paramActivity);
        i += 1;
      }
    }
  }
  
  void g(Activity paramActivity)
  {
    Object[] arrayOfObject = a();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnActivityPostPaused(paramActivity);
        i += 1;
      }
    }
  }
  
  void h(Activity paramActivity)
  {
    Object[] arrayOfObject = a();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnActivityStopped(paramActivity);
        i += 1;
      }
    }
  }
  
  void i(Activity paramActivity)
  {
    Object[] arrayOfObject = a();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnActivityDestroyed(paramActivity);
        i += 1;
      }
    }
  }
  
  void j(Activity paramActivity)
  {
    Object[] arrayOfObject = a();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).onPostThemeChanged(paramActivity);
        i += 1;
      }
    }
  }
  
  void k(Activity paramActivity)
  {
    Object[] arrayOfObject = a();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).onAccountChanged(paramActivity);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.GlobalLifecycleCallbacks
 * JD-Core Version:    0.7.0.1
 */