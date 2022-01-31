package com.tencent.mobileqq.activity;

import abae;
import android.content.Intent;
import bcpw;

public class EditInfoActivity$12$1
  implements Runnable
{
  public EditInfoActivity$12$1(abae paramabae, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Abae.a.b(false);
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("nick", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("edit_action", this.jdField_a_of_type_Abae.a.g);
      this.jdField_a_of_type_Abae.a.setResult(-1, localIntent);
      this.jdField_a_of_type_Abae.a.finish();
      return;
    }
    bcpw.a(this.jdField_a_of_type_Abae.a, 2, 2131694298, 0).b(this.jdField_a_of_type_Abae.a.getTitleBarHeight());
    this.jdField_a_of_type_Abae.a.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.12.1
 * JD-Core Version:    0.7.0.1
 */