package com.tencent.mobileqq.ark.setting;

import alpf;
import alwl;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
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
    setContentView(2131558629);
    super.setTitle(2131690189);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("intent_extra_authority_app_name");
    ((TextView)super.findViewById(2131362773)).setText(getString(2131690201, new Object[] { this.jdField_a_of_type_JavaLangString }));
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      paramBundle = (FormSwitchItem)super.findViewById(new int[] { 2131362768, 2131362764, 2131362767, 2131362765, 2131362766 }[i]);
      int j = alpf.a(this.jdField_a_of_type_JavaLangString, jdField_a_of_type_ArrayOfJavaLangString[i], this.app.getCurrentAccountUin());
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
          paramBundle.setOnCheckedChangeListener(new alwl(this, i));
          break;
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.setting.ArkAuthorityInfoActivity
 * JD-Core Version:    0.7.0.1
 */