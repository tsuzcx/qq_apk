package com.tencent.biz.pubaccount.weishi_new.request;

import UserGrowth.stGetTabsReq;
import UserGrowth.stGetTabsRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

public class GetTabsRequest
  extends WeishiRequest<stGetTabsRsp>
{
  public GetTabsRequest()
  {
    super("GetTabs", 10010);
    stGetTabsReq localstGetTabsReq = new stGetTabsReq();
    this.a = localstGetTabsReq;
    WSLog.d("GetTabsRequest", "stGetTabsReq  = " + localstGetTabsReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.GetTabsRequest
 * JD-Core Version:    0.7.0.1
 */