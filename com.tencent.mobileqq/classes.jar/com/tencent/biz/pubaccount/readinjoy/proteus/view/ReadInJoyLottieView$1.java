package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyLottieView$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ReadInJoyLottieView$1(ReadInJoyLottieView paramReadInJoyLottieView) {}
  
  public void onGlobalLayout()
  {
    if ((ReadInJoyLottieView.a(this.a).isShown()) && (!ReadInJoyLottieView.a(this.a)))
    {
      QLog.d("ReadInJoyLottieView", 2, "resumeAnimation");
      this.a.a();
      ReadInJoyLottieView.a(this.a, true);
    }
    if ((!ReadInJoyLottieView.a(this.a).isShown()) && (ReadInJoyLottieView.a(this.a)))
    {
      QLog.d("ReadInJoyLottieView", 2, "pauseAnimation");
      this.a.b();
      ReadInJoyLottieView.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyLottieView.1
 * JD-Core Version:    0.7.0.1
 */