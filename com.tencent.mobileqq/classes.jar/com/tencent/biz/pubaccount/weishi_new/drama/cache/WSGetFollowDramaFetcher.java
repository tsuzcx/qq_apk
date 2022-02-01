package com.tencent.biz.pubaccount.weishi_new.drama.cache;

import UserGrowth.stGetFollowedDramasRsp;
import android.support.annotation.NonNull;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSFollowDramaData;
import com.tencent.biz.pubaccount.weishi_new.drama.utils.WSDramaUtils;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSNetService;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;
import com.tencent.biz.pubaccount.weishi_new.request.newreq.WSGetFollowDramaRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

public class WSGetFollowDramaFetcher
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  private WSGetFollowDramaFetcher.ResponseModel a(@NonNull WSRequest<stGetFollowedDramasRsp> paramWSRequest, @NonNull stGetFollowedDramasRsp paramstGetFollowedDramasRsp)
  {
    WeiShiCacheManager.a().a(paramstGetFollowedDramasRsp);
    paramWSRequest = new WSGetFollowDramaFetcher.ResponseModel(this);
    paramWSRequest.jdField_a_of_type_JavaLangString = paramstGetFollowedDramasRsp.attachInfo;
    paramWSRequest.jdField_a_of_type_Boolean = paramstGetFollowedDramasRsp.isFinished;
    WSFollowDramaData localWSFollowDramaData = new WSFollowDramaData();
    localWSFollowDramaData.a(paramstGetFollowedDramasRsp.title);
    localWSFollowDramaData.a(WSDramaUtils.a(paramstGetFollowedDramasRsp.dramas));
    paramWSRequest.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaDataWSFollowDramaData = localWSFollowDramaData;
    return paramWSRequest;
  }
  
  private void a(@NonNull WSGetFollowDramaFetcher.ResponseModel paramResponseModel, @NonNull IFetchDataListener<WSFollowDramaData> paramIFetchDataListener)
  {
    WSLog.a("WSGetFollowDramaFetcher", "request success.");
    paramIFetchDataListener.a(paramResponseModel.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaDataWSFollowDramaData);
    this.jdField_a_of_type_JavaLangString = paramResponseModel.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = paramResponseModel.jdField_a_of_type_Boolean;
  }
  
  private void a(@NonNull WSServiceErrorInfo paramWSServiceErrorInfo, @NonNull IFetchDataListener<WSFollowDramaData> paramIFetchDataListener)
  {
    paramIFetchDataListener = new StringBuilder();
    paramIFetchDataListener.append("request failed. errCode = ");
    paramIFetchDataListener.append(paramWSServiceErrorInfo.a());
    paramIFetchDataListener.append(", errMsg = ");
    paramIFetchDataListener.append(paramWSServiceErrorInfo.a());
    WSLog.a("WSGetFollowDramaFetcher", paramIFetchDataListener.toString());
  }
  
  public boolean a(@NonNull IFetchDataListener<WSFollowDramaData> paramIFetchDataListener)
  {
    WSNetService.a(new WSGetFollowDramaRequest(this.jdField_a_of_type_JavaLangString)).a(new WSGetFollowDramaFetcher.1(this, paramIFetchDataListener));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.cache.WSGetFollowDramaFetcher
 * JD-Core Version:    0.7.0.1
 */