package com.tencent.mobileqq.activity;

import adls;
import alud;
import android.content.res.Resources;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.MultiImageTextView;

public class NotifyPushSettingActivity$22$1
  implements Runnable
{
  public NotifyPushSettingActivity$22$1(adls paramadls, String paramString) {}
  
  public void run()
  {
    boolean bool = true;
    QQToast.a(this.jdField_a_of_type_Adls.a.getActivity(), 1, alud.a(2131708047), 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298914));
    NotifyPushSettingActivity.a(this.jdField_a_of_type_Adls.a).a().setText(this.jdField_a_of_type_JavaLangString);
    NotifyPushSettingActivity localNotifyPushSettingActivity = this.jdField_a_of_type_Adls.a;
    if (!NotifyPushSettingActivity.a(this.jdField_a_of_type_Adls.a).a()) {}
    for (;;)
    {
      NotifyPushSettingActivity.a(localNotifyPushSettingActivity, bool);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity.22.1
 * JD-Core Version:    0.7.0.1
 */