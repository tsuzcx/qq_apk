package com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import java.util.Iterator;
import java.util.List;

class FaceViewPager$1
  implements ViewPager.OnPageChangeListener
{
  FaceViewPager$1(FaceViewPager paramFaceViewPager) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    Iterator localIterator = FaceViewPager.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((FaceViewPager.PageChangedObserver)localIterator.next()).b(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager.1
 * JD-Core Version:    0.7.0.1
 */