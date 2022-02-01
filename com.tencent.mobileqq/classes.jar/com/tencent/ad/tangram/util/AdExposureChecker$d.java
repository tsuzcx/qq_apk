package com.tencent.ad.tangram.util;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.ad.tangram.log.AdLog;

class AdExposureChecker$d
  implements View.OnAttachStateChangeListener
{
  private AdExposureChecker$d(AdExposureChecker paramAdExposureChecker) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onViewAttachedToWindow ");
    if (paramView != null) {}
    for (int i = paramView.hashCode();; i = -1)
    {
      AdLog.i("AdExposureChecker", i);
      AdExposureChecker.access$900(this.this$0);
      return;
    }
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onViewDetachedFromWindow ");
    if (paramView != null) {}
    for (int i = paramView.hashCode();; i = -1)
    {
      AdLog.e("AdExposureChecker", i);
      AdExposureChecker.access$1000(this.this$0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdExposureChecker.d
 * JD-Core Version:    0.7.0.1
 */