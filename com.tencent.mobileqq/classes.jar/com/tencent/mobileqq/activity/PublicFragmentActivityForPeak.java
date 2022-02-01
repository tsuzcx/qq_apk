package com.tencent.mobileqq.activity;

import Override;
import aeow;
import aeox;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class PublicFragmentActivityForPeak
  extends PublicFragmentActivity
{
  private ArrayList<WeakReference<aeox>> a;
  
  public static void b(Context paramContext, Intent paramIntent, Class<? extends PublicBaseFragment> paramClass)
  {
    aeow.a(paramContext, paramIntent, PublicFragmentActivityForPeak.class, paramClass);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnBackPressed()
  {
    Object localObject1 = super.a();
    if ((localObject1 instanceof aeox))
    {
      if (this.a == null) {
        this.a = new ArrayList(2);
      }
      this.a.add(new WeakReference((aeox)localObject1));
    }
    if (this.a != null)
    {
      localObject1 = this.a.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (WeakReference)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = (aeox)((WeakReference)localObject2).get();
          if (localObject2 != null) {
            ((aeox)localObject2).onBackPressed();
          }
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.getIntent().putExtra("fling_action_key", 0);
    return super.doOnCreate(paramBundle);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicFragmentActivityForPeak
 * JD-Core Version:    0.7.0.1
 */