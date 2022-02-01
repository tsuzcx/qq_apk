package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyRequestParams.Request0xed4Params;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyRequestParams.Request0xed4Params.CoinRewardReq;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.CoinRewardReq;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.MetaData;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.ReqBody;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.RspBody;

public class RIJCoinInfoModule$CoinRewardRequestHandler
  implements RIJCoinInfoModule.RequestHandler
{
  public int a()
  {
    return 3;
  }
  
  public void a(ReadInJoyRequestParams.Request0xed4Params paramRequest0xed4Params, oidb_cmd0xed4.ReqBody paramReqBody)
  {
    if ((paramRequest0xed4Params == null) || (paramReqBody == null)) {
      return;
    }
    paramReqBody.meta.type.set(3);
    paramReqBody.reward_req.setHasFlag(true);
    paramReqBody.reward_req.rowkey.set(paramRequest0xed4Params.jdField_a_of_type_JavaLangString);
    paramReqBody.reward_req.from_uin.set(ReadInJoyUtils.a());
    paramReqBody.reward_req.to_uin.set(paramRequest0xed4Params.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyRequestParams$Request0xed4Params$CoinRewardReq.jdField_a_of_type_Long);
    paramReqBody.reward_req.coin_cnt.set(paramRequest0xed4Params.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyRequestParams$Request0xed4Params$CoinRewardReq.jdField_a_of_type_Int);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, oidb_cmd0xed4.RspBody paramRspBody, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      ThreadManager.c(new RIJCoinInfoModule.CoinRewardRequestHandler.1(this, bool, paramInt2, paramString));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.RIJCoinInfoModule.CoinRewardRequestHandler
 * JD-Core Version:    0.7.0.1
 */