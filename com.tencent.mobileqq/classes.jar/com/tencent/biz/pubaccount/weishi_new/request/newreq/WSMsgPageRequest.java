package com.tencent.biz.pubaccount.weishi_new.request.newreq;

import UserGrowth.stGetFirstPageMsgListReq;
import UserGrowth.stGetFirstPageMsgListRsp;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;

public class WSMsgPageRequest
  extends WSRequest<stGetFirstPageMsgListRsp>
{
  private static final String CMD_STRING = "GetFirstPageMsgList";
  
  public WSMsgPageRequest(String paramString)
  {
    super("GetFirstPageMsgList");
    this.req = new stGetFirstPageMsgListReq(paramString);
  }
  
  public Class<stGetFirstPageMsgListRsp> getRspClass()
  {
    return stGetFirstPageMsgListRsp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.newreq.WSMsgPageRequest
 * JD-Core Version:    0.7.0.1
 */