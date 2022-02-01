package com.tencent.biz.pubaccount.readinjoy.comment;

import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

final class CommentProteusUtil$1
  implements ViewFactory.FoundClickableViewListener
{
  CommentProteusUtil$1(Container paramContainer, ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, CommentViewItem paramCommentViewItem) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    if ((paramViewBase.getNativeView() == null) || (paramViewBase.getClickEvnet() == null)) {
      return;
    }
    SparseArray localSparseArray = new SparseArray();
    int i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
    CommentProteusListenerUtil.a.a(i, localSparseArray).a(i, localSparseArray).a(i, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadinjoyCommentListBaseAdapter, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentViewItem, paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.CommentProteusUtil.1
 * JD-Core Version:    0.7.0.1
 */