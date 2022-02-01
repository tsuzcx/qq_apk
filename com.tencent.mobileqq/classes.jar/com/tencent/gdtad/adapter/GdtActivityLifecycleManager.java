package com.tencent.gdtad.adapter;

import com.tencent.ad.tangram.util.AdLifecycleManager;
import mqq.app.Foreground;

public final class GdtActivityLifecycleManager
{
  private static volatile GdtActivityLifecycleManager a;
  
  public static GdtActivityLifecycleManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new GdtActivityLifecycleManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void b()
  {
    Foreground.addActivityLifeCallback(new GdtActivityLifecycleManager.GdtActivityLifecycleCallback());
    AdLifecycleManager.INSTANCE.setOnForeground(Foreground.isCurrentProcessForeground());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtActivityLifecycleManager
 * JD-Core Version:    0.7.0.1
 */