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
  long a;
  int b;
  URLDrawable c;
  
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
    this.d.c(false);
    this.d.J = null;
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
    QQToast.makeText(AIOGalleryScene.e(this.d), AIOGalleryScene.f(this.d).getString(2131892726), 0).show();
    this.d.d(true);
    this.d.c(false);
    this.d.J = null;
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
    this.d.d(false);
    this.d.c(false);
    this.d.c.b.c = paramURLDrawable.getExifOrientation();
    this.d.a.a(paramURLDrawable, AIOGalleryScene.g(this.d).getSelectedItemPosition());
    this.d.a.notifyDataSetChanged();
    AIOGalleryScene.h(this.d).reset();
    this.d.J = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.RawPhotoProgress
 * JD-Core Version:    0.7.0.1
 */