package com.tencent.avgame.gameroom;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;

final class AVGameLottieHelper$3
  implements OnCompositionLoadedListener
{
  AVGameLottieHelper$3(int paramInt1, int paramInt2, int paramInt3, Context paramContext, String paramString, AVGameLottieHelper.LottieDrawableLoadedListener paramLottieDrawableLoadedListener) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    int i = ViewUtils.dip2px(this.a);
    int j = ViewUtils.dip2px(this.b);
    if (paramLottieComposition == null)
    {
      QLog.w("AVGameLottieHelper", 1, "onCompositionLoaded, fail");
      return;
    }
    Object localObject = paramLottieComposition.getBounds();
    float f1 = i / ((Rect)localObject).width();
    float f2 = j / ((Rect)localObject).height();
    localObject = new LottieDrawable();
    ((LottieDrawable)localObject).setComposition(paramLottieComposition);
    ((LottieDrawable)localObject).setScale(f1, f2);
    ((LottieDrawable)localObject).setRepeatCount(this.c);
    ((LottieDrawable)localObject).setImageAssetDelegate(new AVGameLottieHelper.3.1(this));
    ThreadManager.a().post(new AVGameLottieHelper.3.2(this, (LottieDrawable)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.AVGameLottieHelper.3
 * JD-Core Version:    0.7.0.1
 */