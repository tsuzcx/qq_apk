package com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert;

import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertArticle;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "rowKey", "", "insertArticles", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/data/RIJFeedsInsertArticle;", "invoke"}, k=3, mv={1, 1, 16})
final class RIJFeedsDynamicInsertModule$getFeedsInsertInfo$1
  extends Lambda
  implements Function2<String, ConcurrentHashMap<String, RIJFeedsInsertArticle>, Unit>
{
  RIJFeedsDynamicInsertModule$getFeedsInsertInfo$1(Ref.ObjectRef paramObjectRef)
  {
    super(2);
  }
  
  public final void invoke(@NotNull String paramString, @NotNull ConcurrentHashMap<String, RIJFeedsInsertArticle> paramConcurrentHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    Intrinsics.checkParameterIsNotNull(paramConcurrentHashMap, "insertArticles");
    this.$result.element = ((RIJFeedsInsertArticle)paramConcurrentHashMap.get(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertModule.getFeedsInsertInfo.1
 * JD-Core Version:    0.7.0.1
 */