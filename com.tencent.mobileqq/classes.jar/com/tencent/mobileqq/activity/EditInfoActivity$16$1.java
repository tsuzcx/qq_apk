package com.tencent.mobileqq.activity;

import adfh;
import android.content.Intent;
import com.tencent.mobileqq.widget.QQToast;

public class EditInfoActivity$16$1
  implements Runnable
{
  public EditInfoActivity$16$1(adfh paramadfh, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Adfh.a.b(false);
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("nick", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("edit_action", this.jdField_a_of_type_Adfh.a.g);
      this.jdField_a_of_type_Adfh.a.setResult(-1, localIntent);
      this.jdField_a_of_type_Adfh.a.finish();
      return;
    }
    QQToast.a(this.jdField_a_of_type_Adfh.a, 2, 2131693841, 0).b(this.jdField_a_of_type_Adfh.a.getTitleBarHeight());
    this.jdField_a_of_type_Adfh.a.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.16.1
 * JD-Core Version:    0.7.0.1
 */