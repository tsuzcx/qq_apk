package com.tencent.biz.pubaccount.readinjoy.comment.helper;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.FirstCommentCreateRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSuccess", "", "errorCode", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJCommentNetworkHelper$createFirstComment$1$2
  extends Lambda
  implements Function2<Boolean, Integer, Unit>
{
  RIJCommentNetworkHelper$createFirstComment$1$2(RIJCommentNetworkHelper.createFirstComment.1 param1, String paramString, oidb_0xd1e.FirstCommentCreateRsp paramFirstCommentCreateRsp)
  {
    super(2);
  }
  
  public final void invoke(boolean paramBoolean, int paramInt)
  {
    RIJCommentNetworkHelper.RIJCreateCommentObserver localRIJCreateCommentObserver = this.this$0.$callback;
    CreateCommentResult localCreateCommentResult = new CreateCommentResult();
    localCreateCommentResult.jdField_a_of_type_Long = this.this$0.$commentSeq;
    localCreateCommentResult.jdField_a_of_type_Boolean = paramBoolean;
    localCreateCommentResult.jdField_a_of_type_Int = paramInt;
    localCreateCommentResult.jdField_b_of_type_Int = 1;
    localCreateCommentResult.jdField_a_of_type_JavaLangString = this.$commentId;
    localCreateCommentResult.jdField_b_of_type_JavaLangString = this.this$0.$commentJsonStr;
    localCreateCommentResult.jdField_c_of_type_JavaLangString = this.$response.actual_create_content.get();
    localCreateCommentResult.d = this.$response.share_url.get();
    localCreateCommentResult.jdField_c_of_type_Int = this.this$0.$feedsType;
    localCreateCommentResult.jdField_b_of_type_Boolean = this.this$0.$isFeeds;
    localCreateCommentResult.a((Collection)this.$response.rpt_data.get());
    localRIJCreateCommentObserver.a(localCreateCommentResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.createFirstComment.1.2
 * JD-Core Version:    0.7.0.1
 */