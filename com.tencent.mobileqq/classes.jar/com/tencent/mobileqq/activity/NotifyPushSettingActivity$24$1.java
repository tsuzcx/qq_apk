package com.tencent.mobileqq.activity;

import aelh;
import android.content.res.Resources;
import anvx;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.MultiImageTextView;

public class NotifyPushSettingActivity$24$1
  implements Runnable
{
  public NotifyPushSettingActivity$24$1(aelh paramaelh, String paramString) {}
  
  public void run()
  {
    boolean bool = true;
    QQToast.a(this.jdField_a_of_type_Aelh.a.getActivity(), 1, anvx.a(2131707110), 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299080));
    NotifyPushSettingActivity.a(this.jdField_a_of_type_Aelh.a).a().setText(this.jdField_a_of_type_JavaLangString);
    NotifyPushSettingActivity localNotifyPushSettingActivity = this.jdField_a_of_type_Aelh.a;
    if (!NotifyPushSettingActivity.a(this.jdField_a_of_type_Aelh.a).a()) {}
    for (;;)
    {
      NotifyPushSettingActivity.a(localNotifyPushSettingActivity, bool);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity.24.1
 * JD-Core Version:    0.7.0.1
 */