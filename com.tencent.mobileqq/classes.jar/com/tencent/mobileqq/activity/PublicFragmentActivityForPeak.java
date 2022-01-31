package com.tencent.mobileqq.activity;

import abtu;
import abtv;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class PublicFragmentActivityForPeak
  extends PublicFragmentActivity
{
  private ArrayList<WeakReference<abtv>> a;
  
  public static void b(Context paramContext, Intent paramIntent, Class<? extends PublicBaseFragment> paramClass)
  {
    abtu.a(paramContext, paramIntent, PublicFragmentActivityForPeak.class, paramClass);
  }
  
  public void doOnBackPressed()
  {
    Object localObject1 = super.a();
    if ((localObject1 instanceof abtv))
    {
      if (this.a == null) {
        this.a = new ArrayList(2);
      }
      this.a.add(new WeakReference((abtv)localObject1));
    }
    if (this.a != null)
    {
      localObject1 = this.a.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (WeakReference)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = (abtv)((WeakReference)localObject2).get();
          if (localObject2 != null) {
            ((abtv)localObject2).onBackPressed();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicFragmentActivityForPeak
 * JD-Core Version:    0.7.0.1
 */