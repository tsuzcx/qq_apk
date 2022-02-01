package com.tencent.mobileqq.activity;

import adfc;
import android.graphics.Color;
import android.widget.TextView;

public class EditInfoActivity$11$2
  implements Runnable
{
  public EditInfoActivity$11$2(adfc paramadfc, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_Adfc.a.b.setText(this.jdField_a_of_type_Adfc.a.jdField_c_of_type_JavaLangString);
    if (this.jdField_a_of_type_Int > this.jdField_a_of_type_Adfc.a.jdField_c_of_type_Int)
    {
      this.jdField_a_of_type_Adfc.a.b.setTextColor(-65536);
      this.jdField_a_of_type_Adfc.a.rightViewText.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_Adfc.a.b.setTextColor(Color.rgb(119, 119, 119));
    this.jdField_a_of_type_Adfc.a.rightViewText.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.11.2
 * JD-Core Version:    0.7.0.1
 */