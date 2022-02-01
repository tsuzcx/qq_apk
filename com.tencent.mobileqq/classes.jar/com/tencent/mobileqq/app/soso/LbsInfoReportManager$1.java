package com.tencent.mobileqq.app.soso;

import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.LbsReportInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class LbsInfoReportManager$1
  implements Runnable
{
  LbsInfoReportManager$1(LbsInfoReportManager paramLbsInfoReportManager, double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    Object localObject = new LbsReportInfo();
    ((LbsReportInfo)localObject).operTime = NetConnInfoCenter.getServerTime();
    ((LbsReportInfo)localObject).lat = this.jdField_a_of_type_Double;
    ((LbsReportInfo)localObject).lng = this.jdField_b_of_type_Double;
    ((LbsReportInfo)localObject).alt = this.jdField_c_of_type_Double;
    ((LbsReportInfo)localObject).accuracy = this.jdField_a_of_type_Float;
    ((LbsReportInfo)localObject).businessTag = this.jdField_a_of_type_JavaLangString;
    ((LbsReportInfo)localObject).nation = this.jdField_b_of_type_JavaLangString;
    ((LbsReportInfo)localObject).province = this.jdField_c_of_type_JavaLangString;
    ((LbsReportInfo)localObject).city = this.d;
    ((LbsReportInfo)localObject).district = this.e;
    ((LbsReportInfo)localObject).createContent();
    LbsInfoReportManager.a(this.this$0).add(localObject);
    LbsInfoReportManager.a(this.this$0, this.jdField_a_of_type_Double);
    LbsInfoReportManager.b(this.this$0, this.jdField_b_of_type_Double);
    LbsInfoReportManager.a(this.this$0, SystemClock.elapsedRealtime());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceiveLbsInfo cache size : ");
      localStringBuilder.append(LbsInfoReportManager.a(this.this$0).size());
      localStringBuilder.append(" lastReportTime: ");
      localStringBuilder.append(LbsInfoReportManager.a(this.this$0));
      localStringBuilder.append(" currentTime: ");
      localStringBuilder.append(NetConnInfoCenter.getServerTime());
      QLog.i("LBSReport", 2, localStringBuilder.toString());
    }
    int i;
    if ((LbsInfoReportManager.a(this.this$0).mAutomator != null) && (!LbsInfoReportManager.a(this.this$0).mAutomator.b())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return;
    }
    if (!LbsInfoReportManager.a(this.this$0)) {
      LbsInfoReportManager.a(this.this$0);
    }
    if ((LbsInfoReportManager.a(this.this$0).size() < 20) && (NetConnInfoCenter.getServerTime() - LbsInfoReportManager.a(this.this$0) < 1200L))
    {
      LbsInfoReportManager.a(this.this$0).getEntityManagerFactory().createEntityManager().persist((Entity)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("LBSReport", 2, "update db");
      }
    }
    else
    {
      localObject = this.this$0;
      ((LbsInfoReportManager)localObject).a(LbsInfoReportManager.a((LbsInfoReportManager)localObject), 0);
      if (!LbsInfoReportManager.b(this.this$0))
      {
        localObject = this.this$0;
        ((LbsInfoReportManager)localObject).a(LbsInfoReportManager.a((LbsInfoReportManager)localObject, LbsInfoReportManager.a((LbsInfoReportManager)localObject)), LbsReportInfo.convert2StrList(LbsInfoReportManager.a(this.this$0)), LbsInfoReportManager.a(this.this$0), 0);
      }
      LbsInfoReportManager.a(this.this$0).clear();
      LbsInfoReportManager.a(this.this$0).getEntityManagerFactory().createEntityManager().delete(LbsReportInfo.class.getSimpleName(), null, null);
      LbsInfoReportManager.b(this.this$0, NetConnInfoCenter.getServerTime());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.LbsInfoReportManager.1
 * JD-Core Version:    0.7.0.1
 */