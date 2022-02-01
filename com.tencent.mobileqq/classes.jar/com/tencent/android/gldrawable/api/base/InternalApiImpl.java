package com.tencent.android.gldrawable.api.base;

import com.tencent.android.gldrawable.api.IGLDrawableLoader;
import com.tencent.android.gldrawable.api.ILoaderCallback;
import com.tencent.android.gldrawable.api.ILoaderSucessCallback;
import com.tencent.android.gldrawable.api.IReporter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/android/gldrawable/api/base/InternalApiImpl;", "Lcom/tencent/android/gldrawable/api/base/AbsApi;", "()V", "fistCallTime", "", "loaderSucessCallbacks", "Ljava/util/ArrayList;", "Lcom/tencent/android/gldrawable/api/ILoaderSucessCallback;", "logger", "Lcom/tencent/android/gldrawable/api/IReporter;", "getLogger$api_release", "()Lcom/tencent/android/gldrawable/api/IReporter;", "logger$delegate", "Lkotlin/Lazy;", "loadDynamicSync", "", "loadDynamicSync$api_release", "notifyLoaderCallbacksIfNeed", "realLoadApk", "realLoadApk$api_release", "registerLoadSucessCallback", "callback", "registerLoadSucessCallback$api_release", "waitAndTryLoad", "waitAndTryLoad$api_release", "Companion", "api_release"}, k=1, mv={1, 1, 16})
public abstract class InternalApiImpl
  extends AbsApi
{
  public static final InternalApiImpl.Companion Companion = new InternalApiImpl.Companion(null);
  public static final long TIME_WAIT = 500L;
  private long fistCallTime;
  private final ArrayList<ILoaderSucessCallback> loaderSucessCallbacks = new ArrayList();
  @NotNull
  private final Lazy logger$delegate = LazyKt.lazy((Function0)new InternalApiImpl.logger.2(this));
  
  private final void notifyLoaderCallbacksIfNeed()
  {
    if (this.loaderSucessCallbacks.size() > 0) {
      synchronized (this.loaderSucessCallbacks)
      {
        Object localObject1 = this.loaderSucessCallbacks.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((ILoaderSucessCallback)((Iterator)localObject1).next()).onLoadSucceed();
        }
        this.loaderSucessCallbacks.clear();
        localObject1 = Unit.INSTANCE;
        return;
      }
    }
  }
  
  @NotNull
  public final IReporter getLogger$api_release()
  {
    return (IReporter)this.logger$delegate.getValue();
  }
  
  public final void loadDynamicSync$api_release()
  {
    if (getLoader().isStatic()) {
      return;
    }
    if (isDynamicReady())
    {
      notifyLoaderCallbacksIfNeed();
      return;
    }
    waitAndTryLoad$api_release();
    if (isDynamicReady()) {
      notifyLoaderCallbacksIfNeed();
    }
  }
  
  public final void realLoadApk$api_release()
  {
    try
    {
      ILoaderCallback localILoaderCallback = (ILoaderCallback)new InternalApiImpl.realLoadApk.callback.1(this);
      getLoader().loadSync(localILoaderCallback);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public final void registerLoadSucessCallback$api_release(@NotNull ILoaderSucessCallback paramILoaderSucessCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramILoaderSucessCallback, "callback");
    synchronized (this.loaderSucessCallbacks)
    {
      this.loaderSucessCallbacks.add(paramILoaderSucessCallback);
      return;
    }
  }
  
  public final void waitAndTryLoad$api_release()
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    new Thread((Runnable)new InternalApiImpl.waitAndTryLoad.1(this, localCountDownLatch)).start();
    if (this.fistCallTime == 0L) {
      this.fistCallTime = System.currentTimeMillis();
    }
    long l = Math.abs(System.currentTimeMillis() - this.fistCallTime);
    if (l < 500L) {
      try
      {
        localCountDownLatch.await(500L - l, TimeUnit.MILLISECONDS);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.base.InternalApiImpl
 * JD-Core Version:    0.7.0.1
 */