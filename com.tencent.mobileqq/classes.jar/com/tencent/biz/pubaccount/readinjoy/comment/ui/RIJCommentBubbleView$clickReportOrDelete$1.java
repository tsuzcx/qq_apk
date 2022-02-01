package com.tencent.biz.pubaccount.readinjoy.comment.ui;

import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils.ReportCommentDialogClickListener;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadinjoyCommentListBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/comment/ui/RIJCommentBubbleView$clickReportOrDelete$1", "Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentUtils$ReportCommentDialogClickListener;", "onClick", "", "msg", "", "reportType", "", "which", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentBubbleView$clickReportOrDelete$1
  extends ReadInJoyCommentUtils.ReportCommentDialogClickListener
{
  public void a(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "msg");
    RIJCommentBubbleView.a(this.a).a().a(RIJCommentBubbleView.a(this.a).a.commentId, paramString, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ui.RIJCommentBubbleView.clickReportOrDelete.1
 * JD-Core Version:    0.7.0.1
 */