package com.tencent.luggage.wxa.pd;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rm.a;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/LifeCycleWrappedRunnable;", "Ljava/lang/Runnable;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "mRegistry", "Lcom/tencent/mm/plugin/appbrand/utils/ILifeCycleRegistry;", "mRunnable", "mCreateStackTrace", "", "(Lcom/tencent/mm/plugin/appbrand/utils/ILifeCycleRegistry;Ljava/lang/Runnable;Ljava/lang/String;)V", "mDead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "dead", "", "run", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class n
  implements a, Runnable
{
  public static final n.a a = new n.a(null);
  private final AtomicBoolean b;
  private final i<? super a> c;
  private final Runnable d;
  private final String e;
  
  public n(@NotNull i<? super a> parami, @Nullable Runnable paramRunnable, @Nullable String paramString)
  {
    this.c = parami;
    this.d = paramRunnable;
    this.e = paramString;
    this.b = new AtomicBoolean(false);
  }
  
  @JvmStatic
  @NotNull
  public static final n a(@NotNull i<? super a> parami, @Nullable Runnable paramRunnable)
  {
    return a.a(parami, paramRunnable);
  }
  
  public void a()
  {
    this.b.set(true);
  }
  
  public void run()
  {
    if (!this.b.get()) {
      try
      {
        Runnable localRunnable = this.d;
        if (localRunnable != null) {
          localRunnable.run();
        }
        return;
      }
      finally
      {
        this.c.b((a)this);
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("run() but dead, <init> stackTrace = ");
    localStringBuilder.append(this.e);
    o.c("Luggage.WXA.LifeCycleWrappedRunnable", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pd.n
 * JD-Core Version:    0.7.0.1
 */