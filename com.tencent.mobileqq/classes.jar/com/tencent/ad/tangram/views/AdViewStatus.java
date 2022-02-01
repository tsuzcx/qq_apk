package com.tencent.ad.tangram.views;

import android.support.annotation.Keep;
import android.view.View;
import com.tencent.ad.tangram.util.AdUIUtils;
import java.lang.ref.WeakReference;

@Keep
public class AdViewStatus
{
  public static final int CREATED = 0;
  public static final int DESTROYED = 3;
  public static final int PAUSED = 2;
  public static final int RESUMED = 1;
  private WeakReference<AdViewStatus.Listener> listener;
  private float percentageResume = 0.0F;
  private int statusForActivity;
  private WeakReference<View> view;
  public boolean visible;
  
  public AdViewStatus(WeakReference<View> paramWeakReference, WeakReference<AdViewStatus.Listener> paramWeakReference1)
  {
    this(paramWeakReference, paramWeakReference1, 0.0F);
  }
  
  public AdViewStatus(WeakReference<View> paramWeakReference, WeakReference<AdViewStatus.Listener> paramWeakReference1, float paramFloat)
  {
    this.view = paramWeakReference;
    this.listener = paramWeakReference1;
    this.percentageResume = paramFloat;
    this.statusForActivity = 0;
    this.visible = false;
  }
  
  private void notifyStatusChanged(boolean paramBoolean)
  {
    if (this.listener.get() != null)
    {
      boolean bool = this.visible;
      if (paramBoolean == bool) {
        return;
      }
      if (bool)
      {
        ((AdViewStatus.Listener)this.listener.get()).onViewResume();
        return;
      }
      ((AdViewStatus.Listener)this.listener.get()).onViewPause();
    }
  }
  
  public void onActivityDestroy()
  {
    this.statusForActivity = 3;
    onLocationChanged();
  }
  
  public void onActivityPaused()
  {
    this.statusForActivity = 2;
    onLocationChanged();
  }
  
  public void onActivityResumed()
  {
    this.statusForActivity = 1;
    if (this.view.get() == null) {
      return;
    }
    ((View)this.view.get()).postDelayed(new AdViewStatus.1(this), 500L);
  }
  
  public void onLocationChanged()
  {
    boolean bool2 = this.visible;
    int i = this.statusForActivity;
    boolean bool1 = false;
    if (i == 0) {
      this.visible = false;
    } else if (i == 3) {
      this.visible = false;
    } else if (i == 1)
    {
      if (this.view.get() != null)
      {
        if (AdUIUtils.getPercentageOfGlobalVisibleRect((View)this.view.get()) > this.percentageResume) {
          bool1 = true;
        }
        this.visible = bool1;
      }
      else
      {
        this.visible = false;
      }
    }
    else if (i == 2) {
      this.visible = false;
    }
    notifyStatusChanged(bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.AdViewStatus
 * JD-Core Version:    0.7.0.1
 */