package com.tencent.biz.pubaccount.readinjoy.comment;

import android.graphics.Rect;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;

class ReadInJoyCommentComponentFragment$11
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ReadInJoyCommentComponentFragment$11(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    this.a.jdField_a_of_type_AndroidWidgetFrameLayout.getWindowVisibleDisplayFrame(localRect);
    int j = localRect.bottom;
    int i = j;
    if (!this.a.e) {
      i = j - this.a.g;
    }
    if (i != this.a.f)
    {
      this.a.f = i;
      this.a.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = this.a.f;
      this.a.jdField_a_of_type_AndroidWidgetFrameLayout.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment.11
 * JD-Core Version:    0.7.0.1
 */