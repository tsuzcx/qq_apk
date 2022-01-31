package com.tencent.mobileqq.app.soso;

import amku;
import android.os.SystemClock;
import awbw;
import awbx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.LbsReportInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class LbsInfoReportManager$1
  implements Runnable
{
  public LbsInfoReportManager$1(amku paramamku, double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
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
    amku.a(this.this$0).add(localLbsReportInfo);
    amku.a(this.this$0, this.jdField_a_of_type_Double);
    amku.b(this.this$0, this.jdField_b_of_type_Double);
    amku.a(this.this$0, SystemClock.elapsedRealtime());
    if (QLog.isColorLevel()) {
      QLog.i("LBSReport", 2, "onReceiveLbsInfo cache size : " + amku.a(this.this$0).size() + " lastReportTime: " + amku.a(this.this$0) + " currentTime: " + NetConnInfoCenter.getServerTime());
    }
    int i;
    if ((amku.a(this.this$0).a != null) && (!amku.a(this.this$0).a.b()))
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
      if (!amku.a(this.this$0)) {
        amku.a(this.this$0);
      }
      if ((amku.a(this.this$0).size() >= 20) || (NetConnInfoCenter.getServerTime() - amku.a(this.this$0) >= 1200L))
      {
        this.this$0.a(amku.a(this.this$0), 0);
        if (!amku.b(this.this$0)) {
          this.this$0.a(amku.a(this.this$0, amku.a(this.this$0)), LbsReportInfo.convert2StrList(amku.a(this.this$0)), amku.a(this.this$0), 0);
        }
        amku.a(this.this$0).clear();
        amku.a(this.this$0).getEntityManagerFactory().createEntityManager().a(LbsReportInfo.class.getSimpleName(), null, null);
        amku.b(this.this$0, NetConnInfoCenter.getServerTime());
        return;
      }
      amku.a(this.this$0).getEntityManagerFactory().createEntityManager().a(localLbsReportInfo);
    } while (!QLog.isColorLevel());
    QLog.d("LBSReport", 2, "update db");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.LbsInfoReportManager.1
 * JD-Core Version:    0.7.0.1
 */