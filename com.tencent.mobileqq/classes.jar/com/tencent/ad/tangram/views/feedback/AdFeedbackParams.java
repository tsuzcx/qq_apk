package com.tencent.ad.tangram.views.feedback;

import android.app.Activity;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.Ad;
import java.lang.ref.WeakReference;

@Keep
public final class AdFeedbackParams
{
  public WeakReference<Activity> activity;
  public Ad gdtAd;
  public boolean isDarkMode;
  public WeakReference<AdFeedbackDialogFragment.Listener> listener;
  public int orientation;
  
  public static AdFeedbackParams build(WeakReference<Activity> paramWeakReference, WeakReference<AdFeedbackDialogFragment.Listener> paramWeakReference1, Ad paramAd)
  {
    return build(paramWeakReference, paramWeakReference1, paramAd, 0);
  }
  
  public static AdFeedbackParams build(WeakReference<Activity> paramWeakReference, WeakReference<AdFeedbackDialogFragment.Listener> paramWeakReference1, Ad paramAd, int paramInt)
  {
    return build(paramWeakReference, paramWeakReference1, paramAd, paramInt, false);
  }
  
  public static AdFeedbackParams build(WeakReference<Activity> paramWeakReference, WeakReference<AdFeedbackDialogFragment.Listener> paramWeakReference1, Ad paramAd, int paramInt, boolean paramBoolean)
  {
    AdFeedbackParams localAdFeedbackParams = new AdFeedbackParams();
    localAdFeedbackParams.activity = paramWeakReference;
    localAdFeedbackParams.listener = paramWeakReference1;
    localAdFeedbackParams.gdtAd = paramAd;
    localAdFeedbackParams.orientation = paramInt;
    localAdFeedbackParams.isDarkMode = paramBoolean;
    return localAdFeedbackParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.feedback.AdFeedbackParams
 * JD-Core Version:    0.7.0.1
 */