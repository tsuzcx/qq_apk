package com.tencent.biz.pubaccount.readinjoy.viola.lottie;

import android.content.Context;
import com.tencent.viola.ui.view.lottie.IVLottieViewProxy;
import com.tencent.viola.ui.view.lottie.IVlottieViewCreater;

public class KdLottieViewCreater
  implements IVlottieViewCreater
{
  public IVLottieViewProxy createLottieView(Context paramContext)
  {
    return new KdLottieView(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.lottie.KdLottieViewCreater
 * JD-Core Version:    0.7.0.1
 */