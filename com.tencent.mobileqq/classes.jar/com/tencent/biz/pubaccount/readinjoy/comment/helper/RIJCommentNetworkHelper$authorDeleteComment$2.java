package com.tencent.biz.pubaccount.readinjoy.comment.helper;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import osl;
import otp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isOverTimes", "", "invoke"}, k=3, mv={1, 1, 16})
public final class RIJCommentNetworkHelper$authorDeleteComment$2
  extends Lambda
  implements Function1<Boolean, Unit>
{
  public RIJCommentNetworkHelper$authorDeleteComment$2(osl paramosl, otp paramotp, int paramInt)
  {
    super(1);
  }
  
  public final void invoke(boolean paramBoolean)
  {
    this.$callback.a(false, this.$commentViewItem, this.$feedsType, "", paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.authorDeleteComment.2
 * JD-Core Version:    0.7.0.1
 */