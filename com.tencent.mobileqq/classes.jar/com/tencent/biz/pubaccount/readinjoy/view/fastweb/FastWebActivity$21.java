package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

class FastWebActivity$21
  implements Runnable
{
  FastWebActivity$21(FastWebActivity paramFastWebActivity, View paramView, AbsListView paramAbsListView, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_AndroidViewView.getBottom() + this.jdField_a_of_type_ComTencentWidgetAbsListView.getTop() - this.jdField_a_of_type_ComTencentWidgetAbsListView.getBottom() - this.jdField_a_of_type_ComTencentWidgetAbsListView.getPaddingBottom();
    this.jdField_a_of_type_ComTencentWidgetAbsListView.setInterpolator(FastWebActivity.a(this.this$0));
    if (QLog.isColorLevel()) {
      QLog.d(FastWebActivity.a(this.this$0), 2, "adjust scroll Before:" + (this.jdField_a_of_type_Int - i) + ", After:" + this.b / 2);
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (i = i - this.b / 2 + 1;; i = i + this.b / 2 + 1)
    {
      int j = (int)(FastWebActivity.a(this.this$0) * 1000.0F * 2.0F * i / this.jdField_a_of_type_ComTencentWidgetAbsListView.getFlingVelocityY());
      if (this.jdField_a_of_type_Boolean) {
        j = (int)(FastWebActivity.a(this.this$0) * 1000.0F * 2.0F * i / FastWebActivity.b(this.this$0));
      }
      this.jdField_a_of_type_ComTencentWidgetAbsListView.smoothScrollByImmediately(i, j);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.21
 * JD-Core Version:    0.7.0.1
 */