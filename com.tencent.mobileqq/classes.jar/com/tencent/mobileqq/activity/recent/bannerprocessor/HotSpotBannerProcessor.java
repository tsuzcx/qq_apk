package com.tencent.mobileqq.activity.recent.bannerprocessor;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

@KeepClassConstructor
public class HotSpotBannerProcessor
  extends BaseBannerProcessor
{
  public static final int a = BannerTypeCollections.h;
  
  public HotSpotBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public int b()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.HotSpotBannerProcessor
 * JD-Core Version:    0.7.0.1
 */