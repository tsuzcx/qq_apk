package com.tencent.biz.pubaccount.readinjoy.viola.delegate;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ViolaInitDelegate$3
  implements ViewPager.OnPageChangeListener
{
  ViolaInitDelegate$3(ViolaInitDelegate paramViolaInitDelegate) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (!TextUtils.isEmpty(ViolaInitDelegate.a(this.a)))
    {
      this.a.a(ViolaInitDelegate.a(this.a));
      ViolaInitDelegate.a(this.a, null);
      QLog.d("ViolaInitDelegate", 1, "violaViewPager onPageScrolled potition : " + paramInt1 + " , mCurrentPosition:" + ViolaInitDelegate.a(this.a));
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    int i = 0;
    if (i < ViolaInitDelegate.a(this.a).size())
    {
      ViolaBaseView localViolaBaseView = (ViolaBaseView)ViolaInitDelegate.a(this.a).get(i);
      if (localViolaBaseView != null)
      {
        if (i == paramInt) {
          break label56;
        }
        localViolaBaseView.a(false);
        localViolaBaseView.onActivityPause();
      }
      for (;;)
      {
        i += 1;
        break;
        label56:
        localViolaBaseView.a(true);
        localViolaBaseView.onActivityResume();
      }
    }
    ViolaInitDelegate.a(this.a, paramInt);
    ViolaInitDelegate.a(this.a).dealFlingEnableWhenSwitcher(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.delegate.ViolaInitDelegate.3
 * JD-Core Version:    0.7.0.1
 */