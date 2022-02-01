package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyRequestParams.Request0xed4Params;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.CoinPresentReq;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.MetaData;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.ReqBody;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.RspBody;

public class RIJCoinInfoModule$CoinPresentRequestHandler
  implements RIJCoinInfoModule.RequestHandler
{
  public int a()
  {
    return 2;
  }
  
  public void a(ReadInJoyRequestParams.Request0xed4Params paramRequest0xed4Params, oidb_cmd0xed4.ReqBody paramReqBody)
  {
    if ((paramRequest0xed4Params == null) || (paramReqBody == null)) {
      return;
    }
    paramReqBody.meta.type.set(2);
    paramReqBody.present_req.setHasFlag(true);
    paramReqBody.present_req.uin.set(ReadInJoyUtils.a());
  }
  
  public void a(ToServiceMsg paramToServiceMsg, oidb_cmd0xed4.RspBody paramRspBody, int paramInt1, int paramInt2, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.RIJCoinInfoModule.CoinPresentRequestHandler
 * JD-Core Version:    0.7.0.1
 */