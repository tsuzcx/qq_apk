package com.tencent.mobileqq.activity.aio.qim;

import adzs;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class QIMUserManager$1
  implements Runnable
{
  public QIMUserManager$1(adzs paramadzs, String paramString1, String paramString2, QQAppInterface paramQQAppInterface, boolean paramBoolean) {}
  
  public void run()
  {
    if (adzs.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b) == 0) {
      if (adzs.a(this.this$0, this.b))
      {
        adzs.a(this.this$0);
        adzs.a(this.this$0, false);
        adzs.a(this.this$0, 2);
        SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).edit();
        localEditor.putBoolean("qim_user_special_need_force_download", adzs.a(this.this$0));
        localEditor.commit();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMUserManager", 2, this.jdField_a_of_type_Boolean + " startDownLoadQimTheme QimIconsState " + adzs.a(this.this$0));
      }
      return;
      adzs.a(this.this$0, 4);
      continue;
      adzs.a(this.this$0, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qim.QIMUserManager.1
 * JD-Core Version:    0.7.0.1
 */