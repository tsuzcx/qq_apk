package com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert;

import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertArticle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "reqSource", "", "rowKey", "", "feedsInsertArticle", "Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/data/RIJFeedsInsertArticle;", "invoke"}, k=3, mv={1, 1, 16})
final class RIJFeedsDynamicInsertModule$handle0xf30$1
  extends Lambda
  implements Function3<Integer, String, RIJFeedsInsertArticle, Unit>
{
  RIJFeedsDynamicInsertModule$handle0xf30$1(RIJFeedsDynamicInsertModule paramRIJFeedsDynamicInsertModule)
  {
    super(3);
  }
  
  public final void invoke(int paramInt, @NotNull String paramString, @NotNull RIJFeedsInsertArticle paramRIJFeedsInsertArticle)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    Intrinsics.checkParameterIsNotNull(paramRIJFeedsInsertArticle, "feedsInsertArticle");
    RIJFeedsDynamicInsertModule.a(this.this$0, paramInt, paramString, paramRIJFeedsInsertArticle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertModule.handle0xf30.1
 * JD-Core Version:    0.7.0.1
 */