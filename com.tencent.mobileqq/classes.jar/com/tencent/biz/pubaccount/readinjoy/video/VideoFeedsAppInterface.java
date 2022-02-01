package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Bundle;
import com.tencent.biz.pubaccount.PublicAccountArticleHandler;
import com.tencent.biz.pubaccount.VideoPlayCountHandler;
import com.tencent.biz.pubaccount.VideoPlayRecommendHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseToolAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.qphone.base.util.BaseApplication;

public class VideoFeedsAppInterface
  extends BaseToolAppInterface
{
  public static String a;
  public static final String b = VideoPlayRecommendHandler.class.getName();
  public static final String c = VideoPlayCountHandler.class.getName();
  public static final String d = PublicAccountArticleHandler.class.getName();
  private VideoFeedsService a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "com.tencent.mobileqq:tool";
  }
  
  public VideoFeedsAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.a();
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    return null;
  }
  
  public MobileQQServiceBase getMobileQQService()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsService;
  }
  
  public String getModuleId()
  {
    return "module_videofeeds";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsService = new VideoFeedsService(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppInterface
 * JD-Core Version:    0.7.0.1
 */