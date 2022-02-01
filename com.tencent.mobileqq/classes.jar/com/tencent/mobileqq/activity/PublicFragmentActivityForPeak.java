package com.tencent.mobileqq.activity;

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
  private ArrayList<WeakReference<PublicFragmentActivityCallBackInterface>> a;
  
  public static void b(Context paramContext, Intent paramIntent, Class<? extends PublicBaseFragment> paramClass)
  {
    PublicFragmentActivity.Launcher.a(paramContext, paramIntent, PublicFragmentActivityForPeak.class, paramClass);
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
    if ((localObject1 instanceof PublicFragmentActivityCallBackInterface))
    {
      if (this.a == null) {
        this.a = new ArrayList(2);
      }
      this.a.add(new WeakReference((PublicFragmentActivityCallBackInterface)localObject1));
    }
    localObject1 = this.a;
    if (localObject1 != null)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (WeakReference)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = (PublicFragmentActivityCallBackInterface)((WeakReference)localObject2).get();
          if (localObject2 != null) {
            ((PublicFragmentActivityCallBackInterface)localObject2).onBackPressed();
          }
        }
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicFragmentActivityForPeak
 * JD-Core Version:    0.7.0.1
 */