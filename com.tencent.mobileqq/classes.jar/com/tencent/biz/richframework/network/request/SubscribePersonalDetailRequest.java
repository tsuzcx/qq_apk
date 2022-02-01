package com.tencent.biz.richframework.network.request;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageReq;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;

public class SubscribePersonalDetailRequest
  extends VSBaseRequest
{
  private CertifiedAccountRead.StGetMainPageReq req = new CertifiedAccountRead.StGetMainPageReq();
  
  public SubscribePersonalDetailRequest(String paramString, COMM.StCommonExt paramStCommonExt)
  {
    if (paramString != null) {
      this.req.userId.set(paramString);
    }
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    CertifiedAccountRead.StGetMainPageRsp localStGetMainPageRsp = new CertifiedAccountRead.StGetMainPageRsp();
    try
    {
      localStGetMainPageRsp.mergeFrom(paramArrayOfByte);
      return localStGetMainPageRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetMainPageRsp;
  }
  
  public String getCmdName()
  {
    return "CertifiedAccountSvc.certified_account_read.GetMainPage";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest
 * JD-Core Version:    0.7.0.1
 */