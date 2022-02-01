package com.tencent.mobileqq.apollo;

import amme;
import ampa;
import amsn;
import anbt;
import android.content.SharedPreferences;
import android.text.TextUtils;
import anis;
import aniv;
import anjv;
import anjy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.utils.OSUtils;
import com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Timer;

public class ApolloManager$2
  implements Runnable
{
  public ApolloManager$2(amme paramamme) {}
  
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
      amme.a(this.this$0);
      amme.b(this.this$0);
      FileUtils.createFileIfNotExits("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/.nomedia");
      this.this$0.a();
      anis.a(new aniv().a(1).a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).a());
      new anbt(0, null);
      amme.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
      amme.b(false);
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_pet_sp", 0);
      this.this$0.f = ((SharedPreferences)localObject).getString("pet_config", null);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "init apollo data from db done cost: " + (System.currentTimeMillis() - l) + ", mApp: " + this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      amsn.a();
      anjv.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      amme.b = true;
      this.this$0.k();
      ApolloUtil.a();
      ampa.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, false);
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
      new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/shader_code/").mkdirs();
      localObject = OSUtils.getEMUIVersion();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (!((String)localObject).contains("EmotionUI ")) {
          break label402;
        }
        if (anjy.a(((String)localObject).substring("EmotionUI ".length()), "10") < 0) {
          break label439;
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
      label402:
      bool1 = bool2;
      if (((String)localObject).contains("EmotionUI_"))
      {
        bool1 = bool2;
        if (anjy.a(((String)localObject).substring("EmotionUI ".length()), "10") >= 0)
        {
          bool1 = true;
          continue;
          label439:
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