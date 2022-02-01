package com.tencent.biz.pubaccount.api;

import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import java.util.List;
import mqq.app.api.IRuntimeService;

@QRouteFactory(singleton=false)
@Service(process={"all"})
public abstract interface IPublicAccountDataManager
  extends IRuntimeService
{
  public abstract void decodeMessageRecord(ArrayList<MessageRecord> paramArrayList, AppInterface paramAppInterface);
  
  public abstract void delAccountDetailInfoCache(String paramString);
  
  public abstract void delPublicAccountInfo(String paramString);
  
  public abstract void delPublicAccountInfoCache(String paramString);
  
  public abstract IPublicAccountDetail findAccountDetailInfo(String paramString);
  
  public abstract IPublicAccountDetail findAccountDetailInfoCache(String paramString);
  
  public abstract Object findPublicAccountInfo(String paramString);
  
  public abstract Object findPublicAccountInfo(String paramString, boolean paramBoolean);
  
  public abstract Object findPublicAccountInfoCache(String paramString);
  
  public abstract Object getAccountInfo(String paramString);
  
  public abstract Object getPublicAccountEqqInfoList();
  
  public abstract List<Entity> getPublicAccountList();
  
  public abstract ArrayList<Entity> getPublicAccountListNotIVR();
  
  public abstract Object getPublicAccountScriptList();
  
  public abstract Object getPublicRecommendAccountList();
  
  public abstract void initPublicAccountDataManager();
  
  public abstract boolean isBuildingList();
  
  public abstract boolean isCached();
  
  public abstract boolean isCertifiedAccount(Object paramObject);
  
  public abstract boolean isFollowedUin(Long paramLong);
  
  public abstract boolean isFollowedUin(Long paramLong, boolean paramBoolean);
  
  public abstract boolean isSupportPay(String paramString);
  
  public abstract void refreshPublicRecommendList(Object paramObject);
  
  public abstract void saveAccountDetailInfoCache(Object paramObject);
  
  public abstract Object saveEqqAccountInfos(Object paramObject, long paramLong);
  
  public abstract void savePublicAccountInfo(Object paramObject);
  
  public abstract Object savePublicAccountInfos(Object paramObject, long paramLong, boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.IPublicAccountDataManager
 * JD-Core Version:    0.7.0.1
 */