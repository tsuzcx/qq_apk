package com.tencent.biz.pubaccount.readinjoy.comment.helper;

import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentSinkData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import osl;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
public final class RIJCommentNetworkHelper$sinkComment$2
  extends Lambda
  implements Function0<Unit>
{
  public RIJCommentNetworkHelper$sinkComment$2(osl paramosl, FirstCommentSinkData paramFirstCommentSinkData)
  {
    super(0);
  }
  
  public final void invoke()
  {
    this.$callback.a(this.$commentSinkData.a(), true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.sinkComment.2
 * JD-Core Version:    0.7.0.1
 */