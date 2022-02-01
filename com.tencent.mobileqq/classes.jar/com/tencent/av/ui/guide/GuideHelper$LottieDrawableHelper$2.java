package com.tencent.av.ui.guide;

class GuideHelper$LottieDrawableHelper$2
  implements Runnable
{
  GuideHelper$LottieDrawableHelper$2(GuideHelper.LottieDrawableHelper paramLottieDrawableHelper, GuideHelper.LottieDrawableHelper.LottieDrawableLoadedListener paramLottieDrawableLoadedListener) {}
  
  public void run()
  {
    GuideHelper.LottieDrawableHelper.LottieDrawableLoadedListener localLottieDrawableLoadedListener = this.a;
    if (localLottieDrawableLoadedListener != null) {
      localLottieDrawableLoadedListener.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.guide.GuideHelper.LottieDrawableHelper.2
 * JD-Core Version:    0.7.0.1
 */