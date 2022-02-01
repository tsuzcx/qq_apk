package com.tencent.mobileqq.activity;

import aemh;
import android.content.Intent;
import com.tencent.mobileqq.widget.QQToast;

public class EditInfoActivity$13$1
  implements Runnable
{
  public EditInfoActivity$13$1(aemh paramaemh, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aemh.a.b(false);
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("nick", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("edit_action", this.jdField_a_of_type_Aemh.a.g);
      this.jdField_a_of_type_Aemh.a.setResult(-1, localIntent);
      this.jdField_a_of_type_Aemh.a.finish();
      return;
    }
    QQToast.a(this.jdField_a_of_type_Aemh.a, 2, 2131693743, 0).b(this.jdField_a_of_type_Aemh.a.getTitleBarHeight());
    this.jdField_a_of_type_Aemh.a.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.13.1
 * JD-Core Version:    0.7.0.1
 */