package com.tencent.biz.pubaccount.readinjoy.comment;

import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/CommentProteusListenerUtil$CommentProteusOnClickListener;", "", "configClickListener", "", "cmdStrId", "", "container", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadinjoyCommentListBaseAdapter;", "commentViewItem", "Lcom/tencent/biz/pubaccount/readinjoy/comment/data/CommentViewItem;", "viewBase", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface CommentProteusListenerUtil$CommentProteusOnClickListener
{
  public abstract void a(int paramInt, @NotNull Container paramContainer, @NotNull ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, @NotNull CommentViewItem paramCommentViewItem, @NotNull ViewBase paramViewBase);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.CommentProteusListenerUtil.CommentProteusOnClickListener
 * JD-Core Version:    0.7.0.1
 */