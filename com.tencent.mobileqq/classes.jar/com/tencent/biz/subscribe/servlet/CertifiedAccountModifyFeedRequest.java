package com.tencent.biz.subscribe.servlet;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StModifyFeedReq;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StModifyFeedRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;

public class CertifiedAccountModifyFeedRequest
  extends ProtoBufRequest
{
  private CertifiedAccountWrite.StModifyFeedReq b = new CertifiedAccountWrite.StModifyFeedReq();
  
  public CertifiedAccountModifyFeedRequest(COMM.StCommonExt paramStCommonExt, CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStCommonExt != null) {
      this.b.extInfo.set(paramStCommonExt);
    }
    if (paramStFeed != null) {
      this.b.feed.set(paramStFeed);
    }
    this.b.mBitmap.set(1L);
  }
  
  public static CertifiedAccountWrite.StModifyFeedRsp a(byte[] paramArrayOfByte)
  {
    Object localObject = new CertifiedAccountWrite.StModifyFeedRsp();
    try
    {
      paramArrayOfByte = (CertifiedAccountWrite.StModifyFeedRsp)((CertifiedAccountWrite.StModifyFeedRsp)localObject).mergeFrom(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("CertifiedAccountModifyFeedRequest", 2, ((StringBuilder)localObject).toString());
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
 * Qualified Name:     com.tencent.biz.subscribe.servlet.CertifiedAccountModifyFeedRequest
 * JD-Core Version:    0.7.0.1
 */