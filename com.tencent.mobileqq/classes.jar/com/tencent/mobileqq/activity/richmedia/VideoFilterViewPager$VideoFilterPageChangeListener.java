package com.tencent.mobileqq.activity.richmedia;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;

class VideoFilterViewPager$VideoFilterPageChangeListener
  implements ViewPager.OnPageChangeListener
{
  VideoFilterViewPager$VideoFilterPageChangeListener(VideoFilterViewPager paramVideoFilterViewPager) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterViewPager", 2, "onPageScrollStateChanged state: " + paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterViewPager", 2, "onPageScrolled position: " + paramInt1 + ", positionOffset: " + paramFloat + ", positionOffsetPixels: " + paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterViewPager", 2, "onPageSelected position: " + paramInt);
    }
    int i = VideoFilterViewPager.a(this.a).a(paramInt);
    if ((VideoFilterViewPager.a(this.a) != null) && (i != 0))
    {
      VideoFilterViewPager.a(this.a).a(0);
      VideoFilterViewPager.a(this.a, i);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterViewPager", 2, "OnViewPagerItemVisiableChangeListener state: 0");
      }
    }
    for (;;)
    {
      FlowCameraMqqAction.a("", "0X8007804", "", "", "", "");
      Object localObject1 = VideoFilterViewPager.a(this.a).a(paramInt);
      VideoFilterTools.a().a((FilterDesc)localObject1);
      localObject1 = VideoFilterViewPager.a(this.a).a(paramInt);
      if (localObject1 != null)
      {
        localObject2 = new VideoFilterViewPager.VideoFilterPageChangeListener.1(this, paramInt, (View)localObject1);
        ((View)localObject1).setVisibility(0);
        ((View)localObject1).postDelayed((Runnable)localObject2, 1800L);
        ((View)localObject1).setTag(localObject2);
        VideoFilterViewPager.a(this.a, (View)localObject1, paramInt, false);
      }
      localObject1 = VideoFilterViewPager.a(this.a).a(paramInt - 1);
      Object localObject2 = VideoFilterViewPager.a(this.a).a(paramInt + 1);
      if (localObject1 != null)
      {
        ((View)localObject1).removeCallbacks((Runnable)((View)localObject1).getTag());
        ((View)localObject1).clearAnimation();
      }
      if (localObject2 != null)
      {
        ((View)localObject2).removeCallbacks((Runnable)((View)localObject2).getTag());
        ((View)localObject2).clearAnimation();
      }
      return;
      if ((VideoFilterViewPager.a(this.a) != null) && (VideoFilterViewPager.a(this.a).a(paramInt) == 0) && (VideoFilterViewPager.a(this.a) != 0))
      {
        VideoFilterViewPager.a(this.a).a(0);
        VideoFilterViewPager.a(this.a, 0);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFilterViewPager", 2, "OnViewPagerItemVisiableChangeListener state-check: 0");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager.VideoFilterPageChangeListener
 * JD-Core Version:    0.7.0.1
 */