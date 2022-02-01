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
  public static final ark.PlayerStubFactory a;
  private static final Set<WeakReference<ArkMediaPlayer>> jdField_a_of_type_JavaUtilSet;
  static final QActivityLifecycleCallbacks jdField_a_of_type_MqqAppQActivityLifecycleCallbacks = new ArkMediaPlayer.1();
  private final int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean = true;
  private final int b = 1;
  private final int c = 2;
  private final int d = 3;
  private final int e = 4;
  private int f = 0;
  
  static
  {
    jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
    Foreground.addActivityLifeCallback(jdField_a_of_type_MqqAppQActivityLifecycleCallbacks);
    jdField_a_of_type_ComTencentArkArk$PlayerStubFactory = new ArkMediaPlayer.2();
  }
  
  protected ArkMediaPlayer()
  {
    jdField_a_of_type_JavaUtilSet.add(new WeakReference(this));
    QLog.i("Ark.ArkMediaPlayer", 1, String.format("ArkMediaPlayer.create.%h", new Object[] { this }));
  }
  
  public static void a()
  {
    QLog.i("Ark.ArkMediaPlayer", 1, "onForeground");
    synchronized (jdField_a_of_type_JavaUtilSet)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilSet.iterator();
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
    synchronized (jdField_a_of_type_JavaUtilSet)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilSet.iterator();
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
    if (!this.jdField_a_of_type_Boolean) {
      this.f = 3;
    }
    return super.Pause();
  }
  
  public boolean Play()
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.f = 1;
    }
    return super.Play();
  }
  
  public boolean Resume()
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.f = 4;
    }
    return super.Resume();
  }
  
  public boolean Stop()
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.f = 2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.component.ArkMediaPlayer
 * JD-Core Version:    0.7.0.1
 */