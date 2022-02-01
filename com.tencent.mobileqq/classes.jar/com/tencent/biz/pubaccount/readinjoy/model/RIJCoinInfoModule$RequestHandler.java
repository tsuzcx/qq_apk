package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyRequestParams.Request0xed4Params;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.ReqBody;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.RspBody;

public abstract interface RIJCoinInfoModule$RequestHandler
{
  public abstract int a();
  
  public abstract void a(ReadInJoyRequestParams.Request0xed4Params paramRequest0xed4Params, oidb_cmd0xed4.ReqBody paramReqBody);
  
  public abstract void a(ToServiceMsg paramToServiceMsg, oidb_cmd0xed4.RspBody paramRspBody, int paramInt1, int paramInt2, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.RIJCoinInfoModule.RequestHandler
 * JD-Core Version:    0.7.0.1
 */