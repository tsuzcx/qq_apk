package com.tencent.mobileqq.activity.recent.guidebanner;

import androidx.lifecycle.MutableLiveData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class NewerGuideBannerViewModel$1
  implements URLDrawable.URLDrawableListener
{
  NewerGuideBannerViewModel$1(NewerGuideBannerViewModel paramNewerGuideBannerViewModel, AppRuntime paramAppRuntime) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.d("NewerGuideBannerViewModel", 1, "onLoadCanceled");
    this.b.c(this.a);
    paramURLDrawable.setURLDrawableListener(null);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.d("NewerGuideBannerViewModel", 1, "onLoadFailed");
    this.b.c(this.a);
    paramURLDrawable.setURLDrawableListener(null);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QLog.d("NewerGuideBannerViewModel", 1, "onLoadSuccess");
    NewerGuideBannerViewModel.b(this.b).setValue(NewerGuideBannerData.a(NewerGuideBannerViewModel.a(this.b), true));
    NewerGuideBannerViewModel.a(this.b, this.a);
    paramURLDrawable.setURLDrawableListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerViewModel.1
 * JD-Core Version:    0.7.0.1
 */