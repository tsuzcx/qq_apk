package com.tencent.biz.richframework.part;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class PartManager
  implements Application.ActivityLifecycleCallbacks
{
  protected IPartHost b;
  protected View c;
  protected final LinkedHashMap<String, Part> d = new LinkedHashMap();
  protected final ArrayList<PartManager> e = new ArrayList();
  
  public PartManager(IPartHost paramIPartHost, View paramView)
  {
    this.b = paramIPartHost;
    this.c = paramView;
  }
  
  private void c(String paramString, Object paramObject)
  {
    Object localObject = this.e;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = this.e.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((PartManager)((Iterator)localObject).next()).a(paramString, paramObject);
      }
    }
  }
  
  public Part a(String paramString)
  {
    return (Part)this.d.get(paramString);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Part)this.d.get(localObject);
      if (localObject != null) {
        ((Part)localObject).a(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Part)this.d.get(localObject);
      if (localObject != null) {
        ((Part)localObject).a(paramConfiguration);
      }
    }
  }
  
  public void a(View paramView)
  {
    this.c = paramView;
  }
  
  public void a(PartManager paramPartManager)
  {
    ArrayList localArrayList = this.e;
    if (localArrayList != null) {
      localArrayList.add(paramPartManager);
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Part)this.d.get(localObject);
      if (localObject != null) {
        ((Part)localObject).a(paramString, paramObject);
      }
    }
    c(paramString, paramObject);
  }
  
  public void a(List<Part> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Part localPart = (Part)paramList.next();
      localPart.a(this.b, this.c, this);
      if ((this.d.get(localPart.getClass().getName()) != null) && (RFApplication.isDebug())) {
        throw new RuntimeException("you can not register Same Class Part");
      }
      this.d.put(localPart.getClass().getName(), localPart);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Part)this.d.get(localObject);
      if (localObject != null) {
        ((Part)localObject).e_(paramBoolean);
      }
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Part)this.d.get(localObject);
      if ((localObject != null) && (((Part)localObject).ah_())) {
        return true;
      }
    }
    return false;
  }
  
  public Object b(String paramString, Object paramObject)
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Part)this.d.get(localObject);
      if (localObject != null)
      {
        localObject = ((Part)localObject).b(paramString, paramObject);
        if (localObject != null) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  public void b()
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Part)this.d.get(localObject);
      if (localObject != null) {
        ((Part)localObject).h();
      }
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Part)this.d.get(localObject);
      if (localObject != null) {
        ((Part)localObject).k();
      }
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Part)this.d.get(localObject);
      if (localObject != null)
      {
        ((Part)localObject).onActivityCreated(paramActivity, paramBundle);
        ((Part)localObject).a(this.c);
      }
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Part)this.d.get(localObject);
      if (localObject != null) {
        ((Part)localObject).onActivityDestroyed(paramActivity);
      }
    }
    this.d.clear();
    this.b = null;
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Part)this.d.get(localObject);
      if (localObject != null) {
        ((Part)localObject).onActivityPaused(paramActivity);
      }
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Part)this.d.get(localObject);
      if (localObject != null) {
        ((Part)localObject).onActivityResumed(paramActivity);
      }
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Part)this.d.get(localObject);
      if (localObject != null) {
        ((Part)localObject).onActivityStarted(paramActivity);
      }
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Part)this.d.get(localObject);
      if (localObject != null)
      {
        System.currentTimeMillis();
        ((Part)localObject).onActivityStopped(paramActivity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.PartManager
 * JD-Core Version:    0.7.0.1
 */