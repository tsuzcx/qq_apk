package com.tencent.biz.pubaccount.readinjoy.comment.helper;

import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SimpleCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SubCommentCreateData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import pgt;
import pgv;
import pgw;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "comment", "", "commentId", "", "invoke"}, k=3, mv={1, 1, 16})
public final class RIJCommentNetworkHelper$createSubCommentForHippy$1
  extends Lambda
  implements Function2<String, Integer, Unit>
{
  public RIJCommentNetworkHelper$createSubCommentForHippy$1(boolean paramBoolean, pgw parampgw, SubCommentCreateData paramSubCommentCreateData, long paramLong)
  {
    super(2);
  }
  
  public final void invoke(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "comment");
    int i;
    if (!this.$needBiuAfterComment)
    {
      this.$callback.onCreateCommentResult(true, 0, paramString);
      pgv.a(pgv.a, 0, System.currentTimeMillis() - this.$requestTime);
      if (((CharSequence)this.$requestData.b()).length() <= 0) {
        break label133;
      }
      i = 1;
      label60:
      if (i == 0) {
        break label138;
      }
    }
    label133:
    label138:
    for (paramString = this.$requestData.b();; paramString = this.$requestData.c())
    {
      pgv.a(pgv.a, this.$requestData.e(), paramString, this.$requestData.a(), this.$requestData.f(), String.valueOf(paramInt));
      return;
      pgt.a.a((SimpleCommentData)this.$requestData, (Function2)new RIJCommentNetworkHelper.createSubCommentForHippy.1.1(this, paramString));
      break;
      i = 0;
      break label60;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.createSubCommentForHippy.1
 * JD-Core Version:    0.7.0.1
 */