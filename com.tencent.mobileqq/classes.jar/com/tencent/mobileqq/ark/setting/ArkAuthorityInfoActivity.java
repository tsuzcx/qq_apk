package com.tencent.mobileqq.ark.setting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import anke;
import anrq;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class ArkAuthorityInfoActivity
  extends IphoneTitleBarActivity
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "ark_authority_api_user_info", "ark_authority_api_location", "ark_authority_api_relationship", "ark_authority_api_login", "ark_authority_api_phone_number" };
  private String jdField_a_of_type_JavaLangString;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131558662);
    super.setTitle(2131690237);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("intent_extra_authority_app_name");
    ((TextView)super.findViewById(2131362803)).setText(getString(2131690249, new Object[] { this.jdField_a_of_type_JavaLangString }));
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      paramBundle = (FormSwitchItem)super.findViewById(new int[] { 2131362797, 2131362793, 2131362796, 2131362794, 2131362795 }[i]);
      int j = anke.a(this.jdField_a_of_type_JavaLangString, jdField_a_of_type_ArrayOfJavaLangString[i], this.app.getCurrentAccountUin());
      if (j == 0)
      {
        paramBundle.setVisibility(8);
        i += 1;
      }
      else
      {
        paramBundle.setVisibility(0);
        if (1 == j) {}
        for (boolean bool = true;; bool = false)
        {
          paramBundle.setChecked(bool);
          paramBundle.setOnCheckedChangeListener(new anrq(this, i));
          break;
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.setting.ArkAuthorityInfoActivity
 * JD-Core Version:    0.7.0.1
 */