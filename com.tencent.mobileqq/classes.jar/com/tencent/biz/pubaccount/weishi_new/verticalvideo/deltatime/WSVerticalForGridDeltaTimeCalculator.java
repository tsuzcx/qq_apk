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
    long l = this.jdField_a_of_type_Long;
    if (l > 0L) {
      return paramLong - l;
    }
    return -1L;
  }
  
  public void a(long paramLong)
  {
    this.jdField_d_of_type_Long = paramLong;
    long l = this.jdField_c_of_type_Long;
    if (l > 0L) {
      paramLong -= l;
    } else {
      paramLong = -1L;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_d_of_type_Long = paramLong;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onBindFirstHolderUptime] deltaTime:");
    localStringBuilder.append(paramLong);
    WSLog.e("WSVerticalForGridDeltaTimeCalculator", localStringBuilder.toString());
  }
  
  public void a(long paramLong, WSPlayerParam paramWSPlayerParam)
  {
    long l = this.jdField_e_of_type_Long;
    if (l > 0L) {
      l = paramLong - l;
    } else {
      l = -1L;
    }
    paramWSPlayerParam = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams;
    paramWSPlayerParam.jdField_f_of_type_Long = l;
    paramWSPlayerParam.jdField_g_of_type_Long = a(paramLong);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_a_of_type_JavaLangString = "1001";
    paramWSPlayerParam = new StringBuilder();
    paramWSPlayerParam.append("[onFirstVideoStartedUptime] deltaTime:");
    paramWSPlayerParam.append(l);
    WSLog.e("WSVerticalForGridDeltaTimeCalculator", paramWSPlayerParam.toString());
    WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams);
    paramWSPlayerParam = new StringBuilder();
    paramWSPlayerParam.append("<<<< [totalDeltaTime] deltaTime:");
    paramWSPlayerParam.append(a(paramLong));
    WSLog.f("WSVerticalForGridDeltaTimeCalculator", paramWSPlayerParam.toString());
  }
  
  public void a(long paramLong, WSVerticalItemData paramWSVerticalItemData)
  {
    this.jdField_c_of_type_Long = paramLong;
    long l1 = this.jdField_b_of_type_Long;
    long l2 = -1L;
    if (l1 > 0L) {
      paramLong -= l1;
    } else {
      paramLong = -1L;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_c_of_type_Long = paramLong;
    if (paramWSVerticalItemData != null) {
      paramWSVerticalItemData = paramWSVerticalItemData.a();
    } else {
      paramWSVerticalItemData = null;
    }
    WSVerticalDeltaTimeReportParams localWSVerticalDeltaTimeReportParams = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams;
    String str = "";
    if (paramWSVerticalItemData != null) {
      localObject = paramWSVerticalItemData.id;
    } else {
      localObject = "";
    }
    localWSVerticalDeltaTimeReportParams.jdField_d_of_type_JavaLangString = ((String)localObject);
    localWSVerticalDeltaTimeReportParams = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams;
    Object localObject = str;
    if (paramWSVerticalItemData != null)
    {
      localObject = str;
      if (paramWSVerticalItemData.poster != null) {
        localObject = paramWSVerticalItemData.poster.id;
      }
    }
    localWSVerticalDeltaTimeReportParams.jdField_e_of_type_JavaLangString = ((String)localObject);
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams;
    l1 = l2;
    if (paramWSVerticalItemData != null)
    {
      l1 = l2;
      if (paramWSVerticalItemData.video != null) {
        l1 = paramWSVerticalItemData.video.duration;
      }
    }
    ((WSVerticalDeltaTimeReportParams)localObject).jdField_a_of_type_Long = l1;
    paramWSVerticalItemData = new StringBuilder();
    paramWSVerticalItemData.append("[onViewCreatedUptime] deltaTime:");
    paramWSVerticalItemData.append(paramLong);
    WSLog.e("WSVerticalForGridDeltaTimeCalculator", paramWSVerticalItemData.toString());
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_g_of_type_Long = a(paramLong);
    WSVerticalDeltaTimeReportParams localWSVerticalDeltaTimeReportParams = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams;
    localWSVerticalDeltaTimeReportParams.jdField_a_of_type_JavaLangString = "3001";
    localWSVerticalDeltaTimeReportParams.jdField_f_of_type_JavaLangString = paramString1;
    localWSVerticalDeltaTimeReportParams.jdField_g_of_type_JavaLangString = paramString2;
    WSVerticalBeaconReport.a(localWSVerticalDeltaTimeReportParams);
    paramString1 = new StringBuilder();
    paramString1.append("[onFirstVideoPlayError] deltaTime:");
    paramString1.append(a(paramLong));
    WSLog.d("WSVerticalForGridDeltaTimeCalculator", paramString1.toString());
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    WSVerticalDeltaTimeReportParams localWSVerticalDeltaTimeReportParams = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams;
    localWSVerticalDeltaTimeReportParams.jdField_b_of_type_JavaLangString = paramString1;
    localWSVerticalDeltaTimeReportParams.jdField_c_of_type_JavaLangString = paramString2;
    paramLong1 = this.jdField_a_of_type_Long;
    if (paramLong1 > 0L) {
      paramLong1 = paramLong2 - paramLong1;
    } else {
      paramLong1 = -1L;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_b_of_type_Long = paramLong1;
    paramString1 = new StringBuilder();
    paramString1.append(">>>> [onCreateUptime] deltaTime:");
    paramString1.append(paramLong1);
    WSLog.f("WSVerticalForGridDeltaTimeCalculator", paramString1.toString());
  }
  
  public void b(long paramLong)
  {
    this.jdField_e_of_type_Long = paramLong;
    long l = this.jdField_d_of_type_Long;
    if (l > 0L) {
      paramLong -= l;
    } else {
      paramLong = -1L;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_e_of_type_Long = paramLong;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onPlayFirstVideoUptime] deltaTime:");
    localStringBuilder.append(paramLong);
    WSLog.e("WSVerticalForGridDeltaTimeCalculator", localStringBuilder.toString());
  }
  
  public void c(long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_g_of_type_Long = a(paramLong);
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams;
    ((WSVerticalDeltaTimeReportParams)localObject).jdField_a_of_type_JavaLangString = "2001";
    WSVerticalBeaconReport.a((WSVerticalDeltaTimeReportParams)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onFirstVideoNotPlayScrollSecond] deltaTime:");
    ((StringBuilder)localObject).append(a(paramLong));
    WSLog.d("WSVerticalForGridDeltaTimeCalculator", ((StringBuilder)localObject).toString());
  }
  
  public void d(long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_g_of_type_Long = a(paramLong);
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams;
    ((WSVerticalDeltaTimeReportParams)localObject).jdField_a_of_type_JavaLangString = "2002";
    WSVerticalBeaconReport.a((WSVerticalDeltaTimeReportParams)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onFirstVideoNotPlayOnPause] deltaTime:");
    ((StringBuilder)localObject).append(a(paramLong));
    WSLog.d("WSVerticalForGridDeltaTimeCalculator", ((StringBuilder)localObject).toString());
  }
  
  public void e(long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams.jdField_g_of_type_Long = a(paramLong);
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeReportParams;
    ((WSVerticalDeltaTimeReportParams)localObject).jdField_a_of_type_JavaLangString = "2003";
    WSVerticalBeaconReport.a((WSVerticalDeltaTimeReportParams)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onFirstVideoNotPlayExitVertical] deltaTime:");
    ((StringBuilder)localObject).append(a(paramLong));
    WSLog.d("WSVerticalForGridDeltaTimeCalculator", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.deltatime.WSVerticalForGridDeltaTimeCalculator
 * JD-Core Version:    0.7.0.1
 */