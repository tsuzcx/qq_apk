package com.tencent.biz.pubaccount.imagecollection.api;

import com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IPublicAccountImageCollectionPreloadManager
  extends QRouteApi
{
  public abstract void addTask(String paramString);
  
  public abstract boolean canPreload();
  
  public abstract void cancelNotDownloadTask();
  
  public abstract void checkDelDir();
  
  public abstract void doStatisticReportForImageHit(boolean paramBoolean, int paramInt);
  
  public abstract void doStatisticReportForImageTime(boolean paramBoolean, long paramLong);
  
  public abstract void doStatisticReportForProtoHit(boolean paramBoolean);
  
  public abstract IPublicAccountImageCollectionUtils.PhotoCollectionInfo getPhotoCollectionInfoFromCache(String paramString);
  
  public abstract void getPhotoCollectionInfoFromFile(String paramString, IPublicAccountArticleObserver paramIPublicAccountArticleObserver);
  
  public abstract int getPreloadImageCount();
  
  public abstract void preloadImage(IPublicAccountImageCollectionUtils.PhotoCollectionInfo paramPhotoCollectionInfo);
  
  public abstract void removeObserver();
  
  public abstract void saveImageCollectionInfo(IPublicAccountImageCollectionUtils.PhotoCollectionInfo paramPhotoCollectionInfo, byte[] paramArrayOfByte);
  
  public abstract void setObserver(IPublicAccountArticleObserver paramIPublicAccountArticleObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager
 * JD-Core Version:    0.7.0.1
 */