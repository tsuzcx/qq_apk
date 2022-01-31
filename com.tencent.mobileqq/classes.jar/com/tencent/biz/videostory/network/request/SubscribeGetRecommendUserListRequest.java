package com.tencent.biz.videostory.network.request;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetRecommendUserListReq;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetRecommendUserListRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class SubscribeGetRecommendUserListRequest
  extends VSBaseRequest
{
  private CertifiedAccountRead.StGetRecommendUserListReq req = new CertifiedAccountRead.StGetRecommendUserListReq();
  
  public SubscribeGetRecommendUserListRequest(String paramString, COMM.StCommonExt paramStCommonExt, int paramInt1, int paramInt2)
  {
    this.req.userId.set(paramString);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
    this.req.listNum.set(paramInt1);
    this.req.from.set(paramInt2);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    CertifiedAccountRead.StGetRecommendUserListRsp localStGetRecommendUserListRsp = new CertifiedAccountRead.StGetRecommendUserListRsp();
    localStGetRecommendUserListRsp.mergeFrom(paramArrayOfByte);
    return localStGetRecommendUserListRsp;
  }
  
  public String getCmdName()
  {
    return "CertifiedAccountSvc.certified_account_read.GetRecommendUserList";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.network.request.SubscribeGetRecommendUserListRequest
 * JD-Core Version:    0.7.0.1
 */