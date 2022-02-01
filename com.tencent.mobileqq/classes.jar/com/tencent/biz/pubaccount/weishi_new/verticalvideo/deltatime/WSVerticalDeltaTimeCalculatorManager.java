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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onPlayVideo] position:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", mHasPlayFirstVideo:");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(", mHasFirstVideoStarted:");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(", title:");
    ((StringBuilder)localObject).append(a(paramWSPlayerParam));
    WSLog.e("WSVerticalDeltaTimeCalculatorManager", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator;
    if ((localObject != null) && (paramInt == 0) && (!this.b))
    {
      this.b = true;
      ((IWSVerticalDeltaTimeCalculator)localObject).b(SystemClock.uptimeMillis());
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator != null) && (paramInt == 1) && (!this.c))
    {
      this.c = true;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onPlayVideo] firstVideoNotStarted! secondVideoTitle:");
      ((StringBuilder)localObject).append(a(paramWSPlayerParam));
      WSLog.d("WSVerticalDeltaTimeCalculatorManager", ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator.c(SystemClock.uptimeMillis());
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onVideoStarted] mHasFirstVideoStarted:");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(", title:");
    ((StringBuilder)localObject).append(a(paramWSPlayerParam));
    WSLog.e("WSVerticalDeltaTimeCalculatorManager", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator;
    if ((localObject != null) && (!this.c))
    {
      this.c = true;
      ((IWSVerticalDeltaTimeCalculator)localObject).a(SystemClock.uptimeMillis(), paramWSPlayerParam);
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt1, int paramInt2, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator != null) && (!this.c))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onVideoError] firstVideoNotStarted! model:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", what:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", errorMsg:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", title:");
      localStringBuilder.append(a(paramWSPlayerParam));
      WSLog.d("WSVerticalDeltaTimeCalculatorManager", localStringBuilder.toString());
      paramWSPlayerParam = new StringBuilder();
      paramWSPlayerParam.append(paramInt1);
      paramWSPlayerParam.append(":");
      paramWSPlayerParam.append(paramInt2);
      paramWSPlayerParam = paramWSPlayerParam.toString();
      this.c = true;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator.a(SystemClock.uptimeMillis(), paramWSPlayerParam, paramString);
    }
  }
  
  public void a(WSVerticalItemData paramWSVerticalItemData)
  {
    WSLog.e("WSVerticalDeltaTimeCalculatorManager", "[onViewCreated]");
    IWSVerticalDeltaTimeCalculator localIWSVerticalDeltaTimeCalculator = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator;
    if (localIWSVerticalDeltaTimeCalculator != null) {
      localIWSVerticalDeltaTimeCalculator.a(SystemClock.uptimeMillis(), paramWSVerticalItemData);
    }
  }
  
  public void a(WSVerticalItemData paramWSVerticalItemData, int paramInt, String paramString1, String paramString2)
  {
    paramString1 = new StringBuilder();
    paramString1.append("[onBindFeedHolder] position:");
    paramString1.append(paramInt);
    paramString1.append(", mHasBindFirstHolder:");
    paramString1.append(this.jdField_a_of_type_Boolean);
    paramString1.append(", title:");
    paramString1.append(a(paramWSVerticalItemData));
    WSLog.e("WSVerticalDeltaTimeCalculatorManager", paramString1.toString());
    paramWSVerticalItemData = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator;
    if ((paramWSVerticalItemData != null) && (paramInt == 0) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      paramWSVerticalItemData.a(SystemClock.uptimeMillis());
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onCreate] from:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", isNeedCalcDeltaTime:");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", startPageUptime:");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(", mDeltaTimeCalculator:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator);
    WSLog.e("WSVerticalDeltaTimeCalculatorManager", ((StringBuilder)localObject).toString());
    if (!paramBoolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator = WSVerticalDeltaTimeFactory.a(paramString1);
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator;
    if (localObject != null) {
      ((IWSVerticalDeltaTimeCalculator)localObject).a(paramString1, paramString2, paramLong, SystemClock.uptimeMillis());
    }
  }
  
  public void b(WSPlayerParam paramWSPlayerParam)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator != null) && (!this.c))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onPause] firstVideoNotStarted! title:");
      localStringBuilder.append(a(paramWSPlayerParam));
      WSLog.d("WSVerticalDeltaTimeCalculatorManager", localStringBuilder.toString());
      this.c = true;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator.d(SystemClock.uptimeMillis());
    }
  }
  
  public void c(WSPlayerParam paramWSPlayerParam)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator != null) && (!this.c))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onExitVerticalPage] firstVideoNotStarted! title:");
      localStringBuilder.append(a(paramWSPlayerParam));
      WSLog.d("WSVerticalDeltaTimeCalculatorManager", localStringBuilder.toString());
      this.c = true;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeIWSVerticalDeltaTimeCalculator.e(SystemClock.uptimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.deltatime.WSVerticalDeltaTimeCalculatorManager
 * JD-Core Version:    0.7.0.1
 */