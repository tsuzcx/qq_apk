package com.tencent.biz.subscribe.network;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDelFeedReq;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDelFeedRsp;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;

public class SubscribeDeleteFeedRequest
  extends VSBaseRequest
{
  private CertifiedAccountWrite.StDelFeedReq req;
  
  public SubscribeDeleteFeedRequest(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null)
    {
      QLog.w("VSBaseRequest", 1, "stfeed is null");
      return;
    }
    this.req = new CertifiedAccountWrite.StDelFeedReq();
    this.req.from.set(0);
    this.req.feed.set(paramStFeed);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    CertifiedAccountWrite.StDelFeedRsp localStDelFeedRsp = new CertifiedAccountWrite.StDelFeedRsp();
    localStDelFeedRsp.mergeFrom(paramArrayOfByte);
    return localStDelFeedRsp;
  }
  
  public String getCmdName()
  {
    return "CertifiedAccountSvc.certified_account_write.DelFeed";
  }
  
  public byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.network.SubscribeDeleteFeedRequest
 * JD-Core Version:    0.7.0.1
 */