package com.tencent.biz.pubaccount.readinjoy.comment.helper;

import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils.CustomDialogClickListener;
import com.tencent.biz.pubaccount.readinjoy.comment.base.ReadInJoyCommentEntrance;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/comment/helper/RIJCommentNetworkWrapper$wrapHippyCallback$1", "Lcom/tencent/biz/pubaccount/readinjoy/comment/helper/RIJCommentNetworkHelper$RIJCreateCommentForHippyObserver;", "onCreateCommentResult", "", "success", "", "errorCode", "", "comment", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentNetworkWrapper$wrapHippyCallback$1
  implements RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver
{
  RIJCommentNetworkWrapper$wrapHippyCallback$1(ReadInJoyCommentUtils.CustomDialogClickListener paramCustomDialogClickListener, RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver paramRIJCreateCommentForHippyObserver) {}
  
  public void onCreateCommentResult(boolean paramBoolean, int paramInt, @Nullable String paramString)
  {
    if ((paramInt == -4097) && (ReadInJoyCommentEntrance.a()))
    {
      ReadInJoyCommentEntrance.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$CustomDialogClickListener);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHelperRIJCommentNetworkHelper$RIJCreateCommentForHippyObserver.onCreateCommentResult(paramBoolean, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkWrapper.wrapHippyCallback.1
 * JD-Core Version:    0.7.0.1
 */