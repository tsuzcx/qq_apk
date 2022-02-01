package com.tencent.ad.tangram.util;

import android.support.annotation.Keep;
import android.view.View;
import java.lang.ref.WeakReference;

@Keep
public abstract interface AdExposureChecker$ExposureCallback
{
  public abstract void onExposure(WeakReference<View> paramWeakReference);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
 * JD-Core Version:    0.7.0.1
 */