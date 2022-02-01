package com.tencent.biz.qqcircle.widgets;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

class QCircleFeedCommentWidget$12
  implements Runnable
{
  QCircleFeedCommentWidget$12(QCircleFeedCommentWidget paramQCircleFeedCommentWidget, View paramView, int[] paramArrayOfInt, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    arrayOfInt[1] += this.jdField_a_of_type_AndroidViewView.getHeight();
    if (this.jdField_a_of_type_ArrayOfInt[1] > this.jdField_a_of_type_Int)
    {
      QCircleFeedCommentWidget.a(this.this$0).scrollBy(0, this.jdField_a_of_type_ArrayOfInt[1] - this.jdField_a_of_type_Int);
      QLog.i("QCircleFeedCommentWidget", 1, "scrollItemToVisbleAboveInputLayout  postDelayed scrollBy: " + (this.jdField_a_of_type_ArrayOfInt[1] - this.jdField_a_of_type_Int));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFeedCommentWidget.12
 * JD-Core Version:    0.7.0.1
 */