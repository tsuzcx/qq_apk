package com.tencent.biz.pubaccount.accountdetail.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IPublicAccountDetail
  extends QRouteApi
{
  public abstract void clone(IPublicAccountDetail paramIPublicAccountDetail);
  
  public abstract byte[] getAccountData();
  
  public abstract int getAccountFlag();
  
  public abstract long getAccountFlag2();
  
  public abstract long getCertifiedGrade();
  
  public abstract String getDisplayNumber();
  
  public abstract Entity getEntity();
  
  public abstract int getFollowType();
  
  public abstract long getId();
  
  public abstract String getName();
  
  public abstract int getReportAccountType(AppInterface paramAppInterface, String paramString);
  
  public abstract int getShowFlag();
  
  public abstract int getShowMsgFlag();
  
  public abstract String getSummary();
  
  public abstract String getUin();
  
  public abstract IPublicAccountDetail init(mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse);
  
  public abstract boolean isAgreeSyncLbs();
  
  public abstract boolean isRecvMsg();
  
  public abstract boolean isRecvPush();
  
  public abstract boolean isShowFollowButton();
  
  public abstract boolean isSyncLbs();
  
  public abstract boolean isSyncLbsSelected();
  
  public abstract void setFollowType(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail
 * JD-Core Version:    0.7.0.1
 */