package com.tencent.avgame.gameroom;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;

final class AVGameLottieHelper$1
  implements OnCompositionLoadedListener
{
  AVGameLottieHelper$1(int paramInt1, int paramInt2, Context paramContext, String paramString, AVGameLottieHelper.LottieDrawableLoadedListener paramLottieDrawableLoadedListener) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition == null)
    {
      QLog.w("AVGameLottieHelper", 1, "onCompositionLoaded, fail");
      return;
    }
    LottieDrawable localLottieDrawable = new LottieDrawable();
    localLottieDrawable.setComposition(paramLottieComposition);
    if ((this.jdField_a_of_type_Int > 0) && (this.b > 0))
    {
      paramLottieComposition = paramLottieComposition.getBounds();
      int i = AIOUtils.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentContext.getResources());
      int j = AIOUtils.a(this.b, this.jdField_a_of_type_AndroidContentContext.getResources());
      localLottieDrawable.setScale(i / paramLottieComposition.width(), j / paramLottieComposition.height());
    }
    localLottieDrawable.setRepeatCount(0);
    localLottieDrawable.setImageAssetDelegate(new AVGameLottieHelper.1.1(this));
    ThreadManager.a().post(new AVGameLottieHelper.1.2(this, localLottieDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.AVGameLottieHelper.1
 * JD-Core Version:    0.7.0.1
 */