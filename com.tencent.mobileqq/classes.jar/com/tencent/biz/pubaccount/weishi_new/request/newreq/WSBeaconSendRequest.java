package com.tencent.biz.pubaccount.weishi_new.request.newreq;

import UserGrowth.stWeishiDengtaReportReq;
import UserGrowth.stWeishiDengtaReportRsp;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WSBeaconSendRequest
  extends WSRequest<stWeishiDengtaReportRsp>
{
  private static final String CMD_STRING = "WeishiDengtaReport";
  private static final String TAG = "BeaconSendRequest";
  
  public WSBeaconSendRequest(String paramString, Map<String, String> paramMap)
  {
    super("WeishiDengtaReport");
    stWeishiDengtaReportReq localstWeishiDengtaReportReq = new stWeishiDengtaReportReq();
    localstWeishiDengtaReportReq.eventName = paramString;
    localstWeishiDengtaReportReq.params = checkValueNotnull(paramMap);
    this.req = localstWeishiDengtaReportReq;
    WSLog.b("BeaconSendRequest", "BeaconSendRequest = " + localstWeishiDengtaReportReq.toString());
  }
  
  private Map<String, String> checkValueNotnull(Map<String, String> paramMap)
  {
    Object localObject;
    if (paramMap == null)
    {
      localObject = new HashMap();
      return localObject;
    }
    Iterator localIterator = paramMap.entrySet().iterator();
    for (;;)
    {
      localObject = paramMap;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (Map.Entry)localIterator.next();
      if (((Map.Entry)localObject).getValue() == null) {
        ((Map.Entry)localObject).setValue("");
      }
    }
  }
  
  public Class<stWeishiDengtaReportRsp> getRspClass()
  {
    return stWeishiDengtaReportRsp.class;
  }
  
  public boolean isHeaderNeedExpABTestData()
  {
    return false;
  }
  
  public boolean isReportPerformance()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.newreq.WSBeaconSendRequest
 * JD-Core Version:    0.7.0.1
 */