package com.tencent.biz.pubaccount.AccountDetail.model.api;

import com.tencent.biz.pubaccount.AccountDetail.bean.AccountDetailDynamicInfo;
import com.tencent.biz.pubaccount.AccountDetail.bean.DynamicInfo;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IPublicAccountDetailDynamicDataManagerService
  extends IRuntimeService
{
  public abstract AccountDetailDynamicInfo getAccountDetailDynamicInfoFromCache(long paramLong);
  
  public abstract AccountDetailDynamicInfo getAccountDetailDynamicInfoFromCache(String paramString);
  
  public abstract void getDynamicListForFirstEnterFromDB(QQAppInterface paramQQAppInterface, long paramLong, PublicAccountObserver paramPublicAccountObserver);
  
  public abstract ArrayList<DynamicInfo> getDynamicListFromCache(long paramLong);
  
  public abstract int updateAccountDetailDynamicInfo(byte[] paramArrayOfByte, boolean paramBoolean1, long paramLong1, long paramLong2, long paramLong3, ArrayList<String> paramArrayList, boolean paramBoolean2);
  
  public abstract int updateAccountDetailDynamicInfoCache(boolean paramBoolean1, long paramLong1, long paramLong2, long paramLong3, ArrayList<String> paramArrayList, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.model.api.IPublicAccountDetailDynamicDataManagerService
 * JD-Core Version:    0.7.0.1
 */