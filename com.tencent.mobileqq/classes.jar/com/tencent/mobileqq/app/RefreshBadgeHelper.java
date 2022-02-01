package com.tencent.mobileqq.app;

import android.os.Handler;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.util.api.IBadgeCountInjector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;

public class RefreshBadgeHelper
{
  @ConfigInject(configPath="/Business/qq-appbadge-impl/src/main/res/Inject_app_badge_count.yml", version=1)
  public static ArrayList<Class<? extends IBadgeCountInjector>> c = new ArrayList();
  ConcurrentLinkedQueue<RefreshBadgeHelper.RefreshBadgeRunnable> a = new ConcurrentLinkedQueue();
  volatile int b = 0;
  private final AppRuntime d;
  private int e = -1;
  private IBadgeCountInjector f;
  private volatile boolean g = false;
  private Handler h = new Handler(ThreadManager.getRecentThreadLooper());
  
  static
  {
    c.add(AppBadgeCountInjector.class);
  }
  
  public RefreshBadgeHelper(AppRuntime paramAppRuntime)
  {
    this.d = paramAppRuntime;
    b();
  }
  
  private void a(RefreshBadgeHelper.RefreshBadgeRunnable paramRefreshBadgeRunnable)
  {
    this.a.offer(paramRefreshBadgeRunnable);
    c();
  }
  
  private void b()
  {
    try
    {
      if ((c != null) && (c.size() > 0))
      {
        this.f = ((IBadgeCountInjector)((Class)c.get(0)).newInstance());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("RefreshBadgeHelper", 1, "initInjector Fail,", localThrowable);
    }
  }
  
  private void c()
  {
    if (this.b < 3)
    {
      RefreshBadgeHelper.RefreshBadgeRunnable localRefreshBadgeRunnable = (RefreshBadgeHelper.RefreshBadgeRunnable)this.a.poll();
      if (localRefreshBadgeRunnable != null)
      {
        this.b += 1;
        this.h.post(localRefreshBadgeRunnable);
      }
    }
  }
  
  public void a()
  {
    a(new RefreshBadgeHelper.RefreshBadgeRunnable(this));
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.RefreshBadgeHelper
 * JD-Core Version:    0.7.0.1
 */