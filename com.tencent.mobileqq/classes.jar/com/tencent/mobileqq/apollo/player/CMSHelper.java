package com.tencent.mobileqq.apollo.player;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.player.action.MODE;
import com.tencent.mobileqq.apollo.player.manager.CMSBornPlayerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/CMSHelper;", "", "()V", "ASYNC_POOL_MIN_COUNT", "", "asyncHandler", "Landroid/os/Handler;", "asyncThreadPool", "Ljava/util/concurrent/Executor;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "onDestroy", "", "runOnAsyncHandler", "action", "Lkotlin/Function0;", "runOnAsyncThread", "setCanRecycleBornPlayer", "recycle", "", "toActionStatus", "Lcom/tencent/mobileqq/apollo/player/CMSActionStatus;", "toReportFeatureId", "Lcom/tencent/mobileqq/apollo/player/action/MODE;", "TF", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CMSHelper
{
  private static final Handler jdField_a_of_type_AndroidOsHandler;
  public static final CMSHelper a;
  private static final Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloPlayerCMSHelper = new CMSHelper();
    int i = RangesKt.coerceAtLeast(Runtime.getRuntime().availableProcessors(), 4);
    Object localObject = new ThreadPoolExecutor(i, i, 1L, TimeUnit.MINUTES, (BlockingQueue)new LinkedBlockingQueue(), (ThreadFactory)new CMSHelper.TF("CMS_AsyncThread", 9));
    ((ThreadPoolExecutor)localObject).allowCoreThreadTimeOut(true);
    jdField_a_of_type_JavaUtilConcurrentExecutor = (Executor)localObject;
    localObject = new HandlerThread("CMS_AsyncHandler");
    ((HandlerThread)localObject).start();
    jdField_a_of_type_AndroidOsHandler = new Handler(((HandlerThread)localObject).getLooper());
  }
  
  public final int a(@NotNull MODE paramMODE)
  {
    Intrinsics.checkParameterIsNotNull(paramMODE, "$this$toReportFeatureId");
    boolean bool = CMShowPlatform.a.b(Scene.MEME_PLAYER);
    int i = CMSHelper.WhenMappings.a[paramMODE.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          if (bool) {
            return 157;
          }
          return 140;
        }
        throw new NoWhenBranchMatchedException();
      }
      if (bool) {
        return 156;
      }
      return 135;
    }
    if (bool) {
      return 155;
    }
    return 134;
  }
  
  @NotNull
  public final CMSActionStatus a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return CMSActionStatus.UNKNOWN;
        }
        return CMSActionStatus.INTERRUPT;
      }
      return CMSActionStatus.COMPLETE;
    }
    return CMSActionStatus.START;
  }
  
  @Nullable
  public final QQAppInterface a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        return (QQAppInterface)localObject;
      }
    }
    return null;
  }
  
  public final void a()
  {
    CMSBornPlayerManager.a.a();
  }
  
  public final void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "action");
    jdField_a_of_type_JavaUtilConcurrentExecutor.execute((Runnable)new CMSHelper.runOnAsyncThread.1(paramFunction0));
  }
  
  public final void a(boolean paramBoolean)
  {
    CMSBornPlayerManager.a.a(paramBoolean);
  }
  
  public final void b(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "action");
    jdField_a_of_type_AndroidOsHandler.post((Runnable)new CMSHelper.runOnAsyncHandler.1(paramFunction0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.CMSHelper
 * JD-Core Version:    0.7.0.1
 */