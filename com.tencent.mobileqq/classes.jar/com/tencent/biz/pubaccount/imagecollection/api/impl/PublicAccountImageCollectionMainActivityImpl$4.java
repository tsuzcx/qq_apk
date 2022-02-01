package com.tencent.biz.pubaccount.imagecollection.api.impl;

import com.tencent.biz.pubaccount.api.IPublicAccountArticleHandler;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.PhotoCollectionInfo;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

class PublicAccountImageCollectionMainActivityImpl$4
  implements Runnable
{
  PublicAccountImageCollectionMainActivityImpl$4(PublicAccountImageCollectionMainActivityImpl paramPublicAccountImageCollectionMainActivityImpl) {}
  
  public void run()
  {
    PublicAccountImageCollectionMainActivityImpl.access$1500(this.this$0).queryArticleLikeCount(this.this$0.articleID);
    PublicAccountImageCollectionMainActivityImpl.access$1500(this.this$0).checkIsArticleLiked(this.this$0.articleID);
    PublicAccountImageCollectionMainActivityImpl.access$1500(this.this$0).getRecommendInfo(this.this$0.articleID);
    PublicAccountImageCollectionMainActivityImpl.access$1500(this.this$0).queryArticleReadCount(this.this$0.articleID);
    if (PublicAccountImageCollectionMainActivityImpl.access$1600(this.this$0))
    {
      PublicAccountImageCollectionMainActivityImpl.access$1500(this.this$0).getPhotoCollectionInfo(this.this$0.articleID, PublicAccountImageCollectionMainActivityImpl.access$1700(this.this$0), PublicAccountImageCollectionMainActivityImpl.access$1800(this.this$0), PublicAccountImageCollectionMainActivityImpl.access$1900(this.this$0));
      return;
    }
    int j = 0;
    int i = j;
    if (PublicAccountImageCollectionMainActivityImpl.access$600(this.this$0) != null)
    {
      i = j;
      if (PublicAccountImageCollectionMainActivityImpl.access$600(this.this$0).a != null) {
        i = PublicAccountImageCollectionMainActivityImpl.access$600(this.this$0).a.size();
      }
    }
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str1 = this.this$0.puin;
    String str2 = this.this$0.articleID;
    String str3 = this.this$0.webUrl;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    Object localObject2 = this.this$0;
    ((StringBuilder)localObject1).append(PublicAccountImageCollectionMainActivityImpl.access$1000((PublicAccountImageCollectionMainActivityImpl)localObject2, PublicAccountImageCollectionMainActivityImpl.access$900((PublicAccountImageCollectionMainActivityImpl)localObject2)));
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(i);
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str1, "0X8007B8A", "0X8007B8A", 0, 0, str2, str3, (String)localObject1, ((StringBuilder)localObject2).toString(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.4
 * JD-Core Version:    0.7.0.1
 */