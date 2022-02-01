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
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForExposure;
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;

@Keep
public final class AdExposureChecker
{
  private static final double AD_REPORT_SATISFIED_VISIBLE_AREA = 0.5D;
  private static final String TAG = "AdExposureChecker";
  private Ad ad;
  private long durationMillis = 1000L;
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
    getDuration();
  }
  
  private long getDuration()
  {
    if ((this.mViewRef == null) || (this.mViewRef.get() == null) || (((View)this.mViewRef.get()).getContext() == null)) {}
    Object localObject;
    do
    {
      return -2147483648L;
      localObject = ((View)this.mViewRef.get()).getContext();
      localObject = AdSettingsUtil.INSTANCE.getSettingsCache((Context)localObject);
    } while ((localObject == null) || (((gdt_settings.Settings)localObject).settingsForExposure == null) || (((gdt_settings.Settings)localObject).settingsForExposure.durationMillis == -2147483648L));
    this.durationMillis = ((gdt_settings.Settings)localObject).settingsForExposure.durationMillis;
    return this.durationMillis;
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
    if (paramView == null) {}
    while ((paramView.getVisibility() != 0) || (AdUIUtils.getPercentageOfGlobalVisibleRect(paramView) < 0.5D)) {
      return false;
    }
    return true;
  }
  
  private void listenViewStateChange(View paramView)
  {
    if ((paramView == null) || (paramView.getViewTreeObserver() == null)) {
      return;
    }
    paramView.getViewTreeObserver().addOnScrollChangedListener(this.scrollChangedListener);
    paramView.addOnAttachStateChangeListener(this.statusChangeListener);
  }
  
  public static void onClick(Context paramContext, Ad paramAd, WeakReference<AdExposureChecker.ExposureCallback> paramWeakReference)
  {
    AdThreadManager.INSTANCE.post(new AdExposureChecker.5(paramContext, paramWeakReference, paramAd), 0);
  }
  
  private void setViewDestroyed()
  {
    if ((this.mViewRef != null) && (this.mViewRef.get() != null))
    {
      stopCheck();
      this.mViewRef = null;
    }
  }
  
  private void setViewPause()
  {
    if ((this.mViewRef != null) && (this.mViewRef.get() != null)) {
      stopCheck();
    }
  }
  
  private void setViewResume()
  {
    if ((this.mViewRef != null) && (this.mViewRef.get() != null)) {
      startCheck();
    }
  }
  
  private void stopCheck()
  {
    if (this.internalTask != null)
    {
      this.mainHandler.removeCallbacks(this.internalTask);
      this.internalTask = null;
    }
    if ((this.mViewRef != null) && (this.mViewRef.get() != null)) {
      ((View)this.mViewRef.get()).removeOnAttachStateChangeListener(this.statusChangeListener);
    }
    if ((this.mViewRef != null) && (this.mViewRef.get() != null)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdExposureChecker
 * JD-Core Version:    0.7.0.1
 */