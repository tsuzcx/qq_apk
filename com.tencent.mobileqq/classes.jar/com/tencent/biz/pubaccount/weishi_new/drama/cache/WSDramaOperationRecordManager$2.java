package com.tencent.biz.pubaccount.weishi_new.drama.cache;

import UserGrowth.stUpdateFollowDramaRsp;
import com.tencent.biz.pubaccount.weishi_new.event.WSDramaFollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

final class WSDramaOperationRecordManager$2
  extends ServiceCallback<stUpdateFollowDramaRsp, stUpdateFollowDramaRsp>
{
  WSDramaOperationRecordManager$2(String paramString, IFetchDataListener paramIFetchDataListener) {}
  
  protected stUpdateFollowDramaRsp a(WSRequest<stUpdateFollowDramaRsp> paramWSRequest, stUpdateFollowDramaRsp paramstUpdateFollowDramaRsp, RspHeaderBean paramRspHeaderBean)
  {
    return paramstUpdateFollowDramaRsp;
  }
  
  protected void a(stUpdateFollowDramaRsp paramstUpdateFollowDramaRsp)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[followDrama] successOnUIThread status:");
    ((StringBuilder)localObject).append(paramstUpdateFollowDramaRsp.isFollow);
    WSLog.a("WSDramaOperationRecordManager", ((StringBuilder)localObject).toString());
    localObject = new WSDramaFollowEvent(this.jdField_a_of_type_JavaLangString, paramstUpdateFollowDramaRsp.isFollow);
    WSSimpleEventBus.a().a((WSSimpleBaseEvent)localObject);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheIFetchDataListener.a(Integer.valueOf(paramstUpdateFollowDramaRsp.isFollow));
  }
  
  protected void a(WSServiceErrorInfo paramWSServiceErrorInfo) {}
  
  protected void b(WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[followDrama] failureOnUIThread errCode:");
    localStringBuilder.append(paramWSServiceErrorInfo.a());
    localStringBuilder.append(", errMsg:");
    localStringBuilder.append(paramWSServiceErrorInfo.a());
    WSLog.a("WSDramaOperationRecordManager", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheIFetchDataListener.a(paramWSServiceErrorInfo.a(), paramWSServiceErrorInfo.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaOperationRecordManager.2
 * JD-Core Version:    0.7.0.1
 */