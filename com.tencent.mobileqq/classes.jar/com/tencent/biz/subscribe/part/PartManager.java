package com.tencent.biz.subscribe.part;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class PartManager
  implements Application.ActivityLifecycleCallbacks
{
  private BasePartFragment a;
  private View b;
  private final LinkedHashMap<String, Part> c = new LinkedHashMap();
  
  public PartManager(BasePartFragment paramBasePartFragment, View paramView)
  {
    this.a = paramBasePartFragment;
    this.b = paramView;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Part)this.c.get(localObject);
      if (localObject != null) {
        ((Part)localObject).a(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Part)this.c.get(localObject);
      if (localObject != null) {
        ((Part)localObject).a(paramConfiguration);
      }
    }
  }
  
  public void a(View paramView)
  {
    this.b = paramView;
  }
  
  public void a(List<Part> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Part localPart = (Part)paramList.next();
      localPart.a(this.a, this.b, this);
      this.c.put(localPart.getClass().getSimpleName(), localPart);
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Part)this.c.get(localObject);
      if ((localObject != null) && (((Part)localObject).c())) {
        return true;
      }
    }
    return false;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Part)this.c.get(localObject);
      if (localObject != null)
      {
        ((Part)localObject).onActivityCreated(paramActivity, paramBundle);
        ((Part)localObject).a(this.b);
      }
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Part)this.c.get(localObject);
      if (localObject != null) {
        ((Part)localObject).onActivityDestroyed(paramActivity);
      }
    }
    this.c.clear();
    this.a = null;
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Part)this.c.get(localObject);
      if (localObject != null) {
        ((Part)localObject).onActivityPaused(paramActivity);
      }
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    paramActivity = this.c.keySet().iterator();
    while (paramActivity.hasNext())
    {
      Object localObject = (String)paramActivity.next();
      localObject = (Part)this.c.get(localObject);
      if (localObject != null) {
        ((Part)localObject).onActivityResumed(this.a.getBaseActivity());
      }
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Part)this.c.get(localObject);
      if (localObject != null) {
        ((Part)localObject).onActivityStarted(paramActivity);
      }
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Part)this.c.get(localObject);
      if (localObject != null) {
        ((Part)localObject).onActivityStopped(paramActivity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.PartManager
 * JD-Core Version:    0.7.0.1
 */