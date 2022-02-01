package com.tencent.av.ui.guide;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.dinifly.LottieDrawable;

class GuideHelper$2
  implements GuideHelper.LottieDrawableHelper.LottieDrawableLoadedListener
{
  GuideHelper$2(GuideHelper paramGuideHelper, long paramLong, Context paramContext, int paramInt) {}
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    this.d.b.d = paramLottieDrawable;
    if ((paramLottieDrawable != null) && (this.d.b.b != null))
    {
      this.d.b.b.setBackgroundDrawable(paramLottieDrawable);
      GuideHelper.a(this.d, this.a, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.guide.GuideHelper.2
 * JD-Core Version:    0.7.0.1
 */