package com.tencent.biz.subscribe.network;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLike;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoLikeReq;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoLikeRsp;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class DoLikeRequest
  extends VSBaseRequest
{
  public static final int OPER_TYPE_CANCELL = 0;
  public static final int OPER_TYPE_PRAISED = 1;
  CertifiedAccountWrite.StDoLikeReq req = new CertifiedAccountWrite.StDoLikeReq();
  
  public DoLikeRequest(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return;
    }
    PBUInt32Field localPBUInt32Field = this.req.likeType;
    int i;
    if (paramStFeed.likeInfo.status.get() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    localPBUInt32Field.set(i);
    this.req.like.set(paramStFeed.likeInfo);
    this.req.feed.set(paramStFeed);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    CertifiedAccountWrite.StDoLikeRsp localStDoLikeRsp = new CertifiedAccountWrite.StDoLikeRsp();
    try
    {
      localStDoLikeRsp.mergeFrom(paramArrayOfByte);
      return localStDoLikeRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStDoLikeRsp;
  }
  
  public String getCmdName()
  {
    return "CertifiedAccountSvc.certified_account_write.DoLike";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.network.DoLikeRequest
 * JD-Core Version:    0.7.0.1
 */