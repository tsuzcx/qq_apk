package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SubscribeGetRecommendUserListRequest;

public class FollowedRecommendBannerModel
{
  private COMM.StCommonExt a;
  private FollowedRecommendBannerModel.ResultListener b;
  private long c;
  
  public COMM.StCommonExt a()
  {
    return this.a;
  }
  
  public void a(FollowedRecommendBannerModel.ResultListener paramResultListener)
  {
    this.b = paramResultListener;
  }
  
  public void a(String paramString)
  {
    this.c = System.currentTimeMillis();
    paramString = new SubscribeGetRecommendUserListRequest(paramString, this.a, 0, 1);
    VSNetworkHelper.getInstance().sendRequest(paramString, new FollowedRecommendBannerModel.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerModel
 * JD-Core Version:    0.7.0.1
 */