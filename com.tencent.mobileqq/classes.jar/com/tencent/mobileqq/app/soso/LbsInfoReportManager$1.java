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
    ((LbsReportInfo)localObject).lat = this.a;
    ((LbsReportInfo)localObject).lng = this.b;
    ((LbsReportInfo)localObject).alt = this.c;
    ((LbsReportInfo)localObject).accuracy = this.d;
    ((LbsReportInfo)localObject).businessTag = this.e;
    ((LbsReportInfo)localObject).nation = this.f;
    ((LbsReportInfo)localObject).province = this.g;
    ((LbsReportInfo)localObject).city = this.h;
    ((LbsReportInfo)localObject).district = this.i;
    ((LbsReportInfo)localObject).createContent();
    LbsInfoReportManager.a(this.this$0).add(localObject);
    LbsInfoReportManager.a(this.this$0, this.a);
    LbsInfoReportManager.b(this.this$0, this.b);
    LbsInfoReportManager.a(this.this$0, SystemClock.elapsedRealtime());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceiveLbsInfo cache size : ");
      localStringBuilder.append(LbsInfoReportManager.a(this.this$0).size());
      localStringBuilder.append(" lastReportTime: ");
      localStringBuilder.append(LbsInfoReportManager.b(this.this$0));
      localStringBuilder.append(" currentTime: ");
      localStringBuilder.append(NetConnInfoCenter.getServerTime());
      QLog.i("LBSReport", 2, localStringBuilder.toString());
    }
    int j;
    if ((LbsInfoReportManager.c(this.this$0).mAutomator != null) && (!LbsInfoReportManager.c(this.this$0).mAutomator.g())) {
      j = 1;
    } else {
      j = 0;
    }
    if (j == 0) {
      return;
    }
    if (!LbsInfoReportManager.d(this.this$0)) {
      LbsInfoReportManager.e(this.this$0);
    }
    if ((LbsInfoReportManager.a(this.this$0).size() < 20) && (NetConnInfoCenter.getServerTime() - LbsInfoReportManager.b(this.this$0) < 1200L))
    {
      LbsInfoReportManager.c(this.this$0).getEntityManagerFactory().createEntityManager().persist((Entity)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("LBSReport", 2, "update db");
      }
    }
    else
    {
      localObject = this.this$0;
      ((LbsInfoReportManager)localObject).a(LbsInfoReportManager.a((LbsInfoReportManager)localObject), 0);
      if (!LbsInfoReportManager.f(this.this$0))
      {
        localObject = this.this$0;
        ((LbsInfoReportManager)localObject).a(LbsInfoReportManager.a((LbsInfoReportManager)localObject, LbsInfoReportManager.a((LbsInfoReportManager)localObject)), LbsReportInfo.convert2StrList(LbsInfoReportManager.a(this.this$0)), LbsInfoReportManager.g(this.this$0), 0);
      }
      LbsInfoReportManager.a(this.this$0).clear();
      LbsInfoReportManager.c(this.this$0).getEntityManagerFactory().createEntityManager().delete(LbsReportInfo.class.getSimpleName(), null, null);
      LbsInfoReportManager.b(this.this$0, NetConnInfoCenter.getServerTime());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.LbsInfoReportManager.1
 * JD-Core Version:    0.7.0.1
 */