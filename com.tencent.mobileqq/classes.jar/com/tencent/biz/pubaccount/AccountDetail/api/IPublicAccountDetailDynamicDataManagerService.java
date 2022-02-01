package com.tencent.biz.pubaccount.accountdetail.api;

import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IPublicAccountDetailDynamicDataManagerService
  extends IRuntimeService
{
  public abstract Object getAccountDetailDynamicInfoFromCache(long paramLong);
  
  public abstract Object getAccountDetailDynamicInfoFromCache(String paramString);
  
  public abstract void getDynamicListForFirstEnterFromDB(AppInterface paramAppInterface, long paramLong, IPublicAccountObserver paramIPublicAccountObserver);
  
  public abstract Object getDynamicListFromCache(long paramLong);
  
  public abstract int updateAccountDetailDynamicInfo(byte[] paramArrayOfByte, boolean paramBoolean1, long paramLong1, long paramLong2, long paramLong3, ArrayList<String> paramArrayList, boolean paramBoolean2);
  
  public abstract int updateAccountDetailDynamicInfoCache(boolean paramBoolean1, long paramLong1, long paramLong2, long paramLong3, ArrayList<String> paramArrayList, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailDynamicDataManagerService
 * JD-Core Version:    0.7.0.1
 */