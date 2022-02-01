package com.tencent.biz.pubaccount.weishi_new.request;

import UserGrowth.stQQGroupDetailReq;
import UserGrowth.stQQGroupDetailRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

public class QQGroupDetailRequest
  extends WeishiRequest<stQQGroupDetailRsp>
{
  public QQGroupDetailRequest(String paramString1, String paramString2)
  {
    super("QQGroupDetail");
    stQQGroupDetailReq localstQQGroupDetailReq = new stQQGroupDetailReq();
    localstQQGroupDetailReq.groupId = paramString1;
    localstQQGroupDetailReq.posterPersonId = paramString2;
    this.a = localstQQGroupDetailReq;
    this.f = 15000L;
    paramString1 = new StringBuilder();
    paramString1.append("QQGroupDetailRequest  = ");
    paramString1.append(localstQQGroupDetailReq.toString());
    WSLog.d("QQGroupDetailRequest", paramString1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.QQGroupDetailRequest
 * JD-Core Version:    0.7.0.1
 */