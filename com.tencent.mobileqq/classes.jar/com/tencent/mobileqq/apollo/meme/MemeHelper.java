package com.tencent.mobileqq.apollo.meme;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.meme.action.MODE;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.apollo.meme.manager.MemeBornPlayerManager;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/meme/MemeHelper;", "", "()V", "ASYNC_POOL_MIN_COUNT", "", "ENGINE_FRAME_MINIMUM", "", "TAG", "", "asyncHandler", "Landroid/os/Handler;", "asyncThreadPool", "Ljava/util/concurrent/Executor;", "offScreenHeight", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "getFrameImage", "", "action", "Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;", "timeOffset", "callback", "Lcom/tencent/mobileqq/apollo/meme/GetFrameCallback;", "recordAction", "recordKey", "listener", "Lcom/tencent/mobileqq/apollo/meme/IMemePlayerListener;", "runOnAsyncHandler", "Lkotlin/Function0;", "runOnAsyncHandlerDelay", "delay", "", "runOnAsyncThread", "setCanRecycleBornPlayer", "recycle", "", "adapterToBrickFrameInterval", "toReportFeatureId", "Lcom/tencent/mobileqq/apollo/meme/action/MODE;", "GetFrameImageListener", "TF", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class MemeHelper
{
  public static final MemeHelper a = new MemeHelper();
  private static final Executor b;
  private static final Handler c;
  private static final float d = CmShowWnsUtils.d();
  
  static
  {
    int i = RangesKt.coerceAtLeast(Runtime.getRuntime().availableProcessors(), 4);
    Object localObject = new ThreadPoolExecutor(i, i, 1L, TimeUnit.MINUTES, (BlockingQueue)new LinkedBlockingQueue(), (ThreadFactory)new MemeHelper.TF("Meme_AsyncThread", 9));
    ((ThreadPoolExecutor)localObject).allowCoreThreadTimeOut(true);
    b = (Executor)localObject;
    localObject = new HandlerThread("Meme_AsyncHandler");
    ((HandlerThread)localObject).start();
    c = new Handler(((HandlerThread)localObject).getLooper());
  }
  
  private final float a(float paramFloat)
  {
    float f = paramFloat / 1000.0F;
    paramFloat = f;
    if (f < 0.03333334F) {
      paramFloat = 0.03333334F;
    }
    return paramFloat;
  }
  
  public final int a(@NotNull MODE paramMODE)
  {
    Intrinsics.checkParameterIsNotNull(paramMODE, "$this$toReportFeatureId");
    boolean bool = CMShowPlatform.a.b(Scene.MEME_PLAYER);
    int i = MemeHelper.WhenMappings.$EnumSwitchMapping$0[paramMODE.ordinal()];
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
  
  public final void a(@NotNull MemeAction paramMemeAction, float paramFloat, @NotNull GetFrameCallback paramGetFrameCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramMemeAction, "action");
    Intrinsics.checkParameterIsNotNull(paramGetFrameCallback, "callback");
    b((Function0)new MemeHelper.getFrameImage.1(paramMemeAction, paramFloat, paramGetFrameCallback));
  }
  
  public final void a(@Nullable String paramString, @NotNull MemeAction paramMemeAction, @Nullable IMemePlayerListener paramIMemePlayerListener)
  {
    Intrinsics.checkParameterIsNotNull(paramMemeAction, "action");
    b((Function0)new MemeHelper.recordAction.1(paramMemeAction, paramString, paramIMemePlayerListener));
  }
  
  public final void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "action");
    b.execute((Runnable)new MemeHelper.runOnAsyncThread.1(paramFunction0));
  }
  
  public final void a(@NotNull Function0<Unit> paramFunction0, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "action");
    c.postDelayed((Runnable)new MemeHelper.runOnAsyncHandlerDelay.1(paramFunction0), paramLong);
  }
  
  public final void a(boolean paramBoolean)
  {
    MemeBornPlayerManager.a.a(paramBoolean);
  }
  
  public final void b(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "action");
    c.post((Runnable)new MemeHelper.runOnAsyncHandler.1(paramFunction0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.MemeHelper
 * JD-Core Version:    0.7.0.1
 */