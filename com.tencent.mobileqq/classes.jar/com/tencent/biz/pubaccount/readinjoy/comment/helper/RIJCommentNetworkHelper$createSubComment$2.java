package com.tencent.biz.pubaccount.readinjoy.comment.helper;

import com.tencent.mobileqq.pb.PBStringField;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.SubCommentCreateRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "response", "Ltencent/im/oidb/oidb_0xd1e/oidb_0xd1e$SubCommentCreateRsp;", "errorCode", "", "<anonymous parameter 2>", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJCommentNetworkHelper$createSubComment$2
  extends Lambda
  implements Function3<oidb_0xd1e.SubCommentCreateRsp, Integer, String, Unit>
{
  RIJCommentNetworkHelper$createSubComment$2(RIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver, long paramLong1, String paramString, int paramInt, boolean paramBoolean, long paramLong2)
  {
    super(3);
  }
  
  public final void invoke(@NotNull oidb_0xd1e.SubCommentCreateRsp paramSubCommentCreateRsp, int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramSubCommentCreateRsp, "response");
    Intrinsics.checkParameterIsNotNull(paramString, "<anonymous parameter 2>");
    paramString = this.$callback;
    CreateCommentResult localCreateCommentResult = new CreateCommentResult();
    localCreateCommentResult.jdField_a_of_type_Long = this.$commentSeq;
    localCreateCommentResult.jdField_a_of_type_Boolean = false;
    localCreateCommentResult.jdField_a_of_type_Int = paramInt;
    localCreateCommentResult.jdField_b_of_type_Int = 1;
    localCreateCommentResult.jdField_a_of_type_JavaLangString = "";
    localCreateCommentResult.jdField_b_of_type_JavaLangString = this.$commentJsonStr;
    localCreateCommentResult.jdField_c_of_type_JavaLangString = paramSubCommentCreateRsp.actual_create_content.get();
    localCreateCommentResult.d = paramSubCommentCreateRsp.share_url.get();
    localCreateCommentResult.jdField_c_of_type_Int = this.$feedsType;
    localCreateCommentResult.jdField_b_of_type_Boolean = this.$isFeeds;
    paramString.a(localCreateCommentResult);
    RIJCommentNetworkHelper.a(RIJCommentNetworkHelper.a, -1, System.currentTimeMillis() - this.$requestTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.createSubComment.2
 * JD-Core Version:    0.7.0.1
 */