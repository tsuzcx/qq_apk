package com.tencent.biz.pubaccount.readinjoy.viola.lottie;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.viola.ui.component.VLottie.IVLottieLoadListener;

class KdLottieView$1
  implements OnCompositionLoadedListener
{
  KdLottieView$1(KdLottieView paramKdLottieView, VLottie.IVLottieLoadListener paramIVLottieLoadListener) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaLottieKdLottieView.setComposition(paramLottieComposition);
      if (this.jdField_a_of_type_ComTencentViolaUiComponentVLottie$IVLottieLoadListener != null) {
        this.jdField_a_of_type_ComTencentViolaUiComponentVLottie$IVLottieLoadListener.onResult(true);
      }
    }
    while (this.jdField_a_of_type_ComTencentViolaUiComponentVLottie$IVLottieLoadListener == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentViolaUiComponentVLottie$IVLottieLoadListener.onResult(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.lottie.KdLottieView.1
 * JD-Core Version:    0.7.0.1
 */