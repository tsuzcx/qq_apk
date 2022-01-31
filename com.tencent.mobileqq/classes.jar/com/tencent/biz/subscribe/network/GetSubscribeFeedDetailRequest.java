package com.tencent.biz.subscribe.network;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailReq;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;

public class GetSubscribeFeedDetailRequest
  extends VSBaseRequest
{
  private CertifiedAccountRead.StGetFeedDetailReq req;
  
  public GetSubscribeFeedDetailRequest(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this(paramStFeed, null, null);
  }
  
  public GetSubscribeFeedDetailRequest(CertifiedAccountMeta.StFeed paramStFeed, COMM.StCommonExt paramStCommonExt, String paramString)
  {
    if (paramStFeed == null) {
      QLog.w("VSBaseRequest", 1, "stfeed is null");
    }
    do
    {
      return;
      this.req = new CertifiedAccountRead.StGetFeedDetailReq();
      this.req.from.set(0);
      this.req.userId.set(paramStFeed.poster.id.get());
      this.req.feedId.set(paramStFeed.id.get());
      this.req.createTime.set(paramStFeed.createTime.get());
    } while (paramStCommonExt == null);
    this.req.extInfo.set(paramStCommonExt.get());
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    CertifiedAccountRead.StGetFeedDetailRsp localStGetFeedDetailRsp = new CertifiedAccountRead.StGetFeedDetailRsp();
    localStGetFeedDetailRsp.mergeFrom(paramArrayOfByte);
    return localStGetFeedDetailRsp;
  }
  
  public String getCmdName()
  {
    return "CertifiedAccountSvc.certified_account_read.GetFeedDetail";
  }
  
  public byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.network.GetSubscribeFeedDetailRequest
 * JD-Core Version:    0.7.0.1
 */