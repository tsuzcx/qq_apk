package com.tencent.biz.qqcircle.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class QCirclePartManager
  extends PartManager
{
  public HashMap<String, String> a = new HashMap();
  
  public QCirclePartManager(BasePartFragment paramBasePartFragment, View paramView)
  {
    super(paramBasePartFragment, paramView);
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      localObject1 = (Part)this.d.get(localObject1);
      if (localObject1 != null)
      {
        long l = System.currentTimeMillis();
        ((Part)localObject1).onActivityCreated(paramActivity, paramBundle);
        ((Part)localObject1).a(this.c);
        Object localObject2 = this.a;
        String str = ((Part)localObject1).a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(System.currentTimeMillis() - l);
        localStringBuilder.append("|");
        ((HashMap)localObject2).put(str, localStringBuilder.toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("PartLifeCycleTime:");
        ((StringBuilder)localObject2).append(((Part)localObject1).a());
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onActivityCreated:");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
        QLog.d((String)localObject1, 4, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      localObject1 = (Part)this.d.get(localObject1);
      if (localObject1 != null)
      {
        long l = System.currentTimeMillis();
        ((Part)localObject1).onActivityDestroyed(paramActivity);
        if (this.a.get(((Part)localObject1).a()) != null)
        {
          localObject2 = this.a;
          String str = ((Part)localObject1).a();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)this.a.get(((Part)localObject1).a()));
          localStringBuilder.append(System.currentTimeMillis() - l);
          localStringBuilder.append("|");
          ((HashMap)localObject2).put(str, localStringBuilder.toString());
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("PartLifeCycleTime:");
        ((StringBuilder)localObject2).append(((Part)localObject1).a());
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onActivityDestroyed:");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
        QLog.d((String)localObject1, 4, ((StringBuilder)localObject2).toString());
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
      Object localObject1 = (String)localIterator.next();
      localObject1 = (Part)this.d.get(localObject1);
      if (localObject1 != null)
      {
        long l = System.currentTimeMillis();
        ((Part)localObject1).onActivityPaused(paramActivity);
        if (this.a.get(((Part)localObject1).a()) != null)
        {
          localObject2 = this.a;
          String str = ((Part)localObject1).a();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)this.a.get(((Part)localObject1).a()));
          localStringBuilder.append(System.currentTimeMillis() - l);
          localStringBuilder.append("|");
          ((HashMap)localObject2).put(str, localStringBuilder.toString());
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("PartLifeCycleTime:");
        ((StringBuilder)localObject2).append(((Part)localObject1).a());
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onActivityPaused:");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
        QLog.d((String)localObject1, 4, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      localObject1 = (Part)this.d.get(localObject1);
      if (localObject1 != null)
      {
        long l = System.currentTimeMillis();
        ((Part)localObject1).onActivityResumed(paramActivity);
        if (this.a.get(((Part)localObject1).a()) != null)
        {
          localObject2 = this.a;
          String str = ((Part)localObject1).a();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)this.a.get(((Part)localObject1).a()));
          localStringBuilder.append(System.currentTimeMillis() - l);
          localStringBuilder.append("|");
          ((HashMap)localObject2).put(str, localStringBuilder.toString());
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("PartLifeCycleTime:");
        ((StringBuilder)localObject2).append(((Part)localObject1).a());
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onActivityResumed:");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
        QLog.d((String)localObject1, 4, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      localObject1 = (Part)this.d.get(localObject1);
      if (localObject1 != null)
      {
        long l = System.currentTimeMillis();
        ((Part)localObject1).onActivityStarted(paramActivity);
        if (this.a.get(((Part)localObject1).a()) != null)
        {
          localObject2 = this.a;
          String str = ((Part)localObject1).a();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)this.a.get(((Part)localObject1).a()));
          localStringBuilder.append(System.currentTimeMillis() - l);
          localStringBuilder.append("|");
          ((HashMap)localObject2).put(str, localStringBuilder.toString());
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("PartLifeCycleTime:");
        ((StringBuilder)localObject2).append(((Part)localObject1).a());
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onActivityStarted:");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
        QLog.d((String)localObject1, 4, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      localObject1 = (Part)this.d.get(localObject1);
      if (localObject1 != null)
      {
        long l = System.currentTimeMillis();
        ((Part)localObject1).onActivityStopped(paramActivity);
        if (this.a.get(((Part)localObject1).a()) != null)
        {
          localObject2 = this.a;
          String str = ((Part)localObject1).a();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)this.a.get(((Part)localObject1).a()));
          localStringBuilder.append(System.currentTimeMillis() - l);
          localStringBuilder.append("|");
          ((HashMap)localObject2).put(str, localStringBuilder.toString());
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("PartLifeCycleTime:");
        ((StringBuilder)localObject2).append(((Part)localObject1).a());
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onActivityStopped:");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
        QLog.d((String)localObject1, 4, ((StringBuilder)localObject2).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCirclePartManager
 * JD-Core Version:    0.7.0.1
 */