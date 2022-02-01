package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.os.Handler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class ReadInjoyIMAXAdFragment$2
  implements URLDrawable.URLDrawableListener
{
  ReadInjoyIMAXAdFragment$2(ReadInjoyIMAXAdFragment paramReadInjoyIMAXAdFragment, int paramInt1, int paramInt2) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoyIMAXAdFragment", 2, "onLoadCanceled");
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoyIMAXAdFragment", 2, "onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("onLoadProgressed =");
      paramURLDrawable.append(paramInt);
      QLog.d("ReadInjoyIMAXAdFragment", 2, paramURLDrawable.toString());
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    ReadInjoyIMAXAdFragment.a(this.c, this.a, this.b);
    ReadInjoyIMAXAdFragment.e(this.c).removeMessages(-2);
    ReadInjoyIMAXAdFragment.e(this.c).sendEmptyMessage(-2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment.2
 * JD-Core Version:    0.7.0.1
 */