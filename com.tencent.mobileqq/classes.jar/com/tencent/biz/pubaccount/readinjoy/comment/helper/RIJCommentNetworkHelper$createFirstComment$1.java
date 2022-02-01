package com.tencent.biz.pubaccount.readinjoy.comment.helper;

import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SimpleCommentData;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.FirstCommentCreateRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "response", "Ltencent/im/oidb/oidb_0xd1e/oidb_0xd1e$FirstCommentCreateRsp;", "commentId", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJCommentNetworkHelper$createFirstComment$1
  extends Lambda
  implements Function2<oidb_0xd1e.FirstCommentCreateRsp, String, Unit>
{
  RIJCommentNetworkHelper$createFirstComment$1(boolean paramBoolean1, RIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver, long paramLong1, String paramString, int paramInt, boolean paramBoolean2, FirstCommentCreateData paramFirstCommentCreateData, long paramLong2)
  {
    super(2);
  }
  
  public final void invoke(@NotNull oidb_0xd1e.FirstCommentCreateRsp paramFirstCommentCreateRsp, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentCreateRsp, "response");
    Intrinsics.checkParameterIsNotNull(paramString, "commentId");
    int i;
    if (!this.$needBiuAfterComment)
    {
      RIJCommentNetworkHelper.RIJCreateCommentObserver localRIJCreateCommentObserver = this.$callback;
      CreateCommentResult localCreateCommentResult = new CreateCommentResult();
      localCreateCommentResult.jdField_a_of_type_Long = this.$commentSeq;
      localCreateCommentResult.jdField_a_of_type_Boolean = true;
      localCreateCommentResult.jdField_a_of_type_Int = 0;
      localCreateCommentResult.jdField_b_of_type_Int = 1;
      localCreateCommentResult.jdField_a_of_type_JavaLangString = paramString;
      localCreateCommentResult.jdField_b_of_type_JavaLangString = this.$commentJsonStr;
      localCreateCommentResult.jdField_c_of_type_JavaLangString = paramFirstCommentCreateRsp.actual_create_content.get();
      localCreateCommentResult.d = paramFirstCommentCreateRsp.share_url.get();
      localCreateCommentResult.jdField_c_of_type_Int = this.$feedsType;
      localCreateCommentResult.jdField_b_of_type_Boolean = this.$isFeeds;
      localCreateCommentResult.a((Collection)paramFirstCommentCreateRsp.rpt_data.get());
      localRIJCreateCommentObserver.a(localCreateCommentResult);
      RIJCommentNetworkHelper.a(RIJCommentNetworkHelper.a, 0, System.currentTimeMillis() - this.$requestTime);
      if (((CharSequence)this.$requestData.c()).length() <= 0) {
        break label238;
      }
      i = 1;
      label177:
      if (i == 0) {
        break label243;
      }
    }
    label238:
    label243:
    for (paramFirstCommentCreateRsp = this.$requestData.c();; paramFirstCommentCreateRsp = this.$requestData.d())
    {
      RIJCommentNetworkHelper.a(RIJCommentNetworkHelper.a, this.$requestData.b(), paramFirstCommentCreateRsp, "", "", paramString);
      return;
      RIJBiuNetworkHelper.a.a((SimpleCommentData)this.$requestData, (Function2)new RIJCommentNetworkHelper.createFirstComment.1.2(this, paramString, paramFirstCommentCreateRsp));
      break;
      i = 0;
      break label177;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.createFirstComment.1
 * JD-Core Version:    0.7.0.1
 */