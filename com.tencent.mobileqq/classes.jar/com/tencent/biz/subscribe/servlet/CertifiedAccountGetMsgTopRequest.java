package com.tencent.biz.subscribe.servlet;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMsgPageTopReq;
import NS_COMM.COMM.StCommonExt;

public class CertifiedAccountGetMsgTopRequest
  extends ProtoBufRequest
{
  private CertifiedAccountRead.StGetMsgPageTopReq a = new CertifiedAccountRead.StGetMsgPageTopReq();
  
  public CertifiedAccountGetMsgTopRequest(COMM.StCommonExt paramStCommonExt)
  {
    if (paramStCommonExt != null) {
      this.a.extInfo.set(paramStCommonExt);
    }
  }
  
  public byte[] a()
  {
    return this.a.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.servlet.CertifiedAccountGetMsgTopRequest
 * JD-Core Version:    0.7.0.1
 */