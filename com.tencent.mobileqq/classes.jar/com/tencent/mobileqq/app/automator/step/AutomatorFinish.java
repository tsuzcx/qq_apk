package com.tencent.mobileqq.app.automator.step;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.util.Log;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.signature.SignatureKickData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.fts.api.IFTSDBRuntimeService;
import com.tencent.mobileqq.fts.interfaces.IFTSTroopInterface;
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
  public static long a = -1L;
  
  protected int doStep()
  {
    jdField_a_of_type_Long = System.currentTimeMillis();
    long l = jdField_a_of_type_Long - this.mAutomator.jdField_a_of_type_Long;
    DeviceOptSwitch.a |= 0x20;
    DeviceOptSwitch.e = jdField_a_of_type_Long;
    this.mAutomator.jdField_a_of_type_Long = 0L;
    Object localObject = new HashMap();
    ((HashMap)localObject).put("param_threadOpId", String.valueOf(ThreadOptimizer.a().a()));
    StatisticCollector.getInstance(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).collectPerformance(null, "actQQInit", true, l, this.mAutomator.b, (HashMap)localObject, null);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QQInitialize, cost=");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append(", totalFailCount=");
    ((StringBuilder)localObject).append(this.mAutomator.b);
    Log.i("AutoMonitor", ((StringBuilder)localObject).toString());
    try
    {
      BaseApplicationImpl.sApplication.getClassLoader().loadClass("com.tencent.mobileqq.protect.RtRa");
      i = 1;
    }
    catch (Throwable localThrowable1)
    {
      int i;
      label172:
      label574:
      break label172;
    }
    i = 0;
    if (i != 0) {}
    try
    {
      StatisticCollector.getInstance(BaseApplicationImpl.sApplication).collectPerformance(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "qqDetectAttack", true, 0L, 0L, null, null);
      localObject = BaseApplicationImpl.sApplication.getSharedPreferences("QQDetectAttack", 0);
      i = ((SharedPreferences)localObject).getInt("AttackCount", 0);
      if (i >= 10)
      {
        Intent localIntent = new Intent();
        localIntent.setAction("mqq.intent.action.ACCOUNT_KICKED");
        localIntent.putExtra("reason", Constants.LogoutReason.secKicked);
        signature.SignatureKickData localSignatureKickData = new signature.SignatureKickData();
        localSignatureKickData.str_packname.set("pack");
        int j = BaseApplicationImpl.sApplication.getSharedPreferences("SecSig", 0).getInt("SecResEntry", -1);
        localSignatureKickData.u32_check_result.set(j & 0x12);
        Resources localResources = BaseApplicationImpl.sApplication.getResources();
        localSignatureKickData.str_right_button.set(localResources.getString(2131691827));
        localSignatureKickData.str_url.set("https://im.qq.com");
        localIntent.putExtra("data", localSignatureKickData.toByteArray());
        localIntent.putExtra("title", localResources.getString(2131719638));
        localIntent.putExtra("msg", localResources.getString(2131698748));
        MsfSdkUtils.updateSimpleAccount(this.mAutomator.getCurrentAccountUin(), false);
        BaseApplicationImpl.sApplication.setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.logout(true);
        localIntent.setFlags(872415232);
        RouteUtils.a(BaseApplicationImpl.sApplication, localIntent, "/base/notification");
      }
      ((SharedPreferences)localObject).edit().putInt("AttackCount", i + 1).commit();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(AppConstants.SDCARD_ROOT);
      ((StringBuilder)localObject).append("/tencent/MobileQQ/data/wifi");
      localObject = new File(((StringBuilder)localObject).toString());
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      if (DeviceOptSwitch.b)
      {
        localObject = (IFTSTroopInterface)((IFTSDBRuntimeService)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IFTSDBRuntimeService.class, "")).getOperator(2);
        if (QLog.isColorLevel()) {
          QLog.d("Perf", 0, "after automator finish,fts get the troop list");
        }
        ((IFTSTroopInterface)localObject).a();
      }
    }
    catch (Throwable localThrowable2)
    {
      break label574;
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.AutomatorFinish
 * JD-Core Version:    0.7.0.1
 */