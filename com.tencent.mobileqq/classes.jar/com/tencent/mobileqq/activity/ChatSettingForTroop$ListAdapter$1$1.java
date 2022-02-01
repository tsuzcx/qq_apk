package com.tencent.mobileqq.activity;

import adcf;
import adcg;
import adef;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.TextView;
import bczs;
import bgdk;

public class ChatSettingForTroop$ListAdapter$1$1
  implements Runnable
{
  public ChatSettingForTroop$ListAdapter$1$1(adcg paramadcg, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Adcg.jdField_a_of_type_Adcf.a.c) {}
    while (!TextUtils.equals(this.jdField_a_of_type_Adcg.jdField_a_of_type_Adef.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Adcg.jdField_a_of_type_JavaLangString)) {
      return;
    }
    SpannableString localSpannableString = new bczs(this.jdField_a_of_type_JavaLangString, 12).a();
    this.jdField_a_of_type_Adcg.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableString);
    bgdk.a(this.jdField_a_of_type_Adcg.jdField_a_of_type_Adcf.a.app, this.jdField_a_of_type_Adcg.jdField_a_of_type_AndroidWidgetTextView, localSpannableString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.ListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */