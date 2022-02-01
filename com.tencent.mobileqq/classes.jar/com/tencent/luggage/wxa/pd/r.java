package com.tencent.luggage.wxa.pd;

import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/OneshotCancelableCountDownAbleRunnable;", "Ljava/lang/Runnable;", "Lcom/tencent/mm/plugin/appbrand/utils/CountDownAble;", "runnable", "totalCount", "", "extraRunnable", "(Ljava/lang/Runnable;ILjava/lang/Runnable;)V", "_hasRun", "", "count", "Ljava/util/concurrent/atomic/AtomicInteger;", "getExtraRunnable", "()Ljava/lang/Runnable;", "hasRun", "getHasRun", "()Z", "isCanceled", "reach0", "getReach0", "getTotalCount", "()I", "cancel", "", "countdown", "forceReach0", "run", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class r
  implements Runnable
{
  private volatile boolean a;
  private volatile boolean b;
  private AtomicInteger c;
  private final Runnable d;
  private final int e;
  @Nullable
  private final Runnable f;
  
  @JvmOverloads
  public r(@NotNull Runnable paramRunnable)
  {
    this(paramRunnable, 0, null, 6, null);
  }
  
  @JvmOverloads
  public r(@NotNull Runnable paramRunnable1, int paramInt, @Nullable Runnable paramRunnable2)
  {
    this.d = paramRunnable1;
    this.e = paramInt;
    this.f = paramRunnable2;
    this.c = new AtomicInteger(d());
  }
  
  public boolean a()
  {
    return this.c.get() <= 0;
  }
  
  public void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("countdown, curCount: ");
    localStringBuilder.append(this.c.decrementAndGet());
    o.d("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", localStringBuilder.toString());
    if (a()) {
      run();
    }
  }
  
  public void c()
  {
    this.c.set(0);
    run();
  }
  
  public int d()
  {
    return this.e;
  }
  
  @Nullable
  public final Runnable e()
  {
    return this.f;
  }
  
  public void run()
  {
    if (this.b)
    {
      o.d("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, isCanceled");
      return;
    }
    if (!a())
    {
      o.d("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, reach0 is false, just return");
      return;
    }
    if (this.a)
    {
      o.d("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, hasRun");
      return;
    }
    this.d.run();
    this.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pd.r
 * JD-Core Version:    0.7.0.1
 */