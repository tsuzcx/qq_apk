package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.qphone.base.util.QLog;
import vab;

public class QCircleCommentPanelPart$12
  implements Runnable
{
  public QCircleCommentPanelPart$12(vab paramvab, View paramView, int[] paramArrayOfInt, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    arrayOfInt[1] += this.jdField_a_of_type_AndroidViewView.getHeight();
    if (this.jdField_a_of_type_ArrayOfInt[1] > this.jdField_a_of_type_Int)
    {
      vab.a(this.this$0).a().scrollBy(0, this.jdField_a_of_type_ArrayOfInt[1] - this.jdField_a_of_type_Int);
      QLog.i("QCircleCommentPanelPart", 1, "scrollItemToVisble  postDelayed scrollBy: " + (this.jdField_a_of_type_ArrayOfInt[1] - this.jdField_a_of_type_Int));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleCommentPanelPart.12
 * JD-Core Version:    0.7.0.1
 */