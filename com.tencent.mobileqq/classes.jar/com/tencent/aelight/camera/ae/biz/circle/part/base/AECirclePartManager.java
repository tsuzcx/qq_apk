package com.tencent.aelight.camera.ae.biz.circle.part.base;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class AECirclePartManager
  implements Application.ActivityLifecycleCallbacks
{
  private AECircleBasePartFragment a;
  private View b;
  private final LinkedHashMap<String, AECircleBasePart> c = new LinkedHashMap();
  
  public AECirclePartManager(AECircleBasePartFragment paramAECircleBasePartFragment, View paramView)
  {
    this.a = paramAECircleBasePartFragment;
    this.b = paramView;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (AECircleBasePart)this.c.get(localObject);
      if (localObject != null) {
        ((AECircleBasePart)localObject).a(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (AECircleBasePart)this.c.get(localObject);
      if (localObject != null) {
        ((AECircleBasePart)localObject).a(paramConfiguration);
      }
    }
  }
  
  public void a(View paramView)
  {
    this.b = paramView;
  }
  
  public void a(List<AECircleBasePart> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      AECircleBasePart localAECircleBasePart = (AECircleBasePart)paramList.next();
      localAECircleBasePart.a(this.a, this.b, this);
      this.c.put(localAECircleBasePart.getClass().getSimpleName(), localAECircleBasePart);
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (AECircleBasePart)this.c.get(localObject);
      if ((localObject != null) && (((AECircleBasePart)localObject).am_())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean b()
  {
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (AECircleBasePart)this.c.get(localObject);
      if ((localObject != null) && (!((AECircleBasePart)localObject).a())) {
        return false;
      }
    }
    return true;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (AECircleBasePart)this.c.get(localObject);
      if (localObject != null)
      {
        ((AECircleBasePart)localObject).onActivityCreated(paramActivity, paramBundle);
        ((AECircleBasePart)localObject).a(this.b);
      }
    }
    paramActivity = new StringBuilder();
    paramActivity.append("onActivityCreated cost:");
    paramActivity.append(System.currentTimeMillis() - l);
    QLog.d("[Performance2]", 1, paramActivity.toString());
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (AECircleBasePart)this.c.get(localObject);
      if (localObject != null) {
        ((AECircleBasePart)localObject).onActivityDestroyed(paramActivity);
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
      localObject = (AECircleBasePart)this.c.get(localObject);
      if (localObject != null) {
        ((AECircleBasePart)localObject).onActivityPaused(paramActivity);
      }
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    paramActivity = this.c.keySet().iterator();
    while (paramActivity.hasNext())
    {
      Object localObject = (String)paramActivity.next();
      localObject = (AECircleBasePart)this.c.get(localObject);
      if (localObject != null) {
        ((AECircleBasePart)localObject).onActivityResumed(this.a.getActivity());
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
      localObject = (AECircleBasePart)this.c.get(localObject);
      if (localObject != null) {
        ((AECircleBasePart)localObject).onActivityStarted(paramActivity);
      }
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (AECircleBasePart)this.c.get(localObject);
      if (localObject != null) {
        ((AECircleBasePart)localObject).onActivityStopped(paramActivity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.base.AECirclePartManager
 * JD-Core Version:    0.7.0.1
 */