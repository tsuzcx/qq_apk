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
    IntimateInfoView.h(this.a);
    QQToast.makeText(this.a.b, 0, 2131891014, 1).show();
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    IntimateInfoView.h(this.a);
    QQToast.makeText(this.a.b, 0, 2131891014, 1).show();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    IntimateInfoView.h(this.a);
    paramURLDrawable = this.a;
    IntimateInfoView.a(paramURLDrawable, IntimateInfoView.i(paramURLDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.6
 * JD-Core Version:    0.7.0.1
 */