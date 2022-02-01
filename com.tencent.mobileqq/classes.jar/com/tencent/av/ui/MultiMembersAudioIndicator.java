package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

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
    MultiMembersAudioIndicator.1 local1 = new MultiMembersAudioIndicator.1(this, super.getContext());
    local1.setButtonDrawable(2130842262);
    local1.setGravity(17);
    Resources localResources = super.getContext().getResources();
    RadioGroup.LayoutParams localLayoutParams = new RadioGroup.LayoutParams((int)TypedValue.applyDimension(1, 10.0F, localResources.getDisplayMetrics()), (int)TypedValue.applyDimension(1, 10.0F, localResources.getDisplayMetrics()));
    localLayoutParams.gravity = 17;
    int i = (int)TypedValue.applyDimension(1, 3.0F, localResources.getDisplayMetrics());
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    local1.setLayoutParams(localLayoutParams);
    local1.setClickable(false);
    local1.setFocusable(false);
    return local1;
  }
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = ((ViewPager)localObject).getAdapter();
    if (localObject == null) {
      return;
    }
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
    localObject = (RadioButton)super.getChildAt(i);
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
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    if (((ViewPager)localObject).getAdapter() == null) {
      return;
    }
    if (super.getChildCount() <= paramInt) {
      return;
    }
    int i = paramInt;
    if (paramInt >= super.getChildCount()) {
      i = super.getChildCount() - 1;
    }
    localObject = (RadioButton)super.getChildAt(i);
    if (localObject != null) {
      ((RadioButton)localObject).setChecked(true);
    }
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.a = paramViewPager;
    paramViewPager = this.a;
    if (paramViewPager != null) {
      paramViewPager.setOnPageChangeListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiMembersAudioIndicator
 * JD-Core Version:    0.7.0.1
 */