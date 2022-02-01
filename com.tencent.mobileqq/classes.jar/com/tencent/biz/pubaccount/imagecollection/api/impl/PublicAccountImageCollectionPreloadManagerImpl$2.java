package com.tencent.biz.pubaccount.imagecollection.api.impl;

import com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver.OnCallback;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.PhotoCollectionInfo;
import com.tencent.qphone.base.util.QLog;

class PublicAccountImageCollectionPreloadManagerImpl$2
  extends IPublicAccountArticleObserver.OnCallback
{
  PublicAccountImageCollectionPreloadManagerImpl$2(PublicAccountImageCollectionPreloadManagerImpl paramPublicAccountImageCollectionPreloadManagerImpl, long paramLong) {}
  
  public void a(boolean paramBoolean, IPublicAccountImageCollectionUtils.PhotoCollectionInfo paramPhotoCollectionInfo, byte[] paramArrayOfByte, String paramString)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiImplPublicAccountImageCollectionPreloadManagerImpl.doStatisticReportForProtoTime(true, this.jdField_a_of_type_Long);
      if (paramPhotoCollectionInfo != null)
      {
        if (QLog.isColorLevel())
        {
          paramString = PublicAccountImageCollectionPreloadManagerImpl.access$400();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onGetPhotoCollectionInfoRespond isSuccess=");
          localStringBuilder.append(paramBoolean);
          localStringBuilder.append(" ;articleID = ");
          localStringBuilder.append(paramPhotoCollectionInfo.a);
          QLog.d(paramString, 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiImplPublicAccountImageCollectionPreloadManagerImpl.saveImageCollectionInfo(paramPhotoCollectionInfo, paramArrayOfByte);
        this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiImplPublicAccountImageCollectionPreloadManagerImpl.preloadImage(paramPhotoCollectionInfo);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiImplPublicAccountImageCollectionPreloadManagerImpl.doStatisticReportForProtoTime(false, this.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionPreloadManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */