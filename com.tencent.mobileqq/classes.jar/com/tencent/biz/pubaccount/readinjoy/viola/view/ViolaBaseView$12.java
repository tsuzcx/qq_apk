package com.tencent.biz.pubaccount.readinjoy.viola.view;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaInstance.ViolaPageListener;

class ViolaBaseView$12
  implements ViolaInstance.ViolaPageListener
{
  ViolaBaseView$12(ViolaBaseView paramViolaBaseView) {}
  
  public void onComponentFloatBottom(View paramView, float paramFloat)
  {
    if (((ViolaBaseView.a(this.a) instanceof ViolaFragment)) && (((ViolaFragment)ViolaBaseView.a(this.a)).getCommonSuspensionGestureLayout() != null)) {
      ((ViolaFragment)ViolaBaseView.a(this.a)).getCommonSuspensionGestureLayout().c(paramView, paramFloat);
    }
  }
  
  public void onComponentFloatCenter(View paramView, float paramFloat)
  {
    if (((ViolaBaseView.a(this.a) instanceof ViolaFragment)) && (((ViolaFragment)ViolaBaseView.a(this.a)).getCommonSuspensionGestureLayout() != null)) {
      ((ViolaFragment)ViolaBaseView.a(this.a)).getCommonSuspensionGestureLayout().b(paramView, paramFloat);
    }
  }
  
  public void onComponentTopIndex(View paramView, float paramFloat)
  {
    if (((ViolaBaseView.a(this.a) instanceof ViolaFragment)) && (((ViolaFragment)ViolaBaseView.a(this.a)).getCommonSuspensionGestureLayout() != null)) {
      ((ViolaFragment)ViolaBaseView.a(this.a)).getCommonSuspensionGestureLayout().a(paramView, paramFloat);
    }
  }
  
  public void onDispatchTouchEvent(String paramString, int paramInt1, MotionEvent paramMotionEvent, int paramInt2)
  {
    if (paramString.equals(ViolaBaseView.a(this.a).getMasterListRef())) {
      ViolaBaseView.b(this.a, paramInt2);
    }
  }
  
  public void onScroll(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if (paramString.equals(ViolaBaseView.a(this.a).getMasterListRef()))
    {
      ViolaBaseView.b(this.a, paramInt5);
      ViolaBaseView.b(this.a, true);
      if (ViolaBaseView.a(this.a) != null) {
        ViolaBaseView.a(this.a).a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean);
      }
    }
  }
  
  public void onScrollStateChanged(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (ViolaBaseView.a(this.a) != null) {
      ViolaBaseView.a(this.a).a(paramString, paramInt1);
    }
    if (paramString.equals(ViolaBaseView.a(this.a).getMasterListRef()))
    {
      ViolaBaseView.b(this.a, paramInt2);
      ViolaBaseView.b(this.a, true);
    }
  }
  
  public void pageOpenSuccess()
  {
    ViolaBaseView.a(this.a, 3);
    ViolaBaseView.e(this.a);
    ViolaBaseView.f(this.a);
    if ((!TextUtils.isEmpty(this.a.a)) && (this.a.a.contains("VideoFeeds.js"))) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800AF0E", "0X800AF0E", 0, 0, null, null, null, "" + System.currentTimeMillis(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.12
 * JD-Core Version:    0.7.0.1
 */