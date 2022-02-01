package com.tencent.biz.pubaccount.readinjoy.comment.helper;

import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentObserver;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentSinkData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isOverTimes", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJCommentNetworkHelper$sinkComment$1
  extends Lambda
  implements Function1<Boolean, Unit>
{
  RIJCommentNetworkHelper$sinkComment$1(ReadInJoyCommentObserver paramReadInJoyCommentObserver, FirstCommentSinkData paramFirstCommentSinkData)
  {
    super(1);
  }
  
  public final void invoke(boolean paramBoolean)
  {
    this.$callback.a(this.$commentSinkData.a(), this.$commentSinkData.a(), false, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.sinkComment.1
 * JD-Core Version:    0.7.0.1
 */