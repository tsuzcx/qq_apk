package com.tencent.biz.pubaccount.readinjoy.comment.helper;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import ows;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSuccess", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJCommentNetworkHelper$createFirstComment$1$1
  extends Lambda
  implements Function1<Boolean, Unit>
{
  RIJCommentNetworkHelper$createFirstComment$1$1(RIJCommentNetworkHelper.createFirstComment.1 param1, String paramString)
  {
    super(1);
  }
  
  public final void invoke(boolean paramBoolean)
  {
    this.this$0.$callback.a(this.this$0.$commentSeq, paramBoolean, 1, this.$commentId, this.this$0.$commentJsonStr, this.this$0.$feedsType, this.this$0.$isFeeds);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.createFirstComment.1.1
 * JD-Core Version:    0.7.0.1
 */