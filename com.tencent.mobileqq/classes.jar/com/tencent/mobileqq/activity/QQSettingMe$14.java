package com.tencent.mobileqq.activity;

import android.view.View;
import awnu;
import azwp;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.qphone.base.util.QLog;

class QQSettingMe$14
  implements Runnable
{
  QQSettingMe$14(QQSettingMe paramQQSettingMe, String paramString) {}
  
  public void run()
  {
    azwp localazwp = azwp.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a, (byte)3);
    try
    {
      localazwp.a(awnu.b());
      this.this$0.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setFaceDrawable(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localazwp, 1, this.a, 200, true, true, 6);
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
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.14
 * JD-Core Version:    0.7.0.1
 */