package com.tencent.biz.pubaccount.weishi_new.request.newreq;

import UserGrowth.stGetMsgRedDotReq;
import UserGrowth.stGetMsgRedDotRsp;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;

public class WSGetMsgRedDotRequest
  extends WSRequest<stGetMsgRedDotRsp>
{
  private static final String CMD_STRING = "GetMsgRedDot";
  
  public WSGetMsgRedDotRequest()
  {
    super("GetMsgRedDot");
    this.req = new stGetMsgRedDotReq();
  }
  
  public Class<stGetMsgRedDotRsp> getRspClass()
  {
    return stGetMsgRedDotRsp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.newreq.WSGetMsgRedDotRequest
 * JD-Core Version:    0.7.0.1
 */