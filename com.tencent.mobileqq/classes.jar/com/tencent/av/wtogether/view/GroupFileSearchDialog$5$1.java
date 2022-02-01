package com.tencent.av.wtogether.view;

import android.widget.EditText;
import nah;
import nal;

public class GroupFileSearchDialog$5$1
  implements Runnable
{
  public GroupFileSearchDialog$5$1(nal paramnal) {}
  
  public void run()
  {
    if (this.a.a.d)
    {
      this.a.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask = null;
      return;
    }
    if (this.a.a.jdField_a_of_type_Int > 0)
    {
      this.a.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask = null;
      return;
    }
    this.a.a.jdField_a_of_type_JavaLangString = this.a.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim().toLowerCase();
    this.a.a.jdField_b_of_type_JavaLangString = null;
    this.a.a.jdField_b_of_type_Int = 0;
    this.a.a.c = true;
    this.a.a.a(this.a.a.jdField_a_of_type_JavaLangString);
    this.a.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.wtogether.view.GroupFileSearchDialog.5.1
 * JD-Core Version:    0.7.0.1
 */