package com.tencent.mobileqq.activity.aio.qim;

import aglv;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class QIMUserManager$1
  implements Runnable
{
  public QIMUserManager$1(aglv paramaglv, String paramString1, String paramString2, QQAppInterface paramQQAppInterface, boolean paramBoolean) {}
  
  public void run()
  {
    if (aglv.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b) == 0) {
      if (aglv.a(this.this$0, this.b))
      {
        aglv.a(this.this$0);
        aglv.a(this.this$0, false);
        aglv.a(this.this$0, 2);
        SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).edit();
        localEditor.putBoolean("qim_user_special_need_force_download", aglv.a(this.this$0));
        localEditor.commit();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMUserManager", 2, this.jdField_a_of_type_Boolean + " startDownLoadQimTheme QimIconsState " + aglv.a(this.this$0));
      }
      return;
      aglv.a(this.this$0, 4);
      continue;
      aglv.a(this.this$0, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qim.QIMUserManager.1
 * JD-Core Version:    0.7.0.1
 */