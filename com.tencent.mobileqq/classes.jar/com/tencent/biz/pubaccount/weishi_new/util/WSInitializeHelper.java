package com.tencent.biz.pubaccount.weishi_new.util;

import com.tencent.biz.pubaccount.weishi_new.aiolist.WSAioListHelper;
import com.tencent.biz.pubaccount.weishi_new.cache.WSRedDotPreloadManager;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.report.WSLaunchDeltaTimeCalculator;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;

public class WSInitializeHelper
{
  private int jdField_a_of_type_Int;
  private WSLaunchDeltaTimeCalculator jdField_a_of_type_ComTencentBizPubaccountWeishi_newReportWSLaunchDeltaTimeCalculator;
  private String jdField_a_of_type_JavaLangString;
  
  public static WSInitializeHelper a()
  {
    return WSInitializeHelper.SingletonHolder.a();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public WSLaunchDeltaTimeCalculator a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newReportWSLaunchDeltaTimeCalculator == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newReportWSLaunchDeltaTimeCalculator = new WSLaunchDeltaTimeCalculator();
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newReportWSLaunchDeltaTimeCalculator;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    WSReportUtils.a("QQ_official_account");
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b()
  {
    WSReportUtils.a("weishi_share_trendstab");
    ((IVasAdvApi)QRoute.api(IVasAdvApi.class)).initTbsEnvironment();
  }
  
  public void c()
  {
    WSExpABTestManager.a().a();
    WSRedDotPreloadManager.a().a();
  }
  
  public void d()
  {
    WSRedDotPushMsg localWSRedDotPushMsg = WeishiUtils.a();
    if (localWSRedDotPushMsg != null) {
      this.jdField_a_of_type_JavaLangString = localWSRedDotPushMsg.mPushId;
    }
    this.jdField_a_of_type_Int = 0;
    WSAioListHelper.b();
  }
  
  public void e()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newReportWSLaunchDeltaTimeCalculator = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSInitializeHelper
 * JD-Core Version:    0.7.0.1
 */