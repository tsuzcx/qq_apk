package com.tencent.biz.pubaccount.readinjoy;

import bkbq;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import nvp;
import nvw;
import owy;

public class DailyDynamicHeaderViewController$5$1
  implements Runnable
{
  public DailyDynamicHeaderViewController$5$1(nvw paramnvw, int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a != null))
    {
      String str1 = this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.f;
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.e;
      QLog.i("DailyHeaderViewController", 1, "[onLocationFinish] adCode=" + str1 + " cityName=" + str2);
      bkbq.a("sp_key_daily_dynamic_header_last_refresh_time", Long.valueOf(System.currentTimeMillis()));
      owy.a().u();
      return;
    }
    nvp.a(this.jdField_a_of_type_Nvw.a, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.DailyDynamicHeaderViewController.5.1
 * JD-Core Version:    0.7.0.1
 */