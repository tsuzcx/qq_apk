package com.tencent.biz.pubaccount.readinjoy.comment.helper;

import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils.CustomDialogClickListener;
import com.tencent.biz.pubaccount.readinjoy.comment.base.ReadInJoyCommentEntrance;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/comment/helper/RIJCommentNetworkWrapper$wrapCallback$1", "Lcom/tencent/biz/pubaccount/readinjoy/comment/helper/RIJCommentNetworkHelper$RIJCreateCommentObserver;", "onCreateCommentResult", "", "createCommentResult", "Lcom/tencent/biz/pubaccount/readinjoy/comment/helper/CreateCommentResult;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentNetworkWrapper$wrapCallback$1
  implements RIJCommentNetworkHelper.RIJCreateCommentObserver
{
  RIJCommentNetworkWrapper$wrapCallback$1(ReadInJoyCommentUtils.CustomDialogClickListener paramCustomDialogClickListener, RIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver) {}
  
  public void a(@NotNull CreateCommentResult paramCreateCommentResult)
  {
    Intrinsics.checkParameterIsNotNull(paramCreateCommentResult, "createCommentResult");
    if ((paramCreateCommentResult.a == -4097) && (ReadInJoyCommentEntrance.a()))
    {
      ReadInJoyCommentEntrance.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$CustomDialogClickListener);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHelperRIJCommentNetworkHelper$RIJCreateCommentObserver.a(paramCreateCommentResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkWrapper.wrapCallback.1
 * JD-Core Version:    0.7.0.1
 */