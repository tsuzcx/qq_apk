package com.tencent.biz.pubaccount.weishi_new.verticalvideo.deltatime;

import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;

public class WSVerticalForGridDeltaTimeCalculator
  implements IWSVerticalDeltaTimeCalculator
{
  private long jdField_a_of_type_Long;
  private final WSVerticalDeltaTimeReportParams jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams = new WSVerticalDeltaTimeReportParams();
  private long b;
  private long c;
  private long d;
  private long e;
  
  private long a(long paramLong)
  {
    if (this.jdField_a_of_type_Long > 0L) {
      return paramLong - this.jdField_a_of_type_Long;
    }
    return -1L;
  }
  
  public void a(long paramLong)
  {
    this.jdField_d_of_type_Long = paramLong;
    if (this.jdField_c_of_type_Long > 0L) {}
    for (paramLong -= this.jdField_c_of_type_Long;; paramLong = -1L)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_d_of_type_Long = paramLong;
      WSLog.e("WSVerticalForGridDeltaTimeCalculator", "[onBindFirstHolderUptime] deltaTime:" + paramLong);
      return;
    }
  }
  
  public void a(long paramLong, WSPlayerParam paramWSPlayerParam)
  {
    if (this.jdField_e_of_type_Long > 0L) {}
    for (long l = paramLong - this.jdField_e_of_type_Long;; l = -1L)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_f_of_type_Long = l;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_g_of_type_Long = a(paramLong);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_a_of_type_JavaLangString = "1001";
      WSLog.e("WSVerticalForGridDeltaTimeCalculator", "[onFirstVideoStartedUptime] deltaTime:" + l);
      WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams);
      WSLog.f("WSVerticalForGridDeltaTimeCalculator", "<<<< [totalDeltaTime] deltaTime:" + a(paramLong));
      return;
    }
  }
  
  public void a(long paramLong, WSVerticalItemData paramWSVerticalItemData)
  {
    long l2 = -1L;
    this.jdField_c_of_type_Long = paramLong;
    label43:
    WSVerticalDeltaTimeReportParams localWSVerticalDeltaTimeReportParams;
    if (this.jdField_b_of_type_Long > 0L)
    {
      paramLong -= this.jdField_b_of_type_Long;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_c_of_type_Long = paramLong;
      if (paramWSVerticalItemData == null) {
        break label173;
      }
      paramWSVerticalItemData = paramWSVerticalItemData.a();
      localWSVerticalDeltaTimeReportParams = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams;
      if (paramWSVerticalItemData == null) {
        break label178;
      }
      localObject = paramWSVerticalItemData.id;
      label59:
      localWSVerticalDeltaTimeReportParams.jdField_d_of_type_JavaLangString = ((String)localObject);
      localWSVerticalDeltaTimeReportParams = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams;
      if ((paramWSVerticalItemData == null) || (paramWSVerticalItemData.poster == null)) {
        break label185;
      }
    }
    label173:
    label178:
    label185:
    for (Object localObject = paramWSVerticalItemData.poster.id;; localObject = "")
    {
      localWSVerticalDeltaTimeReportParams.jdField_e_of_type_JavaLangString = ((String)localObject);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams;
      long l1 = l2;
      if (paramWSVerticalItemData != null)
      {
        l1 = l2;
        if (paramWSVerticalItemData.video != null) {
          l1 = paramWSVerticalItemData.video.duration;
        }
      }
      ((WSVerticalDeltaTimeReportParams)localObject).jdField_a_of_type_Long = l1;
      WSLog.e("WSVerticalForGridDeltaTimeCalculator", "[onViewCreatedUptime] deltaTime:" + paramLong);
      return;
      paramLong = -1L;
      break;
      paramWSVerticalItemData = null;
      break label43;
      localObject = "";
      break label59;
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_g_of_type_Long = a(paramLong);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_a_of_type_JavaLangString = "3001";
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_f_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_g_of_type_JavaLangString = paramString2;
    WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams);
    WSLog.d("WSVerticalForGridDeltaTimeCalculator", "[onFirstVideoPlayError] deltaTime:" + a(paramLong));
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_c_of_type_JavaLangString = paramString2;
    if (this.jdField_a_of_type_Long > 0L) {}
    for (paramLong1 = paramLong2 - this.jdField_a_of_type_Long;; paramLong1 = -1L)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_b_of_type_Long = paramLong1;
      WSLog.f("WSVerticalForGridDeltaTimeCalculator", ">>>> [onCreateUptime] deltaTime:" + paramLong1);
      return;
    }
  }
  
  public void b(long paramLong)
  {
    this.jdField_e_of_type_Long = paramLong;
    if (this.jdField_d_of_type_Long > 0L) {}
    for (paramLong -= this.jdField_d_of_type_Long;; paramLong = -1L)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_e_of_type_Long = paramLong;
      WSLog.e("WSVerticalForGridDeltaTimeCalculator", "[onPlayFirstVideoUptime] deltaTime:" + paramLong);
      return;
    }
  }
  
  public void c(long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_g_of_type_Long = a(paramLong);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_a_of_type_JavaLangString = "2001";
    WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams);
    WSLog.d("WSVerticalForGridDeltaTimeCalculator", "[onFirstVideoNotPlayScrollSecond] deltaTime:" + a(paramLong));
  }
  
  public void d(long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_g_of_type_Long = a(paramLong);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_a_of_type_JavaLangString = "2002";
    WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams);
    WSLog.d("WSVerticalForGridDeltaTimeCalculator", "[onFirstVideoNotPlayOnPause] deltaTime:" + a(paramLong));
  }
  
  public void e(long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_g_of_type_Long = a(paramLong);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_a_of_type_JavaLangString = "2003";
    WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams);
    WSLog.d("WSVerticalForGridDeltaTimeCalculator", "[onFirstVideoNotPlayExitVertical] deltaTime:" + a(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.deltatime.WSVerticalForGridDeltaTimeCalculator
 * JD-Core Version:    0.7.0.1
 */