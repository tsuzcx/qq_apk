package com.tencent.mobileqq.app.soso;

import akue;
import android.os.SystemClock;
import aukp;
import aukq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.LbsReportInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class LbsInfoReportManager$1
  implements Runnable
{
  public LbsInfoReportManager$1(akue paramakue, double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
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
    akue.a(this.this$0).add(localLbsReportInfo);
    akue.a(this.this$0, this.jdField_a_of_type_Double);
    akue.b(this.this$0, this.jdField_b_of_type_Double);
    akue.a(this.this$0, SystemClock.elapsedRealtime());
    if (QLog.isColorLevel()) {
      QLog.i("LBSReport", 2, "onReceiveLbsInfo cache size : " + akue.a(this.this$0).size() + " lastReportTime: " + akue.a(this.this$0) + " currentTime: " + NetConnInfoCenter.getServerTime());
    }
    int i;
    if ((akue.a(this.this$0).a != null) && (!akue.a(this.this$0).a.b()))
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
      if (!akue.a(this.this$0)) {
        akue.a(this.this$0);
      }
      if ((akue.a(this.this$0).size() >= 20) || (NetConnInfoCenter.getServerTime() - akue.a(this.this$0) >= 1200L))
      {
        this.this$0.a(akue.a(this.this$0), 0);
        if (!akue.b(this.this$0)) {
          this.this$0.a(akue.a(this.this$0, akue.a(this.this$0)), LbsReportInfo.convert2StrList(akue.a(this.this$0)), akue.a(this.this$0), 0);
        }
        akue.a(this.this$0).clear();
        akue.a(this.this$0).getEntityManagerFactory().createEntityManager().a(LbsReportInfo.class.getSimpleName(), null, null);
        akue.b(this.this$0, NetConnInfoCenter.getServerTime());
        return;
      }
      akue.a(this.this$0).getEntityManagerFactory().createEntityManager().a(localLbsReportInfo);
    } while (!QLog.isColorLevel());
    QLog.d("LBSReport", 2, "update db");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.LbsInfoReportManager.1
 * JD-Core Version:    0.7.0.1
 */