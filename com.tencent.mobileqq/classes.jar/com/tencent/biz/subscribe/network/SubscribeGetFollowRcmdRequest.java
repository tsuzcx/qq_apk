package com.tencent.biz.subscribe.network;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowRcmdReq;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowRcmdRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;

public class SubscribeGetFollowRcmdRequest
  extends VSBaseRequest
{
  private CertifiedAccountRead.StGetFollowRcmdReq mReq = new CertifiedAccountRead.StGetFollowRcmdReq();
  
  public SubscribeGetFollowRcmdRequest(COMM.StCommonExt paramStCommonExt)
  {
    if (paramStCommonExt != null) {
      this.mReq.extInfo.set(paramStCommonExt);
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    CertifiedAccountRead.StGetFollowRcmdRsp localStGetFollowRcmdRsp = new CertifiedAccountRead.StGetFollowRcmdRsp();
    try
    {
      localStGetFollowRcmdRsp.mergeFrom(paramArrayOfByte);
      return localStGetFollowRcmdRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetFollowRcmdRsp;
  }
  
  public String getCmdName()
  {
    return "CertifiedAccountSvc.certified_account_read.GetFollowRcmd";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.network.SubscribeGetFollowRcmdRequest
 * JD-Core Version:    0.7.0.1
 */