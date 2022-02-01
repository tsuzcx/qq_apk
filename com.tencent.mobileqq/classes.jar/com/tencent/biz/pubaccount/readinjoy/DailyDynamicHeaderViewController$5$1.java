package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

class DailyDynamicHeaderViewController$5$1
  implements Runnable
{
  DailyDynamicHeaderViewController$5$1(DailyDynamicHeaderViewController.5 param5, int paramInt, SosoLbsInfo paramSosoLbsInfo) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation != null))
    {
      String str1 = this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.cityCode;
      String str2 = this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.city;
      QLog.i("DailyHeaderViewController", 1, "[onLocationFinish] adCode=" + str1 + " cityName=" + str2);
      ReadInJoyHelper.a("sp_key_daily_dynamic_header_last_refresh_time", Long.valueOf(System.currentTimeMillis()));
      ReadInJoyLogicEngine.a().s();
      return;
    }
    DailyDynamicHeaderViewController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDailyDynamicHeaderViewController$5.a, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.DailyDynamicHeaderViewController.5.1
 * JD-Core Version:    0.7.0.1
 */