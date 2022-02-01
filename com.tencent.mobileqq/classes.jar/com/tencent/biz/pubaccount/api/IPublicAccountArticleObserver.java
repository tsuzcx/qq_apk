package com.tencent.biz.pubaccount.api;

import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.PhotoCollectionInfo;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.RecommendItemInfo;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.ArrayList;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IPublicAccountArticleObserver
  extends QRouteApi
{
  public abstract BusinessObserver getBusinessObserver();
  
  public abstract void onCheckIsArticleLiked(boolean paramBoolean1, String paramString, boolean paramBoolean2);
  
  public abstract void onCreateArticleCommentRespond(boolean paramBoolean, int paramInt);
  
  public abstract void onGetArticleCommentCountRespond(boolean paramBoolean, int paramInt);
  
  public abstract void onGetArticleReadCount(boolean paramBoolean, int paramInt);
  
  public abstract void onGetPhotoCollectionInfoRespond(IPublicAccountImageCollectionUtils.PhotoCollectionInfo paramPhotoCollectionInfo);
  
  public abstract void onGetPhotoCollectionInfoRespond(boolean paramBoolean, IPublicAccountImageCollectionUtils.PhotoCollectionInfo paramPhotoCollectionInfo, byte[] paramArrayOfByte, String paramString);
  
  public abstract void onGetRecommendInfoRespond(boolean paramBoolean, ArrayList<IPublicAccountImageCollectionUtils.RecommendItemInfo> paramArrayList);
  
  public abstract void onQueryArticleLikeCount(boolean paramBoolean, String paramString, int paramInt);
  
  public abstract void onReportReadPhotoCollectionRespond(boolean paramBoolean);
  
  public abstract void onSendArticleLikeReq(boolean paramBoolean, String paramString);
  
  public abstract void setOnCallback(IPublicAccountArticleObserver.OnCallback paramOnCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver
 * JD-Core Version:    0.7.0.1
 */