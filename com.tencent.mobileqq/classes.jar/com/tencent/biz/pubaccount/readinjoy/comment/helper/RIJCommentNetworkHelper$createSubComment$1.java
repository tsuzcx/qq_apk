package com.tencent.biz.pubaccount.readinjoy.comment.helper;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SimpleCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SubCommentCreateData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import oxp;
import oxr;
import oxs;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "commentId", "", "invoke"}, k=3, mv={1, 1, 16})
public final class RIJCommentNetworkHelper$createSubComment$1
  extends Lambda
  implements Function1<Integer, Unit>
{
  public RIJCommentNetworkHelper$createSubComment$1(boolean paramBoolean1, oxs paramoxs, long paramLong1, String paramString, int paramInt, boolean paramBoolean2, SubCommentCreateData paramSubCommentCreateData, long paramLong2)
  {
    super(1);
  }
  
  public final void invoke(int paramInt)
  {
    if (!this.$needBiuAfterComment)
    {
      this.$callback.a(this.$commentSeq, true, 0, 2, String.valueOf(paramInt), this.$commentJsonStr, this.$feedsType, this.$isFeeds);
      oxr.a(oxr.a, 0, System.currentTimeMillis() - this.$requestTime);
      if (TextUtils.isEmpty((CharSequence)this.$requestData.b())) {
        break label139;
      }
    }
    label139:
    for (String str = this.$requestData.b();; str = this.$requestData.c())
    {
      oxr.a(oxr.a, this.$requestData.e(), str, this.$requestData.a(), this.$requestData.f(), String.valueOf(paramInt));
      return;
      oxp.a.a((SimpleCommentData)this.$requestData, (Function2)new RIJCommentNetworkHelper.createSubComment.1.1(this, paramInt));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.createSubComment.1
 * JD-Core Version:    0.7.0.1
 */