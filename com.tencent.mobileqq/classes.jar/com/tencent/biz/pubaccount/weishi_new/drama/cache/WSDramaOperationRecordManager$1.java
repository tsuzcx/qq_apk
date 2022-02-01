package com.tencent.biz.pubaccount.weishi_new.drama.cache;

import UserGrowth.stUpdateWatchDramaRsp;
import com.tencent.biz.pubaccount.weishi_new.event.WSDramaWatchRecordEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

final class WSDramaOperationRecordManager$1
  extends ServiceCallback<stUpdateWatchDramaRsp, String>
{
  WSDramaOperationRecordManager$1(String paramString1, String paramString2, int paramInt) {}
  
  protected String a(WSRequest<stUpdateWatchDramaRsp> paramWSRequest, stUpdateWatchDramaRsp paramstUpdateWatchDramaRsp, RspHeaderBean paramRspHeaderBean)
  {
    WSLog.a("WSDramaOperationRecordManager", "reportDramaWatchRecord() req success");
    return null;
  }
  
  protected void a(WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportDramaWatchRecord() req failed. errCode = ");
    localStringBuilder.append(paramWSServiceErrorInfo.a());
    localStringBuilder.append(", errMsg = ");
    localStringBuilder.append(paramWSServiceErrorInfo.b());
    WSLog.a("WSDramaOperationRecordManager", localStringBuilder.toString());
  }
  
  protected void a(String paramString)
  {
    paramString = new WSDramaWatchRecordEvent(this.a, this.b, this.c);
    WSSimpleEventBus.a().a(paramString);
  }
  
  protected void b(WSServiceErrorInfo paramWSServiceErrorInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaOperationRecordManager.1
 * JD-Core Version:    0.7.0.1
 */