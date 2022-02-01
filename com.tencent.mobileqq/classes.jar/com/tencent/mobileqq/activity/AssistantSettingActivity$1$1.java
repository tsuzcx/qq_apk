package com.tencent.mobileqq.activity;

import adhv;
import adje;
import anvx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class AssistantSettingActivity$1$1
  implements Runnable
{
  public AssistantSettingActivity$1$1(adhv paramadhv, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_Adhv.a.a.notifyDataSetChanged();
    BaseApplication localBaseApplication = this.jdField_a_of_type_Adhv.a.app.getApp();
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = anvx.a(2131700275);; str = anvx.a(2131700271))
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