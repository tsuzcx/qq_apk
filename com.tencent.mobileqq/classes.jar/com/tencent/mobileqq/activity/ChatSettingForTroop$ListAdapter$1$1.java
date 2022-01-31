package com.tencent.mobileqq.activity;

import acmb;
import acmc;
import acqa;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.TextView;
import bahs;
import bdnm;

public class ChatSettingForTroop$ListAdapter$1$1
  implements Runnable
{
  public ChatSettingForTroop$ListAdapter$1$1(acmc paramacmc, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Acmc.jdField_a_of_type_Acmb.a.c) {}
    while (!TextUtils.equals(this.jdField_a_of_type_Acmc.jdField_a_of_type_Acqa.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Acmc.jdField_a_of_type_JavaLangString)) {
      return;
    }
    SpannableString localSpannableString = new bahs(this.jdField_a_of_type_JavaLangString, 12).a();
    this.jdField_a_of_type_Acmc.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableString);
    bdnm.a(this.jdField_a_of_type_Acmc.jdField_a_of_type_Acmb.a.app, this.jdField_a_of_type_Acmc.jdField_a_of_type_AndroidWidgetTextView, localSpannableString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.ListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */