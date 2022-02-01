package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.TMG.utils.QLog;
import vms;

public class QCircleReplyMessagePresenter$6
  implements Runnable
{
  public QCircleReplyMessagePresenter$6(vms paramvms, View paramView, int[] paramArrayOfInt, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    arrayOfInt[1] += this.jdField_a_of_type_AndroidViewView.getHeight();
    if (this.jdField_a_of_type_ArrayOfInt[1] > this.jdField_a_of_type_Int)
    {
      vms.a(this.this$0).scrollBy(0, this.jdField_a_of_type_ArrayOfInt[1] - this.jdField_a_of_type_Int);
      QLog.i("QCircleReplyMessagePresenter", 1, "scrollItemToVisbleAboveInputLayout  postDelayed scrollBy: " + (this.jdField_a_of_type_ArrayOfInt[1] - this.jdField_a_of_type_Int));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.presenter.QCircleReplyMessagePresenter.6
 * JD-Core Version:    0.7.0.1
 */