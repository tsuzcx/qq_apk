package com.tencent.biz.pubaccount.imagecollection.api.impl;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver.OnCallback;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.PhotoCollectionInfo;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.RecommendItemInfo;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class PublicAccountImageCollectionMainActivityImpl$3
  extends IPublicAccountArticleObserver.OnCallback
{
  PublicAccountImageCollectionMainActivityImpl$3(PublicAccountImageCollectionMainActivityImpl paramPublicAccountImageCollectionMainActivityImpl) {}
  
  public void a(IPublicAccountImageCollectionUtils.PhotoCollectionInfo paramPhotoCollectionInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "onGetPhotoCollectionInfoRespond");
    }
    PublicAccountImageCollectionMainActivityImpl.access$602(this.a, paramPhotoCollectionInfo);
    if (paramPhotoCollectionInfo == null)
    {
      PublicAccountImageCollectionMainActivityImpl.access$400(this.a).postDelayed(new PublicAccountImageCollectionMainActivityImpl.3.5(this), 0L);
      return;
    }
    PublicAccountImageCollectionMainActivityImpl.access$602(this.a, paramPhotoCollectionInfo);
    PublicAccountImageCollectionMainActivityImpl.access$800(this.a);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReportReadPhotoCollectionRespond isSuccess =");
      localStringBuilder.append(paramBoolean);
      QLog.d("qqBaseActivity", 2, localStringBuilder.toString());
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCreateArticleCommentRespond isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("qqBaseActivity", 2, ((StringBuilder)localObject).toString());
    }
    int j = 0;
    int i = j;
    if (paramBoolean)
    {
      i = j;
      if (paramInt == 0)
      {
        PublicAccountImageCollectionMainActivityImpl.access$1108(this.a);
        i = 1;
      }
    }
    PublicAccountImageCollectionMainActivityImpl.access$400(this.a).postDelayed(new PublicAccountImageCollectionMainActivityImpl.3.6(this, paramBoolean, paramInt), 0L);
    Object localObject = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str1 = this.a.puin;
    String str2 = this.a.articleID;
    String str3 = this.a.webUrl;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(i);
    ((IPublicAccountReportUtils)localObject).publicAccountReportClickEvent(null, str1, "0X8007B97", "0X8007B97", 0, 0, str2, str3, localStringBuilder.toString(), "", false);
  }
  
  public void a(boolean paramBoolean, IPublicAccountImageCollectionUtils.PhotoCollectionInfo paramPhotoCollectionInfo, byte[] paramArrayOfByte, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onGetPhotoCollectionInfoRespond isSuccess=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("qqBaseActivity", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramBoolean)
    {
      if ((paramString != null) && (!paramString.equals(this.a.articleID)))
      {
        if (paramPhotoCollectionInfo != null)
        {
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("onGetPhotoCollectionInfoRespond isSuccess=");
            paramString.append(paramBoolean);
            paramString.append(" ;articleID = ");
            paramString.append(paramPhotoCollectionInfo.a);
            QLog.d("qqBaseActivity", 2, paramString.toString());
          }
          ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).saveImageCollectionInfo(paramPhotoCollectionInfo, paramArrayOfByte);
          ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).preloadImage(paramPhotoCollectionInfo);
        }
      }
      else
      {
        PublicAccountImageCollectionMainActivityImpl.access$602(this.a, paramPhotoCollectionInfo);
        if (paramPhotoCollectionInfo == null)
        {
          PublicAccountImageCollectionMainActivityImpl.access$400(this.a).postDelayed(new PublicAccountImageCollectionMainActivityImpl.3.3(this), 0L);
        }
        else
        {
          PublicAccountImageCollectionMainActivityImpl.access$602(this.a, paramPhotoCollectionInfo);
          ((IPublicAccountImageCollectionPreloadManager)QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).saveImageCollectionInfo(paramPhotoCollectionInfo, paramArrayOfByte);
          PublicAccountImageCollectionMainActivityImpl.access$800(this.a);
        }
      }
    }
    else {
      PublicAccountImageCollectionMainActivityImpl.access$400(this.a).postDelayed(new PublicAccountImageCollectionMainActivityImpl.3.4(this), 0L);
    }
    int j = 0;
    int i = j;
    if (paramPhotoCollectionInfo != null)
    {
      i = j;
      if (paramPhotoCollectionInfo.i != null) {
        i = paramPhotoCollectionInfo.i.size();
      }
    }
    paramPhotoCollectionInfo = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    paramArrayOfByte = this.a.puin;
    paramString = this.a.articleID;
    Object localObject1 = this.a.webUrl;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    Object localObject3 = this.a;
    ((StringBuilder)localObject2).append(PublicAccountImageCollectionMainActivityImpl.access$1000((PublicAccountImageCollectionMainActivityImpl)localObject3, PublicAccountImageCollectionMainActivityImpl.access$900((PublicAccountImageCollectionMainActivityImpl)localObject3)));
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(i);
    paramPhotoCollectionInfo.publicAccountReportClickEvent(null, paramArrayOfByte, "0X8007B8A", "0X8007B8A", 0, 0, paramString, (String)localObject1, (String)localObject2, ((StringBuilder)localObject3).toString(), false);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSendArticleLikeReq,articleID=");
      localStringBuilder.append(paramString);
      QLog.d("qqBaseActivity", 2, localStringBuilder.toString());
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onQueryArticleLikeCount,articleID=");
      localStringBuilder.append(paramString);
      localStringBuilder.append("likeCount");
      localStringBuilder.append(paramInt);
      QLog.d("qqBaseActivity", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(this.a.articleID)))
    {
      PublicAccountImageCollectionMainActivityImpl.access$302(this.a, paramInt);
      PublicAccountImageCollectionMainActivityImpl.access$400(this.a).postDelayed(new PublicAccountImageCollectionMainActivityImpl.3.1(this, paramInt), 0L);
    }
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCheckIsArticleLiked,articleID=");
      localStringBuilder.append(paramString);
      localStringBuilder.append("isLiked");
      localStringBuilder.append(paramBoolean2);
      QLog.d("qqBaseActivity", 2, localStringBuilder.toString());
    }
    if ((paramBoolean1) && (!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(this.a.articleID)))
    {
      PublicAccountImageCollectionMainActivityImpl.access$502(this.a, paramBoolean2);
      PublicAccountImageCollectionMainActivityImpl.access$400(this.a).postDelayed(new PublicAccountImageCollectionMainActivityImpl.3.2(this), 0L);
    }
  }
  
  public void a(boolean paramBoolean, ArrayList<IPublicAccountImageCollectionUtils.RecommendItemInfo> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetRecommendInfoRespond isSuccess =");
      localStringBuilder.append(paramBoolean);
      QLog.d("qqBaseActivity", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      if ((paramArrayList != null) && (paramArrayList.size() != 0))
      {
        PublicAccountImageCollectionMainActivityImpl.access$1302(this.a, paramArrayList);
        PublicAccountImageCollectionMainActivityImpl.access$400(this.a).postDelayed(new PublicAccountImageCollectionMainActivityImpl.3.9(this, paramArrayList), 0L);
        return;
      }
      PublicAccountImageCollectionMainActivityImpl.access$400(this.a).postDelayed(new PublicAccountImageCollectionMainActivityImpl.3.8(this), 0L);
      return;
    }
    PublicAccountImageCollectionMainActivityImpl.access$400(this.a).postDelayed(new PublicAccountImageCollectionMainActivityImpl.3.10(this), 0L);
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetArticleCommentCountRespond count=");
      localStringBuilder.append(paramInt);
      QLog.d("qqBaseActivity", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      PublicAccountImageCollectionMainActivityImpl.access$1102(this.a, paramInt);
      PublicAccountImageCollectionMainActivityImpl.access$400(this.a).postDelayed(new PublicAccountImageCollectionMainActivityImpl.3.7(this), 0L);
    }
  }
  
  public void c(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetArticleReadCount isSuccess =");
      localStringBuilder.append(paramBoolean);
      QLog.d("qqBaseActivity", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      PublicAccountImageCollectionMainActivityImpl.access$1402(this.a, paramInt);
      PublicAccountImageCollectionMainActivityImpl.access$400(this.a).postDelayed(new PublicAccountImageCollectionMainActivityImpl.3.11(this), 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.3
 * JD-Core Version:    0.7.0.1
 */