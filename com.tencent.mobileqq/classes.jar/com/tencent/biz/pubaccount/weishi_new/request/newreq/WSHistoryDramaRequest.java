package com.tencent.biz.pubaccount.weishi_new.request.newreq;

import UserGrowth.stGetHistoryDramaReq;
import UserGrowth.stGetHistoryDramaRsp;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;

public class WSHistoryDramaRequest
  extends WSRequest<stGetHistoryDramaRsp>
{
  private static final String CMD_STRING = "GetHistoryDrama";
  
  public WSHistoryDramaRequest(String paramString1, String paramString2)
  {
    super("GetHistoryDrama");
    stGetHistoryDramaReq localstGetHistoryDramaReq = new stGetHistoryDramaReq();
    localstGetHistoryDramaReq.personID = paramString1;
    localstGetHistoryDramaReq.attachInfo = paramString2;
    this.req = localstGetHistoryDramaReq;
  }
  
  public Class<stGetHistoryDramaRsp> getRspClass()
  {
    return stGetHistoryDramaRsp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.newreq.WSHistoryDramaRequest
 * JD-Core Version:    0.7.0.1
 */