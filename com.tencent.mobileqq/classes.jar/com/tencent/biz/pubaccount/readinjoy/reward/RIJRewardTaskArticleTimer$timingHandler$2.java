package com.tencent.biz.pubaccount.readinjoy.reward;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/os/Handler;", "invoke"}, k=3, mv={1, 1, 16})
final class RIJRewardTaskArticleTimer$timingHandler$2
  extends Lambda
  implements Function0<Handler>
{
  public static final 2 INSTANCE = new 2();
  
  RIJRewardTaskArticleTimer$timingHandler$2()
  {
    super(0);
  }
  
  @NotNull
  public final Handler invoke()
  {
    return new Handler(Looper.getMainLooper());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskArticleTimer.timingHandler.2
 * JD-Core Version:    0.7.0.1
 */