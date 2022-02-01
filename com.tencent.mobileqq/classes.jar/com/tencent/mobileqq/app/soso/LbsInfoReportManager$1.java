package com.tencent.mobileqq.app.soso;

import android.os.SystemClock;
import aozl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.LbsReportInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class LbsInfoReportManager$1
  implements Runnable
{
  public LbsInfoReportManager$1(aozl paramaozl, double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    LbsReportInfo localLbsReportInfo = new LbsReportInfo();
    localLbsReportInfo.operTime = NetConnInfoCenter.getServerTime();
    localLbsReportInfo.lat = this.jdField_a_of_type_Double;
    localLbsReportInfo.lng = this.jdField_b_of_type_Double;
    localLbsReportInfo.alt = this.jdField_c_of_type_Double;
    localLbsReportInfo.accuracy = this.jdField_a_of_type_Float;
    localLbsReportInfo.businessTag = this.jdField_a_of_type_JavaLangString;
    localLbsReportInfo.nation = this.jdField_b_of_type_JavaLangString;
    localLbsReportInfo.province = this.jdField_c_of_type_JavaLangString;
    localLbsReportInfo.city = this.d;
    localLbsReportInfo.district = this.e;
    localLbsReportInfo.createContent();
    aozl.a(this.this$0).add(localLbsReportInfo);
    aozl.a(this.this$0, this.jdField_a_of_type_Double);
    aozl.b(this.this$0, this.jdField_b_of_type_Double);
    aozl.a(this.this$0, SystemClock.elapsedRealtime());
    if (QLog.isColorLevel()) {
      QLog.i("LBSReport", 2, "onReceiveLbsInfo cache size : " + aozl.a(this.this$0).size() + " lastReportTime: " + aozl.a(this.this$0) + " currentTime: " + NetConnInfoCenter.getServerTime());
    }
    int i;
    if ((aozl.a(this.this$0).mAutomator != null) && (!aozl.a(this.this$0).mAutomator.b()))
    {
      i = 1;
      if (i != 0) {
        break label245;
      }
    }
    label245:
    do
    {
      return;
      i = 0;
      break;
      if (!aozl.a(this.this$0)) {
        aozl.a(this.this$0);
      }
      if ((aozl.a(this.this$0).size() >= 20) || (NetConnInfoCenter.getServerTime() - aozl.a(this.this$0) >= 1200L))
      {
        this.this$0.a(aozl.a(this.this$0), 0);
        if (!aozl.b(this.this$0)) {
          this.this$0.a(aozl.a(this.this$0, aozl.a(this.this$0)), LbsReportInfo.convert2StrList(aozl.a(this.this$0)), aozl.a(this.this$0), 0);
        }
        aozl.a(this.this$0).clear();
        aozl.a(this.this$0).getEntityManagerFactory().createEntityManager().delete(LbsReportInfo.class.getSimpleName(), null, null);
        aozl.b(this.this$0, NetConnInfoCenter.getServerTime());
        return;
      }
      aozl.a(this.this$0).getEntityManagerFactory().createEntityManager().persist(localLbsReportInfo);
    } while (!QLog.isColorLevel());
    QLog.d("LBSReport", 2, "update db");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.LbsInfoReportManager.1
 * JD-Core Version:    0.7.0.1
 */