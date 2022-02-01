package com.tencent.biz.pubaccount.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IPublicAccountSearchRecommendManager
  extends QRouteApi
{
  public abstract void getRecommendList(AppInterface paramAppInterface, boolean paramBoolean, IPublicAccountSearchRecommendManager.GetRecommendListListener paramGetRecommendListListener);
  
  public abstract void initFromLocalData(AppInterface paramAppInterface);
  
  public abstract void reset();
  
  public abstract void updatePublicAccountSearchHistoryItem(AppInterface paramAppInterface, String paramString1, String paramString2, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager
 * JD-Core Version:    0.7.0.1
 */