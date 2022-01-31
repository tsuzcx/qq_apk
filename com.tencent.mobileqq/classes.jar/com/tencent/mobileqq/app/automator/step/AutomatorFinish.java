package com.tencent.mobileqq.app.automator.step;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.signature.SignatureKickData;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadOptimizer;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;
import mqq.app.Constants.LogoutReason;

public class AutomatorFinish
  extends AsyncStep
{
  protected int a()
  {
    int i = 1;
    long l = System.currentTimeMillis() - this.a.a;
    this.a.a = 0L;
    Object localObject = new HashMap();
    ((HashMap)localObject).put("param_threadOpId", String.valueOf(ThreadOptimizer.a().a()));
    StatisticCollector.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).a(null, "actQQInit", true, l, this.a.jdField_b_of_type_Int, (HashMap)localObject, null);
    Log.i("AutoMonitor", "QQInitialize, cost=" + l + ", totalFailCount=" + this.a.jdField_b_of_type_Int);
    try
    {
      BaseApplicationImpl.sApplication.getClassLoader().loadClass("com.tencent.mobileqq.protect.RtRa");
      if (i != 0) {}
      try
      {
        StatisticCollector.a(BaseApplicationImpl.sApplication).a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(), "qqDetectAttack", true, 0L, 0L, null, null);
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
          localSignatureKickData.str_right_button.set(localResources.getString(2131434592));
          localSignatureKickData.str_url.set("http://im.qq.com");
          localIntent.putExtra("data", localSignatureKickData.toByteArray());
          localIntent.putExtra("title", localResources.getString(2131433248));
          localIntent.putExtra("msg", localResources.getString(2131438776));
          MsfSdkUtils.updateSimpleAccount(this.a.c(), false);
          BaseApplicationImpl.sApplication.setSortAccountList(MsfSdkUtils.getLoginedAccountList());
          this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.logout(true);
          localIntent.setFlags(872415232);
          BaseApplicationImpl.sApplication.startActivity(localIntent);
        }
        ((SharedPreferences)localObject).edit().putInt("AttackCount", i + 1).commit();
      }
      catch (Throwable localThrowable2)
      {
        label418:
        break label418;
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