package com.tencent.avgame.gameroom;

final class AVGameLottieHelper$2
  implements Runnable
{
  AVGameLottieHelper$2(AVGameLottieHelper.LottieDrawableLoadedListener paramLottieDrawableLoadedListener) {}
  
  public void run()
  {
    AVGameLottieHelper.LottieDrawableLoadedListener localLottieDrawableLoadedListener = this.a;
    if (localLottieDrawableLoadedListener != null) {
      localLottieDrawableLoadedListener.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.AVGameLottieHelper.2
 * JD-Core Version:    0.7.0.1
 */