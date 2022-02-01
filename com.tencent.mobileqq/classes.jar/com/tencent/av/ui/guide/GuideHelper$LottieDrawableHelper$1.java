package com.tencent.av.ui.guide;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;

class GuideHelper$LottieDrawableHelper$1
  implements OnCompositionLoadedListener
{
  GuideHelper$LottieDrawableHelper$1(GuideHelper.LottieDrawableHelper paramLottieDrawableHelper, Context paramContext, long paramLong, GuideHelper.LottieDrawableHelper.LottieDrawableLoadedListener paramLottieDrawableLoadedListener) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    int i = AIOUtils.b(130.0F, this.a.getResources());
    int j = AIOUtils.b(120.0F, this.a.getResources());
    if (paramLottieComposition == null)
    {
      paramLottieComposition = new StringBuilder();
      paramLottieComposition.append("onCompositionLoaded, fail, seq[");
      paramLottieComposition.append(this.b);
      paramLottieComposition.append("]");
      QLog.w("GuideHelper", 1, paramLottieComposition.toString());
      return;
    }
    Object localObject = paramLottieComposition.getBounds();
    float f1 = i / ((Rect)localObject).width();
    float f2 = j / ((Rect)localObject).height();
    localObject = new LottieDrawable();
    ((LottieDrawable)localObject).setComposition(paramLottieComposition);
    ((LottieDrawable)localObject).setScale(f1, f2);
    ((LottieDrawable)localObject).setRepeatCount(-1);
    ((LottieDrawable)localObject).setImageAssetDelegate(new GuideHelper.LottieDrawableHelper.1.1(this));
    ThreadManager.a().post(new GuideHelper.LottieDrawableHelper.1.2(this, (LottieDrawable)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.guide.GuideHelper.LottieDrawableHelper.1
 * JD-Core Version:    0.7.0.1
 */