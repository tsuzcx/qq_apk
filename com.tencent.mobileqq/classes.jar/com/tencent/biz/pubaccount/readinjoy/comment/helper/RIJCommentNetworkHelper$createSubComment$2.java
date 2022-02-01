package com.tencent.biz.pubaccount.readinjoy.comment.helper;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import oxr;
import oxs;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errorCode", "", "<anonymous parameter 1>", "", "invoke"}, k=3, mv={1, 1, 16})
public final class RIJCommentNetworkHelper$createSubComment$2
  extends Lambda
  implements Function2<Integer, String, Unit>
{
  public RIJCommentNetworkHelper$createSubComment$2(oxs paramoxs, long paramLong1, String paramString, int paramInt, boolean paramBoolean, long paramLong2)
  {
    super(2);
  }
  
  public final void invoke(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<anonymous parameter 1>");
    this.$callback.a(this.$commentSeq, false, paramInt, 1, "", this.$commentJsonStr, this.$feedsType, this.$isFeeds);
    oxr.a(oxr.a, -1, System.currentTimeMillis() - this.$requestTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.createSubComment.2
 * JD-Core Version:    0.7.0.1
 */