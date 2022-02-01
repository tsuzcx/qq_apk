package com.tencent.biz.pubaccount.readinjoy.comment.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;

class CommentRichTextView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  String jdField_a_of_type_JavaLangString = CommentRichTextView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiCommentRichTextView).a.commentId;
  
  CommentRichTextView$2(CommentRichTextView paramCommentRichTextView, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((CommentRichTextView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiCommentRichTextView) == null) || (CommentRichTextView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiCommentRichTextView).a == null) || (this.jdField_a_of_type_JavaLangString == null))
    {
      CommentRichTextView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiCommentRichTextView, this.jdField_a_of_type_AndroidViewView);
      return;
    }
    if (!this.jdField_a_of_type_JavaLangString.equals(CommentRichTextView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiCommentRichTextView).a.commentId))
    {
      CommentRichTextView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiCommentRichTextView, this.jdField_a_of_type_AndroidViewView);
      return;
    }
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    CommentRichTextView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiCommentRichTextView).setAlpha(i);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(CommentRichTextView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiCommentRichTextView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ui.CommentRichTextView.2
 * JD-Core Version:    0.7.0.1
 */