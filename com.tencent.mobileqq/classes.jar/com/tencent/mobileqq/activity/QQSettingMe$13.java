package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import aodp;
import aokv;
import bbav;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

class QQSettingMe$13
  implements Runnable
{
  QQSettingMe$13(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    Object localObject = new ArrayList();
    bbav localbbav = (bbav)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    this.this$0.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localbbav.a(String.valueOf(100190));
    int i = localbbav.a(100007, 100);
    SharedPreferences localSharedPreferences;
    if (i > 0)
    {
      this.this$0.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localbbav.a(1, 100007, "100007", i, false);
      this.this$0.c = localbbav.a(String.valueOf(100005));
      localSharedPreferences = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      if ((this.this$0.c == null) || (this.this$0.c.iNewFlag.get() != 1)) {
        break label592;
      }
      localSharedPreferences.edit().putBoolean("individuationIsForcePullSpKey", true).commit();
    }
    for (;;)
    {
      this.this$0.d = localbbav.a(String.valueOf(100400));
      this.this$0.e = localbbav.a(String.valueOf(100160));
      this.this$0.f = localbbav.a(String.valueOf(100450));
      this.this$0.g = localbbav.a(String.valueOf(100180));
      this.this$0.h = localbbav.a(String.valueOf(103000));
      this.this$0.j = localbbav.a(String.valueOf(100460));
      this.this$0.k = localbbav.a(String.valueOf("200010.200012"));
      this.this$0.l = localbbav.a(String.valueOf(100500));
      this.this$0.m = localbbav.a(String.valueOf(100066));
      this.this$0.n = localbbav.a(1, String.valueOf(100077));
      this.this$0.o = localbbav.a(1, String.valueOf(101100));
      ((List)localObject).add(this.this$0.o);
      ((List)localObject).add(this.this$0.d);
      ((List)localObject).add(this.this$0.e);
      ((List)localObject).add(this.this$0.f);
      ((List)localObject).add(this.this$0.h);
      ((List)localObject).add(this.this$0.g);
      ((List)localObject).add(this.this$0.j);
      ((List)localObject).add(this.this$0.k);
      ((List)localObject).add(this.this$0.l);
      ((List)localObject).add(this.this$0.m);
      ((List)localObject).add(this.this$0.n);
      aokv.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      QQSettingMe.b(this.this$0);
      QQSettingMe.d(this.this$0);
      aodp.a();
      QQSettingMe.b(this.this$0);
      this.this$0.G();
      QQSettingMe.a(this.this$0, (List)localObject);
      localObject = this.this$0.jdField_b_of_type_AndroidOsHandler.obtainMessage(0);
      this.this$0.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      return;
      this.this$0.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localbbav.a(String.valueOf(100007));
      break;
      label592:
      localSharedPreferences.edit().putBoolean("individuationIsForcePullSpKey", false).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.13
 * JD-Core Version:    0.7.0.1
 */