package com.tencent.ad.tangram.util;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Keep;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;

@Keep
public final class AdExposureChecker
{
  private static final double AD_REPORT_SATISFIED_VISIBLE_AREA = 0.5D;
  private static final String TAG = "AdExposureChecker";
  private Ad ad;
  private long durationMillis = 200L;
  private AdExposureChecker.a internalTask = null;
  private boolean isViewDestroyed = false;
  private boolean isViewOnForeground = true;
  private WeakReference<AdExposureChecker.ExposureCallback> mCallback = null;
  private WeakReference<View> mViewRef;
  private Handler mainHandler = null;
  private AdExposureChecker.b scrollChangedListener = new AdExposureChecker.6(this, this.durationMillis);
  private AdExposureChecker.c status = AdExposureChecker.c.NONE;
  private AdExposureChecker.d statusChangeListener = null;
  
  public AdExposureChecker(Ad paramAd, WeakReference<View> paramWeakReference)
  {
    this.ad = paramAd;
    this.mViewRef = paramWeakReference;
    if (this.statusChangeListener == null) {
      this.statusChangeListener = new AdExposureChecker.d(this, null);
    }
    if (this.mainHandler == null) {
      this.mainHandler = new Handler(Looper.getMainLooper());
    }
  }
  
  private boolean isVisible(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    return paramView.getGlobalVisibleRect(new Rect());
  }
  
  private static boolean isVisibleAreaSatisfied(View paramView)
  {
    return (paramView != null) && (paramView.getVisibility() == 0) && (AdUIUtils.getPercentageOfGlobalVisibleRect(paramView) >= 0.5D);
  }
  
  private void listenViewStateChange(View paramView)
  {
    if (paramView != null)
    {
      if (paramView.getViewTreeObserver() == null) {
        return;
      }
      paramView.getViewTreeObserver().addOnScrollChangedListener(this.scrollChangedListener);
      paramView.addOnAttachStateChangeListener(this.statusChangeListener);
    }
  }
  
  public static void onClick(Context paramContext, Ad paramAd, WeakReference<AdExposureChecker.ExposureCallback> paramWeakReference)
  {
    AdThreadManager.INSTANCE.post(new AdExposureChecker.5(paramContext, paramWeakReference, paramAd), 0);
  }
  
  private void setViewDestroyed()
  {
    WeakReference localWeakReference = this.mViewRef;
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      stopCheck();
      this.mViewRef = null;
    }
  }
  
  private void setViewPause()
  {
    WeakReference localWeakReference = this.mViewRef;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      stopCheck();
    }
  }
  
  private void setViewResume()
  {
    WeakReference localWeakReference = this.mViewRef;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      startCheck();
    }
  }
  
  private void stopCheck()
  {
    Object localObject = this.internalTask;
    if (localObject != null)
    {
      this.mainHandler.removeCallbacks((Runnable)localObject);
      this.internalTask = null;
    }
    localObject = this.mViewRef;
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      ((View)this.mViewRef.get()).removeOnAttachStateChangeListener(this.statusChangeListener);
    }
    localObject = this.mViewRef;
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      ((View)this.mViewRef.get()).getViewTreeObserver().removeOnScrollChangedListener(this.scrollChangedListener);
    }
    this.status = AdExposureChecker.c.END;
  }
  
  public void onActivityDestroy()
  {
    this.mainHandler.post(new AdExposureChecker.4(this));
  }
  
  public void onActivityPause()
  {
    this.mainHandler.post(new AdExposureChecker.3(this));
  }
  
  public void onActivityResume()
  {
    this.mainHandler.post(new AdExposureChecker.2(this));
  }
  
  public void setCallback(WeakReference<AdExposureChecker.ExposureCallback> paramWeakReference)
  {
    this.mCallback = paramWeakReference;
  }
  
  public void startCheck()
  {
    AdLog.i("AdExposureChecker", "startCheck");
    AdThreadManager.INSTANCE.post(new AdExposureChecker.1(this), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdExposureChecker
 * JD-Core Version:    0.7.0.1
 */