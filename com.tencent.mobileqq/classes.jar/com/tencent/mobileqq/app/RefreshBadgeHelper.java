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
  public static ArrayList<Class<? extends IBadgeCountInjector>> a;
  volatile int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getRecentThreadLooper());
  private IBadgeCountInjector jdField_a_of_type_ComTencentMobileqqUtilApiIBadgeCountInjector;
  ConcurrentLinkedQueue<RefreshBadgeHelper.RefreshBadgeRunnable> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private final AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private int b = -1;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(AppBadgeCountInjector.class);
  }
  
  public RefreshBadgeHelper(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    b();
  }
  
  private void a(RefreshBadgeHelper.RefreshBadgeRunnable paramRefreshBadgeRunnable)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(paramRefreshBadgeRunnable);
    c();
  }
  
  private void b()
  {
    try
    {
      if ((jdField_a_of_type_JavaUtilArrayList != null) && (jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilApiIBadgeCountInjector = ((IBadgeCountInjector)((Class)jdField_a_of_type_JavaUtilArrayList.get(0)).newInstance());
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
    if (this.jdField_a_of_type_Int < 3)
    {
      RefreshBadgeHelper.RefreshBadgeRunnable localRefreshBadgeRunnable = (RefreshBadgeHelper.RefreshBadgeRunnable)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
      if (localRefreshBadgeRunnable != null)
      {
        this.jdField_a_of_type_Int += 1;
        this.jdField_a_of_type_AndroidOsHandler.post(localRefreshBadgeRunnable);
      }
    }
  }
  
  public void a()
  {
    a(new RefreshBadgeHelper.RefreshBadgeRunnable(this));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.RefreshBadgeHelper
 * JD-Core Version:    0.7.0.1
 */