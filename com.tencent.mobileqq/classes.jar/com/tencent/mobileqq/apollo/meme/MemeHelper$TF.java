package com.tencent.mobileqq.apollo.meme;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/meme/MemeHelper$TF;", "Ljava/util/concurrent/ThreadFactory;", "name", "", "priority", "", "(Ljava/lang/String;I)V", "id", "Ljava/util/concurrent/atomic/AtomicInteger;", "newThread", "Ljava/lang/Thread;", "runnable", "Ljava/lang/Runnable;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public class MemeHelper$TF
  implements ThreadFactory
{
  private final AtomicInteger a;
  private final String b;
  private final int c;
  
  public MemeHelper$TF(@NotNull String paramString, int paramInt)
  {
    this.b = paramString;
    this.c = paramInt;
    this.a = new AtomicInteger();
  }
  
  @NotNull
  public Thread newThread(@NotNull Runnable paramRunnable)
  {
    Intrinsics.checkParameterIsNotNull(paramRunnable, "runnable");
    paramRunnable = (Runnable)new MemeHelper.TF.newThread.1(this, paramRunnable);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append('-');
    localStringBuilder.append(this.a.getAndIncrement());
    return new Thread(paramRunnable, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.MemeHelper.TF
 * JD-Core Version:    0.7.0.1
 */