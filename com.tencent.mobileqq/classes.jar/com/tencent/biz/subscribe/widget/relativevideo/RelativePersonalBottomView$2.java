package com.tencent.biz.subscribe.widget.relativevideo;

import android.view.View;
import android.widget.RadioGroup;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.subscribe.SubImageLoader;
import com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment;
import java.util.List;

class RelativePersonalBottomView$2
  implements ViewPager.OnPageChangeListener
{
  RelativePersonalBottomView$2(RelativePersonalBottomView paramRelativePersonalBottomView) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    
    if ((RelativePersonalBottomView.d(this.a) != null) && (RelativePersonalBottomView.d(this.a).getChildCount() > paramInt)) {
      RelativePersonalBottomView.d(this.a).getChildAt(paramInt).performClick();
    }
    if (RelativePersonalBottomView.e(this.a).size() > paramInt) {
      ((SubscribeBaseBottomPersonalFragment)RelativePersonalBottomView.e(this.a).get(paramInt)).a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView.2
 * JD-Core Version:    0.7.0.1
 */