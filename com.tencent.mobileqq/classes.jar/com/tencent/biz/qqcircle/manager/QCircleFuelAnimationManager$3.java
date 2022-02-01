package com.tencent.biz.qqcircle.manager;

import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

final class QCircleFuelAnimationManager$3
  implements URLDrawable.URLDrawableListener
{
  QCircleFuelAnimationManager$3(int[] paramArrayOfInt) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d(QCircleFuelAnimationManager.a, 2, "applyNormalPaster onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d(QCircleFuelAnimationManager.a, 2, "urlDrawableListener onLoadSuccessed");
    }
    paramURLDrawable = paramURLDrawable.getCurrDrawable();
    if ((paramURLDrawable != null) && ((paramURLDrawable instanceof ApngDrawable)) && (((ApngDrawable)paramURLDrawable).getImage() != null)) {
      ApngImage.playByTag(this.a[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleFuelAnimationManager.3
 * JD-Core Version:    0.7.0.1
 */