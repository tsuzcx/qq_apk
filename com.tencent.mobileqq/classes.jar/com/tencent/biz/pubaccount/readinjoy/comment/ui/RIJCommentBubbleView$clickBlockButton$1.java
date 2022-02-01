package com.tencent.biz.pubaccount.readinjoy.comment.ui;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "clickedView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "which", "", "OnClick"}, k=3, mv={1, 1, 16})
final class RIJCommentBubbleView$clickBlockButton$1
  implements ActionSheet.OnButtonClickListener
{
  RIJCommentBubbleView$clickBlockButton$1(RIJCommentBubbleView paramRIJCommentBubbleView, Ref.ObjectRef paramObjectRef, ActionSheet paramActionSheet) {}
  
  public final void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      ((ReadInJoyCommentDataManager)this.jdField_a_of_type_KotlinJvmInternalRef$ObjectRef.element).b(RIJCommentBubbleView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiRIJCommentBubbleView));
      RIJCommentBubbleView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiRIJCommentBubbleView, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ui.RIJCommentBubbleView.clickBlockButton.1
 * JD-Core Version:    0.7.0.1
 */