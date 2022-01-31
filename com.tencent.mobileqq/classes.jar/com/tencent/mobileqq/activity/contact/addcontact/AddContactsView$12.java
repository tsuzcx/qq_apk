package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import bbkx;
import com.tencent.mobileqq.widget.FormMutiItem;
import com.tencent.qphone.base.util.QLog;

class AddContactsView$12
  implements Runnable
{
  AddContactsView$12(AddContactsView paramAddContactsView) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.i != null)
      {
        if (this.this$0.jdField_a_of_type_AndroidWidgetPopupWindow != null) {
          return;
        }
        View localView = ((LayoutInflater)this.this$0.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater")).inflate(2131558462, this.this$0.i, false);
        localView.measure(0, 0);
        this.this$0.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(localView);
        this.this$0.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(-2);
        this.this$0.jdField_a_of_type_AndroidWidgetPopupWindow.setWidth(-2);
        this.this$0.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(false);
        this.this$0.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(false);
        int i = bbkx.a(16.0F);
        int j = -localView.getMeasuredHeight();
        int k = this.this$0.i.getMeasuredHeight();
        int m = bbkx.a(24.0F);
        this.this$0.jdField_a_of_type_AndroidWidgetPopupWindow.showAsDropDown(this.this$0.i, i, j - k + m);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("AddContactsView", 1, "face2faceGuideTipsRunnable exception, ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.12
 * JD-Core Version:    0.7.0.1
 */