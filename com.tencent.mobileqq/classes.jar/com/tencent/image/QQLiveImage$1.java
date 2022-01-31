package com.tencent.image;

import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QQLiveImage$1
  implements URLDrawable.URLDrawableListener
{
  QQLiveImage$1(QQLiveImage paramQQLiveImage) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e(QQLiveImage.TAG + this.this$0.ID, 2, "initCover(): onLoadFialed(): ");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable.getStatus() == 1) && ((paramURLDrawable.getCurrDrawable() instanceof RegionDrawable)))
    {
      paramURLDrawable = ((RegionDrawable)paramURLDrawable.getCurrDrawable()).getBitmap();
      this.this$0.mCoverBitmapRef = new WeakReference(paramURLDrawable);
      this.this$0.invalidateSelf();
      if (QLog.isColorLevel()) {
        QLog.d(QQLiveImage.TAG + this.this$0.ID, 2, "initCover(): onLoadSuccessed(): ");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(QQLiveImage.TAG + this.this$0.ID, 2, "initCover(): onLoadSuccessed(): ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.QQLiveImage.1
 * JD-Core Version:    0.7.0.1
 */