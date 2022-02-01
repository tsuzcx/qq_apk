package com.tencent.biz.pubaccount.weishi_new.profile.data;

import UserGrowth.stGetPersonalFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSProfileFeedsDataFetcher$1
  extends ServiceCallback<stGetPersonalFeedListRsp, WSProfileFeedsDataFetcher.ResponseModel>
{
  WSProfileFeedsDataFetcher$1(WSProfileFeedsDataFetcher paramWSProfileFeedsDataFetcher, WSProfileFeedsRequestParams paramWSProfileFeedsRequestParams) {}
  
  protected WSProfileFeedsDataFetcher.ResponseModel a(WSRequest<stGetPersonalFeedListRsp> paramWSRequest, stGetPersonalFeedListRsp paramstGetPersonalFeedListRsp, RspHeaderBean paramRspHeaderBean)
  {
    return WSProfileFeedsDataFetcher.a(this.b, paramstGetPersonalFeedListRsp, this.a);
  }
  
  protected void a(WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSProfileFeedsDataFetcher.java][failureOnSubThread] errorCode:");
    localStringBuilder.append(paramWSServiceErrorInfo.a());
    localStringBuilder.append(", errorMsg:");
    localStringBuilder.append(paramWSServiceErrorInfo.b());
    WSLog.e("WSProfileFeedsDataFetcher", localStringBuilder.toString());
  }
  
  protected void a(WSProfileFeedsDataFetcher.ResponseModel paramResponseModel)
  {
    super.a(paramResponseModel);
    WSProfileFeedsDataFetcher.a(this.b, this.a, paramResponseModel);
  }
  
  protected void b(WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    super.b(paramWSServiceErrorInfo);
    WSProfileFeedsDataFetcher.a(this.b, this.a, paramWSServiceErrorInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.data.WSProfileFeedsDataFetcher.1
 * JD-Core Version:    0.7.0.1
 */