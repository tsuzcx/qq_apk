package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AssociatedAccountManageActivity$7$1
  implements Runnable
{
  AssociatedAccountManageActivity$7$1(AssociatedAccountManageActivity.7 param7) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountManage", 2, "deleteAccount begin to remove account view");
    }
    try
    {
      View localView = AssociatedAccountManageActivity.a(this.a.this$0, this.a.a, 1);
      if (localView != null) {
        this.a.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(localView);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel())
        {
          QLog.d("AssociatedAccountManage", 2, "deleteAccount runOnUiThread removeView error");
          continue;
          this.a.this$0.jdField_a_of_type_AndroidViewView.setVisibility(4);
        }
      }
    }
    this.a.this$0.b();
    if ((this.a.this$0.jdField_a_of_type_JavaUtilList == null) || (this.a.this$0.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      this.a.this$0.jdField_a_of_type_AndroidViewView.setVisibility(8);
      AssociatedAccountManageActivity.a(this.a.this$0);
      if (((this.a.this$0.b == null) || (this.a.this$0.b.size() == 0)) && ((this.a.this$0.jdField_a_of_type_JavaUtilList == null) || (this.a.this$0.jdField_a_of_type_JavaUtilList.size() == 0))) {
        this.a.this$0.onBackEvent();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountManageActivity.7.1
 * JD-Core Version:    0.7.0.1
 */