package com.tencent.aelight.camera.ae.album.fragment;

import android.support.annotation.Nullable;
import android.widget.TextView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.util.WeakReference;

class AEAbstractPhotoListFragment$ScaleLottieCompositionLoaderListener
  implements OnCompositionLoadedListener
{
  private WeakReference<AEAbstractPhotoListFragment> a;
  private boolean b;
  private boolean c;
  
  AEAbstractPhotoListFragment$ScaleLottieCompositionLoaderListener(AEAbstractPhotoListFragment paramAEAbstractPhotoListFragment, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = new WeakReference(paramAEAbstractPhotoListFragment);
    this.b = paramBoolean1;
    this.c = paramBoolean2;
  }
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    AEAbstractPhotoListFragment localAEAbstractPhotoListFragment = (AEAbstractPhotoListFragment)this.a.get();
    if (localAEAbstractPhotoListFragment == null) {
      return;
    }
    LottieDrawable localLottieDrawable = new LottieDrawable();
    localLottieDrawable.setComposition(paramLottieComposition);
    localLottieDrawable.loop(false);
    if (this.b) {
      localLottieDrawable.playAnimation();
    } else {
      localLottieDrawable.setProgress(1.0F);
    }
    localLottieDrawable.setBounds(0, 0, ImmersiveUtils.dpToPx(20.0F), ImmersiveUtils.dpToPx(20.0F));
    if (this.c)
    {
      AEAbstractPhotoListFragment.a(localAEAbstractPhotoListFragment, localLottieDrawable);
      AEAbstractPhotoListFragment.e(localAEAbstractPhotoListFragment).setCompoundDrawables(AEAbstractPhotoListFragment.d(localAEAbstractPhotoListFragment), null, null, null);
      return;
    }
    AEAbstractPhotoListFragment.b(localAEAbstractPhotoListFragment, localLottieDrawable);
    AEAbstractPhotoListFragment.e(localAEAbstractPhotoListFragment).setCompoundDrawables(AEAbstractPhotoListFragment.f(localAEAbstractPhotoListFragment), null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.ScaleLottieCompositionLoaderListener
 * JD-Core Version:    0.7.0.1
 */