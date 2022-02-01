package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SubscribeGetRecommendUserListRequest;

public class FollowedRecommendBannerModel
{
  private long jdField_a_of_type_Long;
  private COMM.StCommonExt jdField_a_of_type_NS_COMMCOMM$StCommonExt;
  private FollowedRecommendBannerModel.ResultListener jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerFollowedRecommendBannerModel$ResultListener;
  
  public COMM.StCommonExt a()
  {
    return this.jdField_a_of_type_NS_COMMCOMM$StCommonExt;
  }
  
  public void a(FollowedRecommendBannerModel.ResultListener paramResultListener)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerFollowedRecommendBannerModel$ResultListener = paramResultListener;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramString = new SubscribeGetRecommendUserListRequest(paramString, this.jdField_a_of_type_NS_COMMCOMM$StCommonExt, 0, 1);
    VSNetworkHelper.getInstance().sendRequest(paramString, new FollowedRecommendBannerModel.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerModel
 * JD-Core Version:    0.7.0.1
 */