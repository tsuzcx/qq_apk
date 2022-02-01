package com.tencent.biz.pubaccount.readinjoy.comment;

import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/comment/CommentProteusListenerUtil$Companion$initCommentFlowGuideClickListener$1", "Lcom/tencent/biz/pubaccount/readinjoy/comment/CommentProteusListenerUtil$CommentProteusOnClickListener;", "configClickListener", "", "cmdStrId", "", "container", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadinjoyCommentListBaseAdapter;", "commentViewItem", "Lcom/tencent/biz/pubaccount/readinjoy/comment/data/CommentViewItem;", "viewBase", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CommentProteusListenerUtil$Companion$initCommentFlowGuideClickListener$1
  implements CommentProteusListenerUtil.CommentProteusOnClickListener
{
  public void a(int paramInt, @NotNull Container paramContainer, @NotNull ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, @NotNull CommentViewItem paramCommentViewItem, @NotNull ViewBase paramViewBase)
  {
    Intrinsics.checkParameterIsNotNull(paramContainer, "container");
    Intrinsics.checkParameterIsNotNull(paramReadinjoyCommentListBaseAdapter, "adapter");
    Intrinsics.checkParameterIsNotNull(paramCommentViewItem, "commentViewItem");
    Intrinsics.checkParameterIsNotNull(paramViewBase, "viewBase");
    paramViewBase.setOnClickListener((ViewBase.OnClickListener)new CommentProteusListenerUtil.Companion.initCommentFlowGuideClickListener.1.configClickListener.1(paramReadinjoyCommentListBaseAdapter, paramViewBase, paramCommentViewItem));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.CommentProteusListenerUtil.Companion.initCommentFlowGuideClickListener.1
 * JD-Core Version:    0.7.0.1
 */