package com.tencent.biz.pubaccount.readinjoy.comment;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyCommentItemHeightHelper$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ReadInJoyCommentItemHeightHelper$1(ReadInJoyCommentItemHeightHelper paramReadInJoyCommentItemHeightHelper, int paramInt, View paramView) {}
  
  public void onGlobalLayout()
  {
    ReadInJoyCommentItemHeightHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentItemHeightHelper, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView.getHeight());
    QLog.d("Q.readinjoy.fast_web", 2, " position : " + this.jdField_a_of_type_Int + "   height:" + this.jdField_a_of_type_AndroidViewView.getHeight());
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentItemHeightHelper.1
 * JD-Core Version:    0.7.0.1
 */