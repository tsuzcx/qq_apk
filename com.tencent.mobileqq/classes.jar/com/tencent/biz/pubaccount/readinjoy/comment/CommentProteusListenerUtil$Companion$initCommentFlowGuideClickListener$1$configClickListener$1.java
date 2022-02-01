package com.tencent.biz.pubaccount.readinjoy.comment;

import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class CommentProteusListenerUtil$Companion$initCommentFlowGuideClickListener$1$configClickListener$1
  implements ViewBase.OnClickListener
{
  CommentProteusListenerUtil$Companion$initCommentFlowGuideClickListener$1$configClickListener$1(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, ViewBase paramViewBase, CommentViewItem paramCommentViewItem) {}
  
  public final void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.a();
    Intrinsics.checkExpressionValueIsNotNull(paramViewBase, "adapter.vafContext");
    ReadInJoyUtils.a(paramViewBase.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getEventAttachedData());
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.a() != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter.a().g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.CommentProteusListenerUtil.Companion.initCommentFlowGuideClickListener.1.configClickListener.1
 * JD-Core Version:    0.7.0.1
 */