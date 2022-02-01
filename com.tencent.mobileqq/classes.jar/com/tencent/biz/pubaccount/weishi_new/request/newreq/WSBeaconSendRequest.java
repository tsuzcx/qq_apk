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
    paramString = new StringBuilder();
    paramString.append("BeaconSendRequest = ");
    paramString.append(localstWeishiDengtaReportReq.toString());
    WSLog.b("BeaconSendRequest", paramString.toString());
  }
  
  private Map<String, String> checkValueNotnull(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return new HashMap();
    }
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry.getValue() == null) {
        localEntry.setValue("");
      }
    }
    return paramMap;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.newreq.WSBeaconSendRequest
 * JD-Core Version:    0.7.0.1
 */