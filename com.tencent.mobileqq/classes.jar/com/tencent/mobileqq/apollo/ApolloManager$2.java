package com.tencent.mobileqq.apollo;

import ahis;
import airx;
import aiue;
import aixr;
import ajeq;
import ajlo;
import ajlr;
import ajmo;
import ajmr;
import ajms;
import android.content.SharedPreferences;
import android.text.TextUtils;
import bbdx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Timer;

public class ApolloManager$2
  implements Runnable
{
  public ApolloManager$2(airx paramairx) {}
  
  public void run()
  {
    boolean bool2 = false;
    Object localObject;
    boolean bool1;
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      long l = 0L;
      if (QLog.isColorLevel()) {
        l = System.currentTimeMillis();
      }
      airx.a(this.this$0);
      airx.b(this.this$0);
      bbdx.c(ajms.a + "/.nomedia");
      this.this$0.a();
      ajlo.a(new ajlr().a(1).a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).a());
      new ajeq(0, null);
      airx.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
      airx.b(false);
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_pet_sp", 0);
      this.this$0.j = ((SharedPreferences)localObject).getString("pet_config", null);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "init apollo data from db done cost: " + (System.currentTimeMillis() - l) + ", mApp: " + this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      aixr.a();
      ajmo.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      airx.b = true;
      this.this$0.k();
      ApolloUtil.a();
      aiue.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, false);
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        localObject = this.this$0.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (localObject != null)
        {
          ((ApolloBaseInfo)localObject).getApolloDress();
          ((ApolloBaseInfo)localObject).getApolloDress3D();
          ((ApolloBaseInfo)localObject).getApolloPetDress();
        }
      }
      CmGameCmdChannel.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      new File(ajms.i).mkdirs();
      localObject = ahis.b();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (!((String)localObject).contains("EmotionUI ")) {
          break label422;
        }
        if (ajmr.a(((String)localObject).substring("EmotionUI ".length()), "10") < 0) {
          break label459;
        }
        bool1 = true;
      }
    }
    for (;;)
    {
      if (bool1) {
        this.this$0.jdField_a_of_type_JavaUtilTimer = new Timer();
      }
      QLog.i("ApolloManager", 1, "emui:" + (String)localObject + " emui10Plus:" + bool1);
      return;
      label422:
      bool1 = bool2;
      if (((String)localObject).contains("EmotionUI_"))
      {
        bool1 = bool2;
        if (ajmr.a(((String)localObject).substring("EmotionUI ".length()), "10") >= 0)
        {
          bool1 = true;
          continue;
          label459:
          bool1 = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloManager.2
 * JD-Core Version:    0.7.0.1
 */