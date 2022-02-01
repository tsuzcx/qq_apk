package com.tencent.av.ui.guide;

import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class GuideHelper$LottieDrawableHelper
{
  void a(long paramLong, Context paramContext, String paramString, GuideHelper.LottieDrawableHelper.LottieDrawableLoadedListener paramLottieDrawableLoadedListener)
  {
    try
    {
      LottieComposition.Factory.fromAssetFileName(paramContext, paramString, new GuideHelper.LottieDrawableHelper.1(this, paramContext, paramLong, paramLottieDrawableLoadedListener));
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("GuideHelper", 1, "fromAssetFileName fail, seq[" + paramLong + "]", paramContext);
      ThreadManager.a().post(new GuideHelper.LottieDrawableHelper.2(this, paramLottieDrawableLoadedListener));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.guide.GuideHelper.LottieDrawableHelper
 * JD-Core Version:    0.7.0.1
 */