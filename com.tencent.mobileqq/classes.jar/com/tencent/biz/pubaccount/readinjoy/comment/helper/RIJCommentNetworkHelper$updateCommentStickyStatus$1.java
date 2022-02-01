package com.tencent.biz.pubaccount.readinjoy.comment.helper;

import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentStickyData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import otk;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isOverTimes", "", "invoke"}, k=3, mv={1, 1, 16})
public final class RIJCommentNetworkHelper$updateCommentStickyStatus$1
  extends Lambda
  implements Function1<Boolean, Unit>
{
  public RIJCommentNetworkHelper$updateCommentStickyStatus$1(otk paramotk, FirstCommentStickyData paramFirstCommentStickyData)
  {
    super(1);
  }
  
  public final void invoke(boolean paramBoolean)
  {
    this.$callback.a(this.$commentStickyData.a(), this.$commentStickyData.a(), false, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.updateCommentStickyStatus.1
 * JD-Core Version:    0.7.0.1
 */