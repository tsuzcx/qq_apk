package com.tencent.mobileqq.activity.aio.audiopanel;

import ajyc;
import android.content.Context;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ViewPagerRadioGroup
  extends RadioGroup
  implements ViewPager.OnPageChangeListener
{
  public ViewPagerRadioGroup(Context paramContext)
  {
    super(paramContext);
  }
  
  public ViewPagerRadioGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (getChildCount() > paramInt)
    {
      RadioButton localRadioButton = (RadioButton)getChildAt(paramInt);
      if (localRadioButton != null)
      {
        localRadioButton.setChecked(true);
        if (paramInt == 1)
        {
          localRadioButton.setContentDescription(ajyc.a(2131716462));
          localRadioButton.sendAccessibilityEvent(128);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ViewPagerRadioGroup
 * JD-Core Version:    0.7.0.1
 */