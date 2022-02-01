package com.tencent.biz.qqcircle.viewmodels;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class QCirclePublishButtonViewModel$1
  implements URLDrawable.URLDrawableListener
{
  QCirclePublishButtonViewModel$1(QCirclePublishButtonViewModel paramQCirclePublishButtonViewModel) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.e("QCirclePublishButtonViewModel", 1, "operatorIcon onLoadCanceled");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("QCirclePublishButtonViewModel", 1, "operatorIcon onLoadFialed: ", paramThrowable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QLog.i("QCirclePublishButtonViewModel", 1, "operatorIcon onLoadSuccessed");
    if (QCirclePublishButtonViewModel.a(this.a) == null) {
      return;
    }
    QCirclePublishButtonViewModel.a(this.a).f = paramURLDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCirclePublishButtonViewModel.1
 * JD-Core Version:    0.7.0.1
 */