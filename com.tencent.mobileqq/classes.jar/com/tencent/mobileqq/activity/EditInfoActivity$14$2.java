package com.tencent.mobileqq.activity;

import adwh;
import android.graphics.Color;
import android.widget.TextView;

public class EditInfoActivity$14$2
  implements Runnable
{
  public EditInfoActivity$14$2(adwh paramadwh, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_Adwh.a.b.setText(this.jdField_a_of_type_Adwh.a.c);
    if (this.jdField_a_of_type_Int > this.jdField_a_of_type_Adwh.a.d)
    {
      this.jdField_a_of_type_Adwh.a.b.setTextColor(-65536);
      this.jdField_a_of_type_Adwh.a.rightViewText.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_Adwh.a.b.setTextColor(Color.rgb(119, 119, 119));
    this.jdField_a_of_type_Adwh.a.rightViewText.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.14.2
 * JD-Core Version:    0.7.0.1
 */