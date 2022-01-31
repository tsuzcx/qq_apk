package com.tencent.mobileqq.activity;

import abzs;
import acar;
import alpo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class AssistantSettingActivity$1$1
  implements Runnable
{
  public AssistantSettingActivity$1$1(abzs paramabzs, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_Abzs.a.a.notifyDataSetChanged();
    BaseApplication localBaseApplication = this.jdField_a_of_type_Abzs.a.app.getApp();
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = alpo.a(2131701145);; str = alpo.a(2131701141))
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