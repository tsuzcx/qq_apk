package com.tencent.biz.publicAccountImageCollection;

import com.tencent.biz.pubaccount.readinjoy.view.imageloader.CloseableBitmap;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class PublicAccountImageCollectionAdapter$6
  implements PublicAccountImageDownListener
{
  PublicAccountImageCollectionAdapter$6(PublicAccountImageCollectionAdapter paramPublicAccountImageCollectionAdapter, boolean paramBoolean, long paramLong, ImageProgressCircle paramImageProgressCircle) {}
  
  public void a(URL paramURL, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage onLoadProgressed");
    }
    PublicAccountImageCollectionAdapter.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionAdapter, this.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle, paramInt);
  }
  
  public void a(URL paramURL, CloseableBitmap paramCloseableBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage onLoadSuccessed");
    }
    if (!this.jdField_a_of_type_Boolean) {
      PublicAccountImageCollectionPreloadManager.a().b(true, this.jdField_a_of_type_Long);
    }
    PublicAccountImageCollectionAdapter.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionAdapter, this.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
  }
  
  public void a(URL paramURL, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage onLoadFailed");
    }
    if (!this.jdField_a_of_type_Boolean) {
      PublicAccountImageCollectionPreloadManager.a().b(false, this.jdField_a_of_type_Long);
    }
    PublicAccountImageCollectionAdapter.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionAdapter, this.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionAdapter.6
 * JD-Core Version:    0.7.0.1
 */