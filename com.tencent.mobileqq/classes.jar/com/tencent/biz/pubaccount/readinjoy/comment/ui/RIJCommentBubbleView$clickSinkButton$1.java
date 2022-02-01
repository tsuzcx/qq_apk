package com.tencent.biz.pubaccount.readinjoy.comment.ui;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "clickedView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "which", "", "OnClick"}, k=3, mv={1, 1, 16})
final class RIJCommentBubbleView$clickSinkButton$1
  implements ActionSheet.OnButtonClickListener
{
  RIJCommentBubbleView$clickSinkButton$1(RIJCommentBubbleView paramRIJCommentBubbleView, Ref.ObjectRef paramObjectRef, Ref.BooleanRef paramBooleanRef, ActionSheet paramActionSheet) {}
  
  public final void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    ReadInJoyCommentDataManager localReadInJoyCommentDataManager = (ReadInJoyCommentDataManager)this.jdField_a_of_type_KotlinJvmInternalRef$ObjectRef.element;
    paramView = RIJCommentBubbleView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiRIJCommentBubbleView).a;
    if (paramView != null) {}
    for (paramView = paramView.commentId;; paramView = null)
    {
      localReadInJoyCommentDataManager.b(paramView, this.jdField_a_of_type_KotlinJvmInternalRef$BooleanRef.element);
      RIJCommentBubbleView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiRIJCommentBubbleView, 8);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ui.RIJCommentBubbleView.clickSinkButton.1
 * JD-Core Version:    0.7.0.1
 */