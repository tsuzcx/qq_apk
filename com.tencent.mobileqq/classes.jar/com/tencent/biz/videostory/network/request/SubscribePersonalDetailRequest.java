package com.tencent.biz.videostory.network.request;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageReq;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import NS_COMM.COMM.StCommonExt;
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
    localStGetMainPageRsp.mergeFrom(paramArrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.network.request.SubscribePersonalDetailRequest
 * JD-Core Version:    0.7.0.1
 */