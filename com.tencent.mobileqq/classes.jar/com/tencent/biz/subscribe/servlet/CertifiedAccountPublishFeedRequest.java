package com.tencent.biz.subscribe.servlet;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StPublishFeedReq;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StPublishFeedRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.qphone.base.util.QLog;

public class CertifiedAccountPublishFeedRequest
  extends ProtoBufRequest
{
  private CertifiedAccountWrite.StPublishFeedReq b = new CertifiedAccountWrite.StPublishFeedReq();
  
  public CertifiedAccountPublishFeedRequest(COMM.StCommonExt paramStCommonExt, CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStCommonExt != null) {
      this.b.extInfo.set(paramStCommonExt);
    }
    if (paramStFeed != null) {
      this.b.feed.set(paramStFeed);
    }
  }
  
  public static CertifiedAccountWrite.StPublishFeedRsp a(byte[] paramArrayOfByte)
  {
    Object localObject = new CertifiedAccountWrite.StPublishFeedRsp();
    try
    {
      paramArrayOfByte = (CertifiedAccountWrite.StPublishFeedRsp)((CertifiedAccountWrite.StPublishFeedRsp)localObject).mergeFrom(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("CertifiedAccountGetMsgTopRequest", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public byte[] a()
  {
    return this.b.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.servlet.CertifiedAccountPublishFeedRequest
 * JD-Core Version:    0.7.0.1
 */