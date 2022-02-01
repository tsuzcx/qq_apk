package com.tencent.biz.pubaccount.util;

import com.tencent.biz.pubaccount.readinjoy.config.beans.AchillesParams;
import com.tencent.mobileqq.bigbrother.RockDownloader.QueryAPKListener;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class Achilles$1$1
  extends QueryAPKListener
{
  Achilles$1$1(Achilles.1 param1, RockDownloadInfo paramRockDownloadInfo, AchillesParams paramAchillesParams) {}
  
  public void a(RockDownloadInfo paramRockDownloadInfo, String paramString, int paramInt)
  {
    QLog.d("Achilles", 1, "query predownload info fail: " + paramRockDownloadInfo);
    Achilles.a(this.jdField_a_of_type_ComTencentMobileqqDataRockDownloadInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyConfigBeansAchillesParams);
  }
  
  public void a(ArrayList<RockDownloadInfo> paramArrayList)
  {
    QLog.d("Achilles", 1, "query predownload info success: " + paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.Achilles.1.1
 * JD-Core Version:    0.7.0.1
 */