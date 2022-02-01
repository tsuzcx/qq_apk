package com.tencent.biz.pubaccount.weishi_new.util;

import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.cache.WSRedDotPreloadManager;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import cooperation.vip.VasAdvSupport;

public class WSInitializeHelper
{
  private int jdField_a_of_type_Int;
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  
  public static WSInitializeHelper a()
  {
    return WSInitializeHelper.SingletonHolder.a();
  }
  
  private void e()
  {
    WSExpABTestManager.a().a();
    WSRedDotPreloadManager.a().a();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public stSimpleMetaFeed a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    WSReportUtils.a("QQ_official_account");
    e();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = paramstSimpleMetaFeed;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    WSReportUtils.a("weishi_share_trendstab");
    e();
    VasAdvSupport.a().a();
  }
  
  public void c()
  {
    WSRedDotPushMsg localWSRedDotPushMsg = WeishiUtils.a();
    if (localWSRedDotPushMsg != null) {
      this.jdField_a_of_type_JavaLangString = localWSRedDotPushMsg.mPushId;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = null;
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSInitializeHelper
 * JD-Core Version:    0.7.0.1
 */