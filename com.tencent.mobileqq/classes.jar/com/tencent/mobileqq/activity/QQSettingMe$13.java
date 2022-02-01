package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import aoae;
import aogw;
import bbbq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

class QQSettingMe$13
  implements Runnable
{
  QQSettingMe$13(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "updateAllNewRedTouchViewInfo");
    }
    Object localObject = new ArrayList();
    bbbq localbbbq = (bbbq)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
    this.this$0.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localbbbq.a(String.valueOf(100190));
    int i = localbbbq.a(100007, 100);
    SharedPreferences localSharedPreferences;
    if (i > 0)
    {
      this.this$0.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localbbbq.a(1, 100007, "100007", i, false);
      this.this$0.c = localbbbq.a(String.valueOf(100005));
      localSharedPreferences = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      if ((this.this$0.c == null) || (this.this$0.c.iNewFlag.get() != 1)) {
        break label649;
      }
      localSharedPreferences.edit().putBoolean("individuationIsForcePullSpKey", true).commit();
    }
    for (;;)
    {
      this.this$0.d = localbbbq.a(String.valueOf(100400));
      this.this$0.e = localbbbq.a(String.valueOf(100160));
      this.this$0.f = localbbbq.a(String.valueOf(100450));
      this.this$0.g = localbbbq.a(String.valueOf(100180));
      this.this$0.h = localbbbq.a(String.valueOf(103000));
      this.this$0.j = localbbbq.a(String.valueOf(100460));
      this.this$0.k = localbbbq.a(String.valueOf("200010.200012"));
      this.this$0.l = localbbbq.a(String.valueOf(100500));
      this.this$0.m = localbbbq.a(String.valueOf(100066));
      this.this$0.n = localbbbq.a(1, String.valueOf(100077));
      this.this$0.o = localbbbq.a(1, String.valueOf(101100));
      this.this$0.p = localbbbq.a(String.valueOf(101400));
      this.this$0.q = localbbbq.a(String.valueOf(101500));
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
      aogw.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      QQSettingMe.b(this.this$0);
      QQSettingMe.d(this.this$0);
      aoae.a();
      QQSettingMe.b(this.this$0);
      this.this$0.F();
      QQSettingMe.a(this.this$0, (List)localObject);
      if (this.this$0.a())
      {
        localObject = this.this$0.jdField_b_of_type_AndroidOsHandler.obtainMessage(0);
        this.this$0.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      }
      return;
      this.this$0.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localbbbq.a(String.valueOf(100007));
      break;
      label649:
      localSharedPreferences.edit().putBoolean("individuationIsForcePullSpKey", false).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.13
 * JD-Core Version:    0.7.0.1
 */