package com.tencent.biz.pubaccount.api.impl;

import android.os.Bundle;
import com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver;
import com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver.OnCallback;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.PhotoCollectionInfo;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.RecommendItemInfo;
import com.tencent.mobileqq.app.BusinessObserver;
import java.util.ArrayList;

public class PublicAccountArticleObserverImpl
  implements IPublicAccountArticleObserver, BusinessObserver
{
  public static final String TAG = "Q.pubaccount.video.PublicAccountArticleObserver";
  private IPublicAccountArticleObserver.OnCallback mOnCallback;
  
  public BusinessObserver getBusinessObserver()
  {
    return this;
  }
  
  public void onCheckIsArticleLiked(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    IPublicAccountArticleObserver.OnCallback localOnCallback = this.mOnCallback;
    if (localOnCallback != null) {
      localOnCallback.a(paramBoolean1, paramString, paramBoolean2);
    }
  }
  
  public void onCreateArticleCommentRespond(boolean paramBoolean, int paramInt)
  {
    IPublicAccountArticleObserver.OnCallback localOnCallback = this.mOnCallback;
    if (localOnCallback != null) {
      localOnCallback.a(paramBoolean, paramInt);
    }
  }
  
  public void onGetArticleCommentCountRespond(boolean paramBoolean, int paramInt)
  {
    IPublicAccountArticleObserver.OnCallback localOnCallback = this.mOnCallback;
    if (localOnCallback != null) {
      localOnCallback.b(paramBoolean, paramInt);
    }
  }
  
  public void onGetArticleReadCount(boolean paramBoolean, int paramInt)
  {
    IPublicAccountArticleObserver.OnCallback localOnCallback = this.mOnCallback;
    if (localOnCallback != null) {
      localOnCallback.c(paramBoolean, paramInt);
    }
  }
  
  public void onGetPhotoCollectionInfoRespond(IPublicAccountImageCollectionUtils.PhotoCollectionInfo paramPhotoCollectionInfo)
  {
    IPublicAccountArticleObserver.OnCallback localOnCallback = this.mOnCallback;
    if (localOnCallback != null) {
      localOnCallback.a(paramPhotoCollectionInfo);
    }
  }
  
  public void onGetPhotoCollectionInfoRespond(boolean paramBoolean, IPublicAccountImageCollectionUtils.PhotoCollectionInfo paramPhotoCollectionInfo, byte[] paramArrayOfByte, String paramString)
  {
    IPublicAccountArticleObserver.OnCallback localOnCallback = this.mOnCallback;
    if (localOnCallback != null) {
      localOnCallback.a(paramBoolean, paramPhotoCollectionInfo, paramArrayOfByte, paramString);
    }
  }
  
  public void onGetRecommendInfoRespond(boolean paramBoolean, ArrayList<IPublicAccountImageCollectionUtils.RecommendItemInfo> paramArrayList)
  {
    IPublicAccountArticleObserver.OnCallback localOnCallback = this.mOnCallback;
    if (localOnCallback != null) {
      localOnCallback.a(paramBoolean, paramArrayList);
    }
  }
  
  public void onQueryArticleLikeCount(boolean paramBoolean, String paramString, int paramInt)
  {
    IPublicAccountArticleObserver.OnCallback localOnCallback = this.mOnCallback;
    if (localOnCallback != null) {
      localOnCallback.a(paramBoolean, paramString, paramInt);
    }
  }
  
  public void onReportReadPhotoCollectionRespond(boolean paramBoolean)
  {
    IPublicAccountArticleObserver.OnCallback localOnCallback = this.mOnCallback;
    if (localOnCallback != null) {
      localOnCallback.a(paramBoolean);
    }
  }
  
  public void onSendArticleLikeReq(boolean paramBoolean, String paramString)
  {
    IPublicAccountArticleObserver.OnCallback localOnCallback = this.mOnCallback;
    if (localOnCallback != null) {
      localOnCallback.a(paramBoolean, paramString);
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 4)
          {
            if ((paramInt != 5) && (paramInt != 6))
            {
              if (paramInt != 7) {
                return;
              }
              if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Bundle)))
              {
                if (((Bundle)paramObject).getBoolean("VALUE_ARTICLE_IMAGEE_IS_SUCCESS", false))
                {
                  paramObject = this.mOnCallback;
                  if (paramObject != null) {
                    paramObject.a(true);
                  }
                }
                else
                {
                  paramObject = this.mOnCallback;
                  if (paramObject != null) {
                    paramObject.a(false);
                  }
                }
              }
              else
              {
                paramObject = this.mOnCallback;
                if (paramObject != null) {
                  paramObject.a(false);
                }
              }
            }
          }
          else if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Bundle)))
          {
            paramObject = (Bundle)paramObject;
            if (paramObject.getBoolean("VALUE_ARTICLE_IMAGEE_IS_SUCCESS", false))
            {
              paramInt = paramObject.getInt("VALUE_ARTICLE_COMMENT_COUNT");
              paramObject = this.mOnCallback;
              if (paramObject != null) {
                paramObject.b(true, paramInt);
              }
            }
            else
            {
              paramObject = this.mOnCallback;
              if (paramObject != null) {
                paramObject.b(false, 0);
              }
            }
          }
          else
          {
            paramObject = this.mOnCallback;
            if (paramObject != null) {
              paramObject.b(false, 0);
            }
          }
        }
        else if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Bundle)))
        {
          localObject = (Bundle)paramObject;
          paramObject = ((Bundle)localObject).getString("VALUE_ARTICLE_ID");
          paramInt = ((Bundle)localObject).getInt("VALUE_ARTICLE_LIKE_COUNT");
          localObject = this.mOnCallback;
          if (localObject != null) {
            ((IPublicAccountArticleObserver.OnCallback)localObject).a(true, paramObject, paramInt);
          }
        }
        else
        {
          paramObject = this.mOnCallback;
          if (paramObject != null) {
            paramObject.a(false, null, 0);
          }
        }
      }
      else if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Bundle)))
      {
        localObject = (Bundle)paramObject;
        paramObject = ((Bundle)localObject).getString("VALUE_ARTICLE_ID");
        paramBoolean = ((Bundle)localObject).getBoolean("VALUE_ARTICLE_IS_LIKED");
        localObject = this.mOnCallback;
        if (localObject != null) {
          ((IPublicAccountArticleObserver.OnCallback)localObject).a(true, paramObject, Boolean.valueOf(paramBoolean).booleanValue());
        }
      }
      else
      {
        paramObject = this.mOnCallback;
        if (paramObject != null) {
          paramObject.a(false, null, false);
        }
      }
    }
    else if ((paramObject != null) && ((paramObject instanceof Bundle)))
    {
      paramObject = ((Bundle)paramObject).getString("VALUE_ARTICLE_ID");
      localObject = this.mOnCallback;
      if (localObject != null) {
        ((IPublicAccountArticleObserver.OnCallback)localObject).a(paramBoolean, paramObject);
      }
    }
    else
    {
      paramObject = this.mOnCallback;
      if (paramObject != null) {
        paramObject.a(false, null);
      }
    }
  }
  
  public void setOnCallback(IPublicAccountArticleObserver.OnCallback paramOnCallback)
  {
    this.mOnCallback = paramOnCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountArticleObserverImpl
 * JD-Core Version:    0.7.0.1
 */