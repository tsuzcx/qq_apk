package com.tencent.mobileqq.app.automator.step;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.util.Log;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.signature.SignatureKickData;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.app.proxy.fts.FTSTroopOperator;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qqperf.opt.suspendthread.DeviceOptSwitch;
import com.tencent.qqperf.opt.threadpriority.ThreadOptimizer;
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
    DeviceOptSwitch.a |= 0x20;
    DeviceOptSwitch.e = jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Long = 0L;
    Object localObject = new HashMap();
    ((HashMap)localObject).put("param_threadOpId", String.valueOf(ThreadOptimizer.a().a()));
    StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).collectPerformance(null, "actQQInit", true, l, this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b, (HashMap)localObject, null);
    Log.i("AutoMonitor", "QQInitialize, cost=" + l + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b);
    try
    {
      BaseApplicationImpl.sApplication.getClassLoader().loadClass("com.tencent.mobileqq.protect.RtRa");
      if (i != 0) {}
      try
      {
        StatisticCollector.getInstance(BaseApplicationImpl.sApplication).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "qqDetectAttack", true, 0L, 0L, null, null);
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
          localSignatureKickData.str_right_button.set(localResources.getString(2131691898));
          localSignatureKickData.str_url.set("https://im.qq.com");
          localIntent.putExtra("data", localSignatureKickData.toByteArray());
          localIntent.putExtra("title", localResources.getString(2131719906));
          localIntent.putExtra("msg", localResources.getString(2131698679));
          MsfSdkUtils.updateSimpleAccount(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.getCurrentAccountUin(), false);
          BaseApplicationImpl.sApplication.setSortAccountList(MsfSdkUtils.getLoginedAccountList());
          this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.logout(true);
          localIntent.setFlags(872415232);
          BaseApplicationImpl.sApplication.startActivity(localIntent);
        }
        ((SharedPreferences)localObject).edit().putInt("AttackCount", i + 1).commit();
        localObject = new File(AppConstants.SDCARD_ROOT + "/tencent/MobileQQ/data/wifi");
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        if (DeviceOptSwitch.b)
        {
          localObject = (FTSTroopOperator)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFTSDBManager().a(2);
          if (QLog.isColorLevel()) {
            QLog.d("Perf", 0, "after automator finish,fts get the troop list");
          }
          ((FTSTroopOperator)localObject).g();
        }
      }
      catch (Throwable localThrowable2)
      {
        label532:
        break label532;
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