package com.tencent.biz.qqcircle.immersive.part;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.qqcircle.immersive.tab.QFSBaseTabFragment;
import java.util.ArrayList;

class QFSMainMultiTabFragmentPart$3
  implements ViewPager.OnPageChangeListener
{
  QFSMainMultiTabFragmentPart$3(QFSMainMultiTabFragmentPart paramQFSMainMultiTabFragmentPart) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    ((QFSBaseTabFragment)QFSMainMultiTabFragmentPart.f(this.a).get(paramInt)).a(paramInt);
    QFSMainMultiTabFragmentPart.b(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSMainMultiTabFragmentPart.3
 * JD-Core Version:    0.7.0.1
 */