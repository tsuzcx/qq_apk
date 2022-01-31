package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import luf;

public class MultiMembersAudioIndicator
  extends RadioGroup
  implements ViewPager.OnPageChangeListener
{
  public ViewPager a;
  
  public MultiMembersAudioIndicator(Context paramContext)
  {
    super(paramContext);
    super.setOrientation(0);
    super.setGravity(17);
  }
  
  public MultiMembersAudioIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOrientation(0);
    super.setGravity(17);
  }
  
  public RadioButton a()
  {
    luf localluf = new luf(this, super.getContext());
    localluf.setButtonDrawable(2130841590);
    localluf.setGravity(17);
    Resources localResources = super.getContext().getResources();
    RadioGroup.LayoutParams localLayoutParams = new RadioGroup.LayoutParams((int)TypedValue.applyDimension(1, 10.0F, localResources.getDisplayMetrics()), (int)TypedValue.applyDimension(1, 10.0F, localResources.getDisplayMetrics()));
    localLayoutParams.gravity = 17;
    int i = (int)TypedValue.applyDimension(1, 3.0F, localResources.getDisplayMetrics());
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localluf.setLayoutParams(localLayoutParams);
    localluf.setClickable(false);
    localluf.setFocusable(false);
    return localluf;
  }
  
  public void a()
  {
    if (this.a == null) {}
    do
    {
      return;
      localObject = this.a.getAdapter();
    } while (localObject == null);
    int k = ((PagerAdapter)localObject).getCount();
    super.removeAllViews();
    int i = 0;
    while (i < k)
    {
      super.addView(a());
      i += 1;
    }
    int j = this.a.getCurrentItem();
    i = j;
    if (j >= super.getChildCount()) {
      i = super.getChildCount() - 1;
    }
    Object localObject = (RadioButton)super.getChildAt(i);
    if (localObject != null) {
      ((RadioButton)localObject).setChecked(true);
    }
    if (k <= 1)
    {
      super.setVisibility(4);
      return;
    }
    super.setVisibility(0);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (this.a == null) {}
    RadioButton localRadioButton;
    do
    {
      do
      {
        return;
      } while ((this.a.getAdapter() == null) || (super.getChildCount() <= paramInt));
      int i = paramInt;
      if (paramInt >= super.getChildCount()) {
        i = super.getChildCount() - 1;
      }
      localRadioButton = (RadioButton)super.getChildAt(i);
    } while (localRadioButton == null);
    localRadioButton.setChecked(true);
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.a = paramViewPager;
    if (this.a != null) {
      this.a.setOnPageChangeListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.MultiMembersAudioIndicator
 * JD-Core Version:    0.7.0.1
 */