package com.tencent.mobileqq.activity;

import aceh;
import acfg;
import alud;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class AssistantSettingActivity$1$1
  implements Runnable
{
  public AssistantSettingActivity$1$1(aceh paramaceh, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aceh.a.a.notifyDataSetChanged();
    BaseApplication localBaseApplication = this.jdField_a_of_type_Aceh.a.app.getApp();
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = alud.a(2131701157);; str = alud.a(2131701153))
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