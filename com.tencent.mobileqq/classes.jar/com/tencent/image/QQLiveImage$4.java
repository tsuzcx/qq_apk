package com.tencent.image;

import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;
import java.lang.ref.WeakReference;

class QQLiveImage$4
  implements URLDrawable.URLDrawableListener
{
  QQLiveImage$4(QQLiveImage paramQQLiveImage) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      paramURLDrawable = URLDrawable.depImp.mLog;
      paramThrowable = new StringBuilder();
      paramThrowable.append(QQLiveImage.TAG);
      paramThrowable.append(this.this$0.ID);
      paramURLDrawable.e(paramThrowable.toString(), 2, "initCover(): onLoadFialed(): ");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    StringBuilder localStringBuilder;
    if ((paramURLDrawable.getStatus() == 1) && ((paramURLDrawable.getCurrDrawable() instanceof RegionDrawable)))
    {
      paramURLDrawable = ((RegionDrawable)paramURLDrawable.getCurrDrawable()).getBitmap();
      this.this$0.mCoverBitmapRef = new WeakReference(paramURLDrawable);
      this.this$0.invalidateSelf();
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        paramURLDrawable = URLDrawable.depImp.mLog;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(QQLiveImage.TAG);
        localStringBuilder.append(this.this$0.ID);
        paramURLDrawable.d(localStringBuilder.toString(), 2, "initCover(): onLoadSuccessed(): ");
      }
    }
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      paramURLDrawable = URLDrawable.depImp.mLog;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(QQLiveImage.TAG);
      localStringBuilder.append(this.this$0.ID);
      paramURLDrawable.d(localStringBuilder.toString(), 2, "initCover(): onLoadSuccessed(): ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.QQLiveImage.4
 * JD-Core Version:    0.7.0.1
 */