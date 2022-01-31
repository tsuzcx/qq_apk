package com.tencent.mobileqq.activity;

import akcz;
import akjo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import avpq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import mqq.app.MobileQQ;

class QQSettingMe$13
  implements Runnable
{
  QQSettingMe$13(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    Object localObject = (avpq)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    this.this$0.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = ((avpq)localObject).a(String.valueOf(100190));
    int i = ((avpq)localObject).a(100007, 100);
    SharedPreferences localSharedPreferences;
    if (i > 0)
    {
      this.this$0.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = ((avpq)localObject).a(1, 100007, "100007", i, false);
      this.this$0.c = ((avpq)localObject).a(String.valueOf(100005));
      localSharedPreferences = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      if ((this.this$0.c == null) || (this.this$0.c.iNewFlag.get() != 1)) {
        break label386;
      }
      localSharedPreferences.edit().putBoolean("individuationIsForcePullSpKey", true).commit();
    }
    for (;;)
    {
      this.this$0.d = ((avpq)localObject).a(String.valueOf(100400));
      this.this$0.e = ((avpq)localObject).a(String.valueOf(100160));
      this.this$0.f = ((avpq)localObject).a(String.valueOf(100450));
      this.this$0.g = ((avpq)localObject).a(String.valueOf(100180));
      this.this$0.h = ((avpq)localObject).a(String.valueOf(103000));
      this.this$0.j = ((avpq)localObject).a(String.valueOf(100460));
      this.this$0.k = ((avpq)localObject).a(String.valueOf("200010.200012"));
      this.this$0.l = ((avpq)localObject).a(String.valueOf(100500));
      this.this$0.m = ((avpq)localObject).a(String.valueOf(100066));
      akjo.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      QQSettingMe.b(this.this$0);
      QQSettingMe.d(this.this$0);
      akcz.a();
      QQSettingMe.b(this.this$0);
      this.this$0.I();
      localObject = this.this$0.jdField_b_of_type_AndroidOsHandler.obtainMessage(0);
      this.this$0.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      return;
      this.this$0.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = ((avpq)localObject).a(String.valueOf(100007));
      break;
      label386:
      localSharedPreferences.edit().putBoolean("individuationIsForcePullSpKey", false).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.13
 * JD-Core Version:    0.7.0.1
 */