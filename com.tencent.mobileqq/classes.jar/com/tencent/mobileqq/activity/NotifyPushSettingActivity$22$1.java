package com.tencent.mobileqq.activity;

import abpz;
import ajyc;
import android.content.res.Resources;
import bcpw;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.MultiImageTextView;

public class NotifyPushSettingActivity$22$1
  implements Runnable
{
  public NotifyPushSettingActivity$22$1(abpz paramabpz, String paramString) {}
  
  public void run()
  {
    boolean bool = true;
    bcpw.a(this.jdField_a_of_type_Abpz.a.getActivity(), 1, ajyc.a(2131707652), 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298865));
    NotifyPushSettingActivity.a(this.jdField_a_of_type_Abpz.a).a().setText(this.jdField_a_of_type_JavaLangString);
    NotifyPushSettingActivity localNotifyPushSettingActivity = this.jdField_a_of_type_Abpz.a;
    if (!NotifyPushSettingActivity.a(this.jdField_a_of_type_Abpz.a).a()) {}
    for (;;)
    {
      NotifyPushSettingActivity.a(localNotifyPushSettingActivity, bool);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity.22.1
 * JD-Core Version:    0.7.0.1
 */