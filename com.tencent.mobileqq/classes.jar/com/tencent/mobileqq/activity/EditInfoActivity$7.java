package com.tencent.mobileqq.activity;

import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.vas.troopnick.shop.widget.ShopLayout.HideInputmethod;

class EditInfoActivity$7
  implements ShopLayout.HideInputmethod
{
  EditInfoActivity$7(EditInfoActivity paramEditInfoActivity) {}
  
  public void a()
  {
    if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {}
    while ((this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) && (!EditInfoActivity.b(this.a))) {
      return;
    }
    this.a.b();
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.a.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.7
 * JD-Core Version:    0.7.0.1
 */