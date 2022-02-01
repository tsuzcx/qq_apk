package com.tencent.ilive.interfaces;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

public abstract interface ILiveOnPageChangeListener
  extends ViewPager.OnPageChangeListener
{
  public abstract void onPageScrollBottom();
  
  public abstract void onPageScrollTop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.interfaces.ILiveOnPageChangeListener
 * JD-Core Version:    0.7.0.1
 */