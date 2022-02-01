package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;

final class AIOGalleryScene$RawPhotoProgress
  implements URLDrawable.URLDrawableListener
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  
  AIOGalleryScene$RawPhotoProgress(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("rawPhotoBtn decode onLoadCanceled URL():");
      localStringBuilder.append(paramURLDrawable.getURL());
      QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
    }
    this.a.c(false);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress = null;
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      paramThrowable = new StringBuilder();
      paramThrowable.append("rawPhotoBtn decode onLoadFialed URL():");
      paramThrowable.append(paramURLDrawable.getURL());
      QLog.d("AIOGalleryScene", 2, paramThrowable.toString());
    }
    QQToast.a(AIOGalleryScene.b(this.a), AIOGalleryScene.c(this.a).getString(2131694998), 0).a();
    this.a.d(true);
    this.a.c(false);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress = null;
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("rawPhotoBtn decode onLoadSuccessed URL():");
      localStringBuilder.append(paramURLDrawable.getURL());
      QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
    }
    this.a.d(false);
    this.a.c(false);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b.b = paramURLDrawable.getExifOrientation();
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramURLDrawable, AIOGalleryScene.c(this.a).getSelectedItemPosition());
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.notifyDataSetChanged();
    AIOGalleryScene.d(this.a).reset();
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.RawPhotoProgress
 * JD-Core Version:    0.7.0.1
 */