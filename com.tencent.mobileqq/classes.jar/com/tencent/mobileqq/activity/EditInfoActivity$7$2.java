package com.tencent.mobileqq.activity;

import acrk;
import android.graphics.Color;
import android.widget.TextView;

public class EditInfoActivity$7$2
  implements Runnable
{
  public EditInfoActivity$7$2(acrk paramacrk, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_Acrk.a.a.setText(this.jdField_a_of_type_Acrk.a.jdField_c_of_type_JavaLangString);
    if (this.jdField_a_of_type_Int > this.jdField_a_of_type_Acrk.a.jdField_c_of_type_Int)
    {
      this.jdField_a_of_type_Acrk.a.a.setTextColor(-65536);
      this.jdField_a_of_type_Acrk.a.rightViewText.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_Acrk.a.a.setTextColor(Color.rgb(119, 119, 119));
    this.jdField_a_of_type_Acrk.a.rightViewText.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.7.2
 * JD-Core Version:    0.7.0.1
 */