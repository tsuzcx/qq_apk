package com.tencent.biz.subscribe.network;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowFeedsReq;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowFeedsRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;

public class SubscribeGetFollowFeedsRequest
  extends VSBaseRequest
{
  private CertifiedAccountRead.StGetFollowFeedsReq mReq = new CertifiedAccountRead.StGetFollowFeedsReq();
  
  public SubscribeGetFollowFeedsRequest(COMM.StCommonExt paramStCommonExt)
  {
    if (paramStCommonExt != null) {
      this.mReq.extInfo.set(paramStCommonExt);
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    CertifiedAccountRead.StGetFollowFeedsRsp localStGetFollowFeedsRsp = new CertifiedAccountRead.StGetFollowFeedsRsp();
    localStGetFollowFeedsRsp.mergeFrom(paramArrayOfByte);
    return localStGetFollowFeedsRsp;
  }
  
  public String getCmdName()
  {
    return "CertifiedAccountSvc.certified_account_read.GetFollowFeeds";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.network.SubscribeGetFollowFeedsRequest
 * JD-Core Version:    0.7.0.1
 */