package com.tencent.mobileqq.activity;

import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppView.Callback;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.qphone.base.util.QLog;

class ArkFullScreenAppActivity$4
  implements ArkAppView.Callback
{
  ArkFullScreenAppActivity$4(ArkFullScreenAppActivity paramArkFullScreenAppActivity) {}
  
  public void a()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("ArkFullScreenAppActivity", 2, "arkview loadSucc: " + ArkFullScreenAppActivity.a(this.a));
    }
    Object localObject;
    boolean bool;
    if (ArkFullScreenAppActivity.a(this.a) != null)
    {
      localObject = ArkFullScreenAppActivity.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer;
      if (localObject != null)
      {
        if ((!((ArkAppContainer)localObject).checkShare()) || (!ArkFullScreenAppActivity.a(this.a).jdField_a_of_type_Boolean)) {
          break label135;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.i("ArkFullScreenAppActivity", 2, "supportShare: " + bool);
        }
        localObject = this.a.rightViewImg;
        if (!bool) {
          break label140;
        }
      }
    }
    for (;;)
    {
      ((ImageView)localObject).setVisibility(i);
      return;
      label135:
      bool = false;
      break;
      label140:
      i = 4;
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ArkFullScreenAppActivity.4
 * JD-Core Version:    0.7.0.1
 */