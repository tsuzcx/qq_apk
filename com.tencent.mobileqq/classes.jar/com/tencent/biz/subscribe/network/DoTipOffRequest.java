package com.tencent.biz.subscribe.network;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoTipOffReq;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoTipOffRsp;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class DoTipOffRequest
  extends VSBaseRequest
{
  private CertifiedAccountWrite.StDoTipOffReq req = new CertifiedAccountWrite.StDoTipOffReq();
  
  public DoTipOffRequest(int paramInt1, CertifiedAccountMeta.StUser paramStUser, CertifiedAccountMeta.StFeed paramStFeed, int paramInt2)
  {
    this.req.tipOffType.set(paramInt1);
    if (paramStUser != null) {
      this.req.user.set(paramStUser);
    }
    if (paramStFeed != null) {
      this.req.feed.set(paramStFeed);
    }
    this.req.feedbackType.set(paramInt2);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    CertifiedAccountWrite.StDoTipOffRsp localStDoTipOffRsp = new CertifiedAccountWrite.StDoTipOffRsp();
    try
    {
      localStDoTipOffRsp.mergeFrom(paramArrayOfByte);
      return localStDoTipOffRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStDoTipOffRsp;
  }
  
  public String getCmdName()
  {
    return "CertifiedAccountSvc.certified_account_write.DoTipOff";
  }
  
  public byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.network.DoTipOffRequest
 * JD-Core Version:    0.7.0.1
 */