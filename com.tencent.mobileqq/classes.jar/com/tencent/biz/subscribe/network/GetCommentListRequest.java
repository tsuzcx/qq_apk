package com.tencent.biz.subscribe.network;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetCommentListReq;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetCommentListRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetCommentListRequest
  extends VSBaseRequest
{
  CertifiedAccountRead.StGetCommentListReq req = new CertifiedAccountRead.StGetCommentListReq();
  
  public GetCommentListRequest(CertifiedAccountMeta.StFeed paramStFeed, COMM.StCommonExt paramStCommonExt, int paramInt)
  {
    this.req.feedId.set(paramStFeed.id.get());
    this.req.userId.set(paramStFeed.poster.id.get());
    this.req.extInfo.set(paramStCommonExt);
    this.req.listNum.set(paramInt);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    CertifiedAccountRead.StGetCommentListRsp localStGetCommentListRsp = new CertifiedAccountRead.StGetCommentListRsp();
    try
    {
      localStGetCommentListRsp.mergeFrom(paramArrayOfByte);
      return localStGetCommentListRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetCommentListRsp;
  }
  
  public String getCmdName()
  {
    return "CertifiedAccountSvc.certified_account_read.GetCommentList";
  }
  
  public byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.network.GetCommentListRequest
 * JD-Core Version:    0.7.0.1
 */