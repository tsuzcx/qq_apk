package com.tencent.biz.pubaccount.readinjoy.ad.handlers;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import ong;

public class AdHandler$3
  implements Runnable
{
  public AdHandler$3(ong paramong, View paramView, AbsListView paramAbsListView, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_AndroidViewView.getBottom() - this.jdField_a_of_type_ComTencentWidgetAbsListView.getBottom() - this.jdField_a_of_type_ComTencentWidgetAbsListView.getPaddingBottom() + ong.a(this.this$0);
    this.jdField_a_of_type_ComTencentWidgetAbsListView.setInterpolator(ong.a(this.this$0));
    if (QLog.isColorLevel()) {
      QLog.d("AdHandler", 2, "adjust scroll Before:" + (this.jdField_a_of_type_Int - i) + ", After:" + this.b / 1);
    }
    i = i + this.b / 1 + 1;
    int j = (int)(ong.a(this.this$0) * 1000.0F * 2.0F * i / this.jdField_a_of_type_ComTencentWidgetAbsListView.getFlingVelocityY());
    this.jdField_a_of_type_ComTencentWidgetAbsListView.smoothScrollByImmediately(i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.handlers.AdHandler.3
 * JD-Core Version:    0.7.0.1
 */