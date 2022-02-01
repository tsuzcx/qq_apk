package com.tencent.biz.pubaccount.readinjoy.reward;

import android.util.LruCache;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/util/LruCache;", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJRewardTaskLocalRepo$taskTimeCache$2
  extends Lambda
  implements Function0<LruCache<String, String>>
{
  public static final 2 INSTANCE = new 2();
  
  RIJRewardTaskLocalRepo$taskTimeCache$2()
  {
    super(0);
  }
  
  @NotNull
  public final LruCache<String, String> invoke()
  {
    return new LruCache(10000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskLocalRepo.taskTimeCache.2
 * JD-Core Version:    0.7.0.1
 */