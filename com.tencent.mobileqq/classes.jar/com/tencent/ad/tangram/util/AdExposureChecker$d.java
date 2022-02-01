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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onViewAttachedToWindow ");
    int i;
    if (paramView != null) {
      i = paramView.hashCode();
    } else {
      i = -1;
    }
    localStringBuilder.append(i);
    AdLog.i("AdExposureChecker", localStringBuilder.toString());
    AdExposureChecker.access$900(this.this$0);
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onViewDetachedFromWindow ");
    int i;
    if (paramView != null) {
      i = paramView.hashCode();
    } else {
      i = -1;
    }
    localStringBuilder.append(i);
    AdLog.e("AdExposureChecker", localStringBuilder.toString());
    AdExposureChecker.access$1000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdExposureChecker.d
 * JD-Core Version:    0.7.0.1
 */