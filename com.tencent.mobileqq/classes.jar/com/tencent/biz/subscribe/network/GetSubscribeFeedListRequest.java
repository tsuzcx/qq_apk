package com.tencent.biz.subscribe.network;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedListReq;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedListRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.vac_adv_get.VacFeedsAdvMetaReq;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import wsx;

public class GetSubscribeFeedListRequest
  extends VSBaseRequest
{
  public static final int SOURCE_TYPE_DETAIL = 1;
  public static final int SOURCE_TYPE_RECOMMEND = 0;
  private CertifiedAccountRead.StGetFeedListReq req;
  
  public GetSubscribeFeedListRequest(int paramInt, COMM.StCommonExt paramStCommonExt, String paramString)
  {
    this.req = new CertifiedAccountRead.StGetFeedListReq();
    this.req.from.set(0);
    this.req.source.set(paramInt);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt.get());
    }
    paramStCommonExt = wsx.a().a();
    if (paramStCommonExt != null)
    {
      vac_adv_get.VacFeedsAdvMetaReq localVacFeedsAdvMetaReq = new vac_adv_get.VacFeedsAdvMetaReq();
      localVacFeedsAdvMetaReq.device_info.set(paramStCommonExt);
      this.req.adres.set(ByteStringMicro.copyFrom(localVacFeedsAdvMetaReq.toByteArray()));
    }
    if (paramString != null) {
      this.req.adAttchInfo.set(paramString);
    }
  }
  
  public GetSubscribeFeedListRequest(CertifiedAccountMeta.StFeed paramStFeed, int paramInt, COMM.StCommonExt paramStCommonExt, String paramString)
  {
    if (paramStFeed == null) {
      QLog.w("VSBaseRequest", 1, "stfeed is null");
    }
    do
    {
      return;
      this.req = new CertifiedAccountRead.StGetFeedListReq();
      this.req.from.set(0);
      this.req.feed.set(paramStFeed);
      this.req.source.set(paramInt);
      if (paramStCommonExt != null) {
        this.req.extInfo.set(paramStCommonExt.get());
      }
      paramStFeed = wsx.a().a();
      if (paramStFeed != null)
      {
        paramStCommonExt = new vac_adv_get.VacFeedsAdvMetaReq();
        paramStCommonExt.device_info.set(paramStFeed);
        this.req.adres.set(ByteStringMicro.copyFrom(paramStCommonExt.toByteArray()));
      }
    } while (paramString == null);
    this.req.adAttchInfo.set(paramString);
  }
  
  public GetSubscribeFeedListRequest(CertifiedAccountMeta.StFeed paramStFeed, String paramString)
  {
    this(paramStFeed, 1, null, paramString);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    CertifiedAccountRead.StGetFeedListRsp localStGetFeedListRsp = new CertifiedAccountRead.StGetFeedListRsp();
    localStGetFeedListRsp.mergeFrom(paramArrayOfByte);
    return localStGetFeedListRsp;
  }
  
  public String getCmdName()
  {
    return "CertifiedAccountSvc.certified_account_read.GetFeedList";
  }
  
  public byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.network.GetSubscribeFeedListRequest
 * JD-Core Version:    0.7.0.1
 */