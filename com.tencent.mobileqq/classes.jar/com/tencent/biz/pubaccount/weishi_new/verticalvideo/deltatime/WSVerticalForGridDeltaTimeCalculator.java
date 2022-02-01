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
  private long a;
  private long b;
  private long c;
  private long d;
  private long e;
  private final WSVerticalDeltaTimeReportParams f = new WSVerticalDeltaTimeReportParams();
  
  private long f(long paramLong)
  {
    long l = this.a;
    if (l > 0L) {
      return paramLong - l;
    }
    return -1L;
  }
  
  public void a(long paramLong)
  {
    this.d = paramLong;
    long l = this.c;
    if (l > 0L) {
      paramLong -= l;
    } else {
      paramLong = -1L;
    }
    this.f.i = paramLong;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onBindFirstHolderUptime] deltaTime:");
    localStringBuilder.append(paramLong);
    WSLog.e("WSVerticalForGridDeltaTimeCalculator", localStringBuilder.toString());
  }
  
  public void a(long paramLong, WSPlayerParam paramWSPlayerParam)
  {
    long l = this.e;
    if (l > 0L) {
      l = paramLong - l;
    } else {
      l = -1L;
    }
    paramWSPlayerParam = this.f;
    paramWSPlayerParam.k = l;
    paramWSPlayerParam.l = f(paramLong);
    this.f.a = "1001";
    paramWSPlayerParam = new StringBuilder();
    paramWSPlayerParam.append("[onFirstVideoStartedUptime] deltaTime:");
    paramWSPlayerParam.append(l);
    WSLog.e("WSVerticalForGridDeltaTimeCalculator", paramWSPlayerParam.toString());
    WSVerticalBeaconReport.a(this.f);
    paramWSPlayerParam = new StringBuilder();
    paramWSPlayerParam.append("<<<< [totalDeltaTime] deltaTime:");
    paramWSPlayerParam.append(f(paramLong));
    WSLog.f("WSVerticalForGridDeltaTimeCalculator", paramWSPlayerParam.toString());
  }
  
  public void a(long paramLong, WSVerticalItemData paramWSVerticalItemData)
  {
    this.c = paramLong;
    long l1 = this.b;
    long l2 = -1L;
    if (l1 > 0L) {
      paramLong -= l1;
    } else {
      paramLong = -1L;
    }
    this.f.h = paramLong;
    if (paramWSVerticalItemData != null) {
      paramWSVerticalItemData = paramWSVerticalItemData.b();
    } else {
      paramWSVerticalItemData = null;
    }
    WSVerticalDeltaTimeReportParams localWSVerticalDeltaTimeReportParams = this.f;
    String str = "";
    if (paramWSVerticalItemData != null) {
      localObject = paramWSVerticalItemData.id;
    } else {
      localObject = "";
    }
    localWSVerticalDeltaTimeReportParams.d = ((String)localObject);
    localWSVerticalDeltaTimeReportParams = this.f;
    Object localObject = str;
    if (paramWSVerticalItemData != null)
    {
      localObject = str;
      if (paramWSVerticalItemData.poster != null) {
        localObject = paramWSVerticalItemData.poster.id;
      }
    }
    localWSVerticalDeltaTimeReportParams.e = ((String)localObject);
    localObject = this.f;
    l1 = l2;
    if (paramWSVerticalItemData != null)
    {
      l1 = l2;
      if (paramWSVerticalItemData.video != null) {
        l1 = paramWSVerticalItemData.video.duration;
      }
    }
    ((WSVerticalDeltaTimeReportParams)localObject).f = l1;
    paramWSVerticalItemData = new StringBuilder();
    paramWSVerticalItemData.append("[onViewCreatedUptime] deltaTime:");
    paramWSVerticalItemData.append(paramLong);
    WSLog.e("WSVerticalForGridDeltaTimeCalculator", paramWSVerticalItemData.toString());
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    this.f.l = f(paramLong);
    WSVerticalDeltaTimeReportParams localWSVerticalDeltaTimeReportParams = this.f;
    localWSVerticalDeltaTimeReportParams.a = "3001";
    localWSVerticalDeltaTimeReportParams.m = paramString1;
    localWSVerticalDeltaTimeReportParams.n = paramString2;
    WSVerticalBeaconReport.a(localWSVerticalDeltaTimeReportParams);
    paramString1 = new StringBuilder();
    paramString1.append("[onFirstVideoPlayError] deltaTime:");
    paramString1.append(f(paramLong));
    WSLog.d("WSVerticalForGridDeltaTimeCalculator", paramString1.toString());
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    WSVerticalDeltaTimeReportParams localWSVerticalDeltaTimeReportParams = this.f;
    localWSVerticalDeltaTimeReportParams.b = paramString1;
    localWSVerticalDeltaTimeReportParams.c = paramString2;
    paramLong1 = this.a;
    if (paramLong1 > 0L) {
      paramLong1 = paramLong2 - paramLong1;
    } else {
      paramLong1 = -1L;
    }
    this.f.g = paramLong1;
    paramString1 = new StringBuilder();
    paramString1.append(">>>> [onCreateUptime] deltaTime:");
    paramString1.append(paramLong1);
    WSLog.f("WSVerticalForGridDeltaTimeCalculator", paramString1.toString());
  }
  
  public void b(long paramLong)
  {
    this.e = paramLong;
    long l = this.d;
    if (l > 0L) {
      paramLong -= l;
    } else {
      paramLong = -1L;
    }
    this.f.j = paramLong;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onPlayFirstVideoUptime] deltaTime:");
    localStringBuilder.append(paramLong);
    WSLog.e("WSVerticalForGridDeltaTimeCalculator", localStringBuilder.toString());
  }
  
  public void c(long paramLong)
  {
    this.f.l = f(paramLong);
    Object localObject = this.f;
    ((WSVerticalDeltaTimeReportParams)localObject).a = "2001";
    WSVerticalBeaconReport.a((WSVerticalDeltaTimeReportParams)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onFirstVideoNotPlayScrollSecond] deltaTime:");
    ((StringBuilder)localObject).append(f(paramLong));
    WSLog.d("WSVerticalForGridDeltaTimeCalculator", ((StringBuilder)localObject).toString());
  }
  
  public void d(long paramLong)
  {
    this.f.l = f(paramLong);
    Object localObject = this.f;
    ((WSVerticalDeltaTimeReportParams)localObject).a = "2002";
    WSVerticalBeaconReport.a((WSVerticalDeltaTimeReportParams)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onFirstVideoNotPlayOnPause] deltaTime:");
    ((StringBuilder)localObject).append(f(paramLong));
    WSLog.d("WSVerticalForGridDeltaTimeCalculator", ((StringBuilder)localObject).toString());
  }
  
  public void e(long paramLong)
  {
    this.f.l = f(paramLong);
    Object localObject = this.f;
    ((WSVerticalDeltaTimeReportParams)localObject).a = "2003";
    WSVerticalBeaconReport.a((WSVerticalDeltaTimeReportParams)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onFirstVideoNotPlayExitVertical] deltaTime:");
    ((StringBuilder)localObject).append(f(paramLong));
    WSLog.d("WSVerticalForGridDeltaTimeCalculator", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.deltatime.WSVerticalForGridDeltaTimeCalculator
 * JD-Core Version:    0.7.0.1
 */