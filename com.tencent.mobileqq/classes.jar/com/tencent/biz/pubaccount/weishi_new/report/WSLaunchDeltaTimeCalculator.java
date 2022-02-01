package com.tencent.biz.pubaccount.weishi_new.report;

import android.os.SystemClock;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

public class WSLaunchDeltaTimeCalculator
  implements IWSLaunchTimeCalculator
{
  private long a;
  private long b;
  private long c;
  private long d;
  private long e;
  private long f;
  
  public long a()
  {
    return this.b - this.a;
  }
  
  public void a()
  {
    WSLog.e("WSLaunchDeltaTimeCalculator", "[WSLaunchDeltaTimeCalculator.java][onEntranceClick]");
    this.a = SystemClock.uptimeMillis();
  }
  
  public long b()
  {
    return this.c - this.b;
  }
  
  public void b()
  {
    WSLog.e("WSLaunchDeltaTimeCalculator", "[WSLaunchDeltaTimeCalculator.java][onRecommendFeedsReqSend]");
    this.b = SystemClock.uptimeMillis();
  }
  
  public long c()
  {
    return this.d - this.c;
  }
  
  public void c()
  {
    WSLog.e("WSLaunchDeltaTimeCalculator", "[WSLaunchDeltaTimeCalculator.java][onRecommendFeedsRspReceive]");
    this.c = SystemClock.uptimeMillis();
  }
  
  public long d()
  {
    return this.e - this.d;
  }
  
  public void d()
  {
    WSLog.e("WSLaunchDeltaTimeCalculator", "[WSLaunchDeltaTimeCalculator.java][onRecommendFeedsHandleFinish]");
    this.d = SystemClock.uptimeMillis();
  }
  
  public long e()
  {
    return this.f - this.e;
  }
  
  public void e()
  {
    WSLog.e("WSLaunchDeltaTimeCalculator", "[WSLaunchDeltaTimeCalculator.java][onFirstPageCoverLoadStart]");
    this.e = SystemClock.uptimeMillis();
  }
  
  public long f()
  {
    return this.f - this.a;
  }
  
  public void f()
  {
    WSLog.e("WSLaunchDeltaTimeCalculator", "[WSLaunchDeltaTimeCalculator.java][onFirstPageCoverLoadFinish]");
    this.f = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSLaunchDeltaTimeCalculator
 * JD-Core Version:    0.7.0.1
 */