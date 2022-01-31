package com.tencent.mobileqq.app.automator.step;

import ajsd;
import akhm;
import akta;
import aktm;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.util.Log;
import axnx;
import axrn;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.signature.SignatureKickData;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.io.File;
import java.util.HashMap;
import mqq.app.Constants.LogoutReason;

public class AutomatorFinish
  extends AsyncStep
{
  public static long a;
  
  static
  {
    jdField_a_of_type_Long = -1L;
  }
  
  public int a()
  {
    int i = 1;
    jdField_a_of_type_Long = System.currentTimeMillis();
    long l = jdField_a_of_type_Long - this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Long;
    axnx.jdField_c_of_type_Int |= 0x20;
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Long = 0L;
    Object localObject = new HashMap();
    ((HashMap)localObject).put("param_threadOpId", String.valueOf(akhm.a().a()));
    axrn.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).a(null, "actQQInit", true, l, this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b, (HashMap)localObject, null);
    Log.i("AutoMonitor", "QQInitialize, cost=" + l + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b);
    try
    {
      BaseApplicationImpl.sApplication.getClassLoader().loadClass("com.tencent.mobileqq.protect.RtRa");
      if (i != 0) {}
      try
      {
        axrn.a(BaseApplicationImpl.sApplication).a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.c(), "qqDetectAttack", true, 0L, 0L, null, null);
        localObject = BaseApplicationImpl.sApplication.getSharedPreferences("QQDetectAttack", 0);
        i = ((SharedPreferences)localObject).getInt("AttackCount", 0);
        if (i >= 10)
        {
          Intent localIntent = new Intent(BaseApplicationImpl.sApplication, NotificationActivity.class);
          localIntent.setAction("mqq.intent.action.ACCOUNT_KICKED");
          localIntent.putExtra("reason", Constants.LogoutReason.secKicked);
          signature.SignatureKickData localSignatureKickData = new signature.SignatureKickData();
          localSignatureKickData.str_packname.set("pack");
          int j = BaseApplicationImpl.sApplication.getSharedPreferences("SecSig", 0).getInt("SecResEntry", -1);
          localSignatureKickData.u32_check_result.set(j & 0x12);
          Resources localResources = BaseApplicationImpl.sApplication.getResources();
          localSignatureKickData.str_right_button.set(localResources.getString(2131691920));
          localSignatureKickData.str_url.set("http://im.qq.com");
          localIntent.putExtra("data", localSignatureKickData.toByteArray());
          localIntent.putExtra("title", localResources.getString(2131720277));
          localIntent.putExtra("msg", localResources.getString(2131698934));
          MsfSdkUtils.updateSimpleAccount(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.getCurrentAccountUin(), false);
          BaseApplicationImpl.sApplication.setSortAccountList(MsfSdkUtils.getLoginedAccountList());
          this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.logout(true);
          localIntent.setFlags(872415232);
          BaseApplicationImpl.sApplication.startActivity(localIntent);
        }
        ((SharedPreferences)localObject).edit().putInt("AttackCount", i + 1).commit();
        localObject = new File(ajsd.aV + "/tencent/MobileQQ/data/wifi");
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        if (axnx.jdField_c_of_type_Boolean)
        {
          localObject = (aktm)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().a(2);
          if (QLog.isColorLevel()) {
            QLog.d("Perf", 0, "after automator finish,fts get the troop list");
          }
          ((aktm)localObject).f();
        }
      }
      catch (Throwable localThrowable2)
      {
        label526:
        break label526;
      }
      return 7;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.AutomatorFinish
 * JD-Core Version:    0.7.0.1
 */