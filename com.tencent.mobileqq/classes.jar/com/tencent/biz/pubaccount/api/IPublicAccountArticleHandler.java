package com.tencent.biz.pubaccount.api;

import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.RecommendItemInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.ArrayList;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IPublicAccountArticleHandler
  extends QRouteApi
{
  public static final String CMD_ARTICLE_LIKE = "PubAccountArticleCenter.ArticleLike";
  public static final String CMD_CHECK_ARTICLE_LIKE = "PubAccountArticleCenter.CheckArticleLike";
  public static final String CMD_CREATE_ARTICLE_COMMENT = "PubAccountArticleCenter.CreateArticleComment";
  public static final String CMD_GET_ARTICLE_COMMENT_COUNT = "PubAccountArticleCenter.GetArticleCommentCount";
  public static final String CMD_GET_ARTICLE_LIKE_COUNT = "PubAccountArticleCenter.GetArticleLikeCount";
  public static final String CMD_GET_PHOTO_COLLECTION_INFO = "PubAccountArticleCenter.PictureInfo";
  public static final String CMD_GET_RECOMMEND_INFO = "PubAccountArticleCenter.GetRecommendInfo";
  public static final String CMD_REPORT_READ_PHOTO_COLLECTION = "PubAccountArticleCenter.GalleryReport";
  public static final int TYPE_ARTICLE_LIKE = 0;
  public static final int TYPE_CHECK_ARTICLE_LIKE = 1;
  public static final int TYPE_CREATE_ARTICLE_COMMENT = 3;
  public static final int TYPE_GET_ARTICLE_COMMENT_COUNT = 4;
  public static final int TYPE_GET_ARTICLE_LIKE_COUNT = 2;
  public static final int TYPE_GET_PHOTO_COLLECTION_INFO = 5;
  public static final int TYPE_GET_RECOMMEND_INFO = 6;
  public static final int TYPE_REPORT_READ_PHOTO_COLLECTION = 7;
  public static final String VALUE_ARTICLE_COMMENT_COUNT = "VALUE_ARTICLE_COMMENT_COUNT";
  public static final String VALUE_ARTICLE_ID = "VALUE_ARTICLE_ID";
  public static final String VALUE_ARTICLE_IMAGEE_IS_SUCCESS = "VALUE_ARTICLE_IMAGEE_IS_SUCCESS";
  public static final String VALUE_ARTICLE_IS_LIKED = "VALUE_ARTICLE_IS_LIKED";
  public static final String VALUE_ARTICLE_IS_LIKE_SUCCESS = "VALUE_ARTICLE_IS_LIKE_SUCCESS";
  public static final String VALUE_ARTICLE_ITEM_COLLECTION_ARTICLE_URLS = "VALUE_ARTICLE_ITEM_COLLECTION_ARTICLE_URLS";
  public static final String VALUE_ARTICLE_ITEM_COLLECTION_CONTENTS = "VALUE_ARTICLE_ITEM_CONTENTS";
  public static final String VALUE_ARTICLE_ITEM_COLLECTION_IMG_URL = "VALUE_ARTICLE_ITEM_COLLECTION_IMG_URL";
  public static final String VALUE_ARTICLE_ITEM_COLLECTION_TITLE = "VALUE_ARTICLE_ITEM_COLLECTION_TITLE";
  public static final String VALUE_ARTICLE_ITEM_COLLECTION_URLS = "VALUE_ARTICLE_ITEM_URLS";
  public static final String VALUE_ARTICLE_ITEM_COMMENT_URL = "VALUE_ARTICLE_ITEM_COMMENT_URL";
  public static final String VALUE_ARTICLE_ITEM_RECOMMEND_CAN = "VALUE_ARTICLE_ITEM_RECOMMEND_CAN";
  public static final String VALUE_ARTICLE_ITEM_RECOMMEND_RECOMMEND_ARTICLE_ID = "VALUE_ARTICLE_ITEM_RECOMMEND_RECOMMEND_ARTICLE_ID";
  public static final String VALUE_ARTICLE_ITEM_RECOMMEND_RECOMMEND_SOURCE = "VALUE_ARTICLE_ITEM_RECOMMEND_RECOMMEND_SOURCE";
  public static final String VALUE_ARTICLE_ITEM_RECOMMEND_TITLES = "VALUE_ARTICLE_ITEM_RECOMMEND_TITLES";
  public static final String VALUE_ARTICLE_ITEM_RECOMMEND_URLS = "VALUE_ARTICLE_ITEM_RECOMMEND_URLS";
  public static final String VALUE_ARTICLE_LIKE_COUNT = "VALUE_ARTICLE_LIKE_COUNT";
  public static final String VALUE_ARTICLE_PUIN = "VALUE_ARTICLE_PUIN";
  
  public abstract void checkIsArticleLiked(String paramString);
  
  public abstract void createArticleComment(String paramString1, String paramString2, int paramInt);
  
  public abstract void getArticleCommentCount(String paramString);
  
  public abstract void getPhotoCollectionInfo(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract void getRecommendInfo(String paramString);
  
  public abstract void queryArticleLikeCount(String paramString);
  
  public abstract void queryArticleReadCount(String paramString);
  
  public abstract void removePublicAccountArticleObserver();
  
  public abstract void reportReadPhotoCollection(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3, ArrayList<IPublicAccountImageCollectionUtils.RecommendItemInfo> paramArrayList);
  
  public abstract void sendArticleLikeReq(String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void setPublicAccountArticleObserver(IPublicAccountArticleObserver paramIPublicAccountArticleObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.IPublicAccountArticleHandler
 * JD-Core Version:    0.7.0.1
 */