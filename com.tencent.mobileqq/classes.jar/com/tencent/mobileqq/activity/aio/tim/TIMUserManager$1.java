package com.tencent.mobileqq.activity.aio.tim;

import agun;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class TIMUserManager$1
  implements Runnable
{
  public TIMUserManager$1(agun paramagun, String paramString1, String paramString2, QQAppInterface paramQQAppInterface, boolean paramBoolean) {}
  
  public void run()
  {
    if (agun.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b) == 0) {
      if (agun.a(this.this$0, this.b))
      {
        agun.a(this.this$0);
        agun.a(this.this$0, false);
        agun.a(this.this$0, 2);
        SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).edit();
        localEditor.putBoolean("tim_user_special_need_force_download", agun.a(this.this$0));
        localEditor.commit();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TIMUserManager", 2, this.jdField_a_of_type_Boolean + " startDownLoadTimTheme TimIconsState " + agun.a(this.this$0));
      }
      return;
      agun.a(this.this$0, 4);
      continue;
      agun.a(this.this$0, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tim.TIMUserManager.1
 * JD-Core Version:    0.7.0.1
 */