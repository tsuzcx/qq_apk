package com.tencent.mobileqq.activity.aio;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.widget.QQToast;

class IntimateInfoView$6
  implements URLDrawable.URLDrawableListener
{
  IntimateInfoView$6(IntimateInfoView paramIntimateInfoView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    IntimateInfoView.d(this.a);
    QQToast.a(this.a.a, 0, 2131693465, 1).a();
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    IntimateInfoView.d(this.a);
    QQToast.a(this.a.a, 0, 2131693465, 1).a();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    IntimateInfoView.d(this.a);
    paramURLDrawable = this.a;
    IntimateInfoView.a(paramURLDrawable, IntimateInfoView.a(paramURLDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.6
 * JD-Core Version:    0.7.0.1
 */