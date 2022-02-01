package com.tencent.biz.qqcircle.widgets;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

class QCircleCommentPraiseLayout$2
  implements Runnable
{
  QCircleCommentPraiseLayout$2(QCircleCommentPraiseLayout paramQCircleCommentPraiseLayout, View paramView1, int paramInt, View paramView2) {}
  
  public void run()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidViewView.getHitRect(localRect);
    localRect.top -= this.jdField_a_of_type_Int;
    localRect.bottom += this.jdField_a_of_type_Int;
    localRect.left -= this.jdField_a_of_type_Int;
    localRect.right += this.jdField_a_of_type_Int;
    this.b.setTouchDelegate(new TouchDelegate(localRect, this.jdField_a_of_type_AndroidViewView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleCommentPraiseLayout.2
 * JD-Core Version:    0.7.0.1
 */