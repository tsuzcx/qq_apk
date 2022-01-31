package com.tencent.mobileqq.activity;

import android.view.View;
import axmt;
import baxt;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.qphone.base.util.QLog;

class QQSettingMe$15
  implements Runnable
{
  QQSettingMe$15(QQSettingMe paramQQSettingMe, String paramString) {}
  
  public void run()
  {
    baxt localbaxt = baxt.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a, (byte)3);
    try
    {
      localbaxt.a(axmt.b());
      this.this$0.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setFaceDrawable(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbaxt, 1, this.a, 200, true, true, 6);
      this.this$0.b.setVisibility(VasFaceManager.a(this.a, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      this.this$0.y();
      if (QLog.isDevelopLevel()) {
        QLog.i("QQSettingRedesign", 4, "updateFace, " + this.a);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.d("QQSettingRedesign", 1, "FaceDrawable is default drawable");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.15
 * JD-Core Version:    0.7.0.1
 */