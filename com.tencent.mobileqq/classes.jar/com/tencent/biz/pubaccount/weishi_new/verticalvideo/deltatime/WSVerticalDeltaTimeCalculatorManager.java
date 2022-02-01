package com.tencent.biz.pubaccount.weishi_new.verticalvideo.deltatime;

import UserGrowth.stSimpleMetaFeed;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoInfo;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;

public class WSVerticalDeltaTimeCalculatorManager
{
  private IWSVerticalDeltaTimeCalculator jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  private String a(WSPlayerParam paramWSPlayerParam)
  {
    if ((paramWSPlayerParam != null) && (paramWSPlayerParam.a != null)) {
      return paramWSPlayerParam.a.d;
    }
    return "";
  }
  
  private String a(WSVerticalItemData paramWSVerticalItemData)
  {
    paramWSVerticalItemData = paramWSVerticalItemData.a();
    if (paramWSVerticalItemData != null) {
      return paramWSVerticalItemData.feed_desc;
    }
    return "";
  }
  
  public void a(int paramInt, WSPlayerParam paramWSPlayerParam)
  {
    WSLog.e("WSVerticalDeltaTimeCalculatorManager", "[onPlayVideo] position:" + paramInt + ", mHasPlayFirstVideo:" + this.b + ", mHasFirstVideoStarted:" + this.c + ", title:" + a(paramWSPlayerParam));
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator != null) && (paramInt == 0) && (!this.b))
    {
      this.b = true;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator.b(SystemClock.uptimeMillis());
    }
    while ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator == null) || (paramInt != 1) || (this.c)) {
      return;
    }
    this.c = true;
    WSLog.d("WSVerticalDeltaTimeCalculatorManager", "[onPlayVideo] firstVideoNotStarted! secondVideoTitle:" + a(paramWSPlayerParam));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator.c(SystemClock.uptimeMillis());
  }
  
  public void a(WSPlayerParam paramWSPlayerParam)
  {
    WSLog.e("WSVerticalDeltaTimeCalculatorManager", "[onVideoStarted] mHasFirstVideoStarted:" + this.c + ", title:" + a(paramWSPlayerParam));
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator != null) && (!this.c))
    {
      this.c = true;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator.a(SystemClock.uptimeMillis(), paramWSPlayerParam);
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt1, int paramInt2, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator != null) && (!this.c))
    {
      WSLog.d("WSVerticalDeltaTimeCalculatorManager", "[onVideoError] firstVideoNotStarted! model:" + paramInt1 + ", what:" + paramInt2 + ", errorMsg:" + paramString + ", title:" + a(paramWSPlayerParam));
      paramWSPlayerParam = paramInt1 + ":" + paramInt2;
      this.c = true;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator.a(SystemClock.uptimeMillis(), paramWSPlayerParam, paramString);
    }
  }
  
  public void a(WSVerticalItemData paramWSVerticalItemData)
  {
    WSLog.e("WSVerticalDeltaTimeCalculatorManager", "[onViewCreated]");
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator.a(SystemClock.uptimeMillis(), paramWSVerticalItemData);
    }
  }
  
  public void a(WSVerticalItemData paramWSVerticalItemData, int paramInt, String paramString1, String paramString2)
  {
    WSLog.e("WSVerticalDeltaTimeCalculatorManager", "[onBindFeedHolder] position:" + paramInt + ", mHasBindFirstHolder:" + this.jdField_a_of_type_Boolean + ", title:" + a(paramWSVerticalItemData));
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator != null) && (paramInt == 0) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator.a(SystemClock.uptimeMillis());
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    WSLog.e("WSVerticalDeltaTimeCalculatorManager", "[onCreate] from:" + paramString1 + ", isNeedCalcDeltaTime:" + paramBoolean + ", startPageUptime:" + paramLong + ", mDeltaTimeCalculator:" + this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator);
    if (!paramBoolean) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator = WSVerticalDeltaTimeFactory.a(paramString1);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator == null);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator.a(paramString1, paramString2, paramLong, SystemClock.uptimeMillis());
  }
  
  public void b(WSPlayerParam paramWSPlayerParam)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator != null) && (!this.c))
    {
      WSLog.d("WSVerticalDeltaTimeCalculatorManager", "[onPause] firstVideoNotStarted! title:" + a(paramWSPlayerParam));
      this.c = true;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator.d(SystemClock.uptimeMillis());
    }
  }
  
  public void c(WSPlayerParam paramWSPlayerParam)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator != null) && (!this.c))
    {
      WSLog.d("WSVerticalDeltaTimeCalculatorManager", "[onExitVerticalPage] firstVideoNotStarted! title:" + a(paramWSPlayerParam));
      this.c = true;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator.e(SystemClock.uptimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.deltatime.WSVerticalDeltaTimeCalculatorManager
 * JD-Core Version:    0.7.0.1
 */