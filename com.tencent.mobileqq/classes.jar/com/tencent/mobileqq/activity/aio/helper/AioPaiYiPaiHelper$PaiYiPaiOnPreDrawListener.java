package com.tencent.mobileqq.activity.aio.helper;

import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.ref.WeakReference;

class AioPaiYiPaiHelper$PaiYiPaiOnPreDrawListener
  implements ViewTreeObserver.OnPreDrawListener
{
  private WeakReference<AioPaiYiPaiHelper> a;
  
  public AioPaiYiPaiHelper$PaiYiPaiOnPreDrawListener(AioPaiYiPaiHelper paramAioPaiYiPaiHelper)
  {
    this.a = new WeakReference(paramAioPaiYiPaiHelper);
  }
  
  public boolean onPreDraw()
  {
    AioPaiYiPaiHelper localAioPaiYiPaiHelper = (AioPaiYiPaiHelper)this.a.get();
    if (localAioPaiYiPaiHelper != null) {
      AioPaiYiPaiHelper.a(localAioPaiYiPaiHelper);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AioPaiYiPaiHelper.PaiYiPaiOnPreDrawListener
 * JD-Core Version:    0.7.0.1
 */