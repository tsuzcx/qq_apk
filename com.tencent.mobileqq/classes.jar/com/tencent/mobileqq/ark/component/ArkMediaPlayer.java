package com.tencent.mobileqq.ark.component;

import com.tencent.ark.ArkPlayer;
import com.tencent.ark.ark.PlayerStubFactory;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mqq.app.Foreground;
import mqq.app.QActivityLifecycleCallbacks;

public class ArkMediaPlayer
  extends ArkPlayer
{
  static final QActivityLifecycleCallbacks a = new ArkMediaPlayer.1();
  public static final ark.PlayerStubFactory b = new ArkMediaPlayer.2();
  private static final Set<WeakReference<ArkMediaPlayer>> j = Collections.synchronizedSet(new HashSet());
  private boolean c = true;
  private final int d = 0;
  private final int e = 1;
  private final int f = 2;
  private final int g = 3;
  private final int h = 4;
  private int i = 0;
  
  static
  {
    Foreground.addActivityLifeCallback(a);
  }
  
  protected ArkMediaPlayer()
  {
    j.add(new WeakReference(this));
    QLog.i("Ark.ArkMediaPlayer", 1, String.format("ArkMediaPlayer.create.%h", new Object[] { this }));
  }
  
  public static void a()
  {
    QLog.i("Ark.ArkMediaPlayer", 1, "onForeground");
    synchronized (j)
    {
      Iterator localIterator = j.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (WeakReference)localIterator.next();
        if (localObject2 != null)
        {
          localObject2 = (ArkMediaPlayer)((WeakReference)localObject2).get();
          if (localObject2 != null) {
            ((ArkMediaPlayer)localObject2).c();
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public static void b()
  {
    QLog.i("Ark.ArkMediaPlayer", 1, "onBackground");
    synchronized (j)
    {
      Iterator localIterator = j.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (WeakReference)localIterator.next();
        if (localObject2 != null)
        {
          localObject2 = (ArkMediaPlayer)((WeakReference)localObject2).get();
          if (localObject2 != null) {
            ((ArkMediaPlayer)localObject2).d();
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public boolean Pause()
  {
    if (!this.c) {
      this.i = 3;
    }
    return super.Pause();
  }
  
  public boolean Play()
  {
    if (!this.c) {
      this.i = 1;
    }
    return super.Play();
  }
  
  public boolean Resume()
  {
    if (!this.c) {
      this.i = 4;
    }
    return super.Resume();
  }
  
  public boolean Stop()
  {
    if (!this.c) {
      this.i = 2;
    }
    return super.Stop();
  }
  
  public void c()
  {
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(this.mQueueKey, new ArkMediaPlayer.3(this));
  }
  
  public void d()
  {
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(this.mQueueKey, new ArkMediaPlayer.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.component.ArkMediaPlayer
 * JD-Core Version:    0.7.0.1
 */