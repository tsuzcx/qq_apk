package com.tencent.mobileqq.activity;

import acrl;
import acss;
import amtj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class AssistantSettingActivity$1$1
  implements Runnable
{
  public AssistantSettingActivity$1$1(acrl paramacrl, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_Acrl.a.a.notifyDataSetChanged();
    BaseApplication localBaseApplication = this.jdField_a_of_type_Acrl.a.app.getApp();
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = amtj.a(2131699924);; str = amtj.a(2131699920))
    {
      QQToast.a(localBaseApplication, str, 0).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.1.1
 * JD-Core Version:    0.7.0.1
 */