package com.tencent.mobileqq.activity.messagesearch;

import aepi;
import aigc;
import android.app.Activity;
import android.view.View;
import bnle;
import com.tencent.qphone.base.util.QLog;

public class BaseMessageSearchDialog$1
  implements Runnable
{
  public BaseMessageSearchDialog$1(aigc paramaigc, View paramView, Activity paramActivity) {}
  
  public void run()
  {
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(arrayOfInt);
    int i = bnle.b(this.jdField_a_of_type_AndroidAppActivity);
    if (QLog.isColorLevel()) {
      QLog.d("BaseMessageSearchDialog", 2, "rootView post : x -> " + arrayOfInt[0] + ", y -> " + arrayOfInt[1] + ", notchHeight -> " + i);
    }
    if (arrayOfInt[1] < i) {
      this.jdField_a_of_type_AndroidViewView.setPadding(this.jdField_a_of_type_AndroidViewView.getPaddingLeft(), i, this.jdField_a_of_type_AndroidViewView.getPaddingRight(), this.jdField_a_of_type_AndroidViewView.getPaddingBottom());
    }
    aepi.a(this.this$0.findViewById(2131365851));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.BaseMessageSearchDialog.1
 * JD-Core Version:    0.7.0.1
 */