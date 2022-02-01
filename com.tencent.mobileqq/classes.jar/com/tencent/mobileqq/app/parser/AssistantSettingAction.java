package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.settings.config.SettingsConfigHelper;
import com.tencent.mobileqq.settings.message.AssistantSettingFragment;
import com.tencent.qphone.base.util.QLog;

public class AssistantSettingAction
  extends JumpActionBase
{
  public AssistantSettingAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = h_();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("AssistantSettingAction", 1, "doAction error: " + localException.getMessage());
      a("AssistantSettingAction");
    }
    return false;
  }
  
  public boolean h_()
  {
    Intent localIntent = new Intent();
    if (SettingsConfigHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, localIntent, AssistantSettingFragment.class);
    }
    for (;;)
    {
      return true;
      localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, AssistantSettingActivity.class);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.AssistantSettingAction
 * JD-Core Version:    0.7.0.1
 */