package com.tencent.biz.publicAccountImageCollection;

import com.tencent.biz.pubaccount.PublicAccountArticleObserver;
import com.tencent.qphone.base.util.QLog;

class PublicAccountImageCollectionPreloadManager$2
  extends PublicAccountArticleObserver
{
  PublicAccountImageCollectionPreloadManager$2(PublicAccountImageCollectionPreloadManager paramPublicAccountImageCollectionPreloadManager, long paramLong) {}
  
  public void a(boolean paramBoolean, PublicAccountImageCollectionUtils.PhotoCollectionInfo paramPhotoCollectionInfo, byte[] paramArrayOfByte, String paramString)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager.a(true, this.jdField_a_of_type_Long);
      if (paramPhotoCollectionInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onGetPhotoCollectionInfoRespond isSuccess=" + paramBoolean + " ;articleID = " + paramPhotoCollectionInfo.a);
        }
        this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager.a(paramPhotoCollectionInfo, paramArrayOfByte);
        this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager.b(paramPhotoCollectionInfo);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionPreloadManager.a(false, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager.2
 * JD-Core Version:    0.7.0.1
 */