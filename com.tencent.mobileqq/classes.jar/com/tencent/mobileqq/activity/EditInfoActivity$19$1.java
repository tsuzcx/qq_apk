package com.tencent.mobileqq.activity;

import adwm;
import android.content.Intent;
import com.tencent.mobileqq.widget.QQToast;

public class EditInfoActivity$19$1
  implements Runnable
{
  public EditInfoActivity$19$1(adwm paramadwm, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Adwm.a.b(false);
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("nick", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("edit_action", this.jdField_a_of_type_Adwm.a.h);
      this.jdField_a_of_type_Adwm.a.setResult(-1, localIntent);
      this.jdField_a_of_type_Adwm.a.finish();
      return;
    }
    QQToast.a(this.jdField_a_of_type_Adwm.a, 2, 2131694032, 0).b(this.jdField_a_of_type_Adwm.a.getTitleBarHeight());
    this.jdField_a_of_type_Adwm.a.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.19.1
 * JD-Core Version:    0.7.0.1
 */