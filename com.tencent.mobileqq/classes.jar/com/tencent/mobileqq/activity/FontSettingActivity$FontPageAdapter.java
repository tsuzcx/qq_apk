package com.tencent.mobileqq.activity;

import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;

class FontSettingActivity$FontPageAdapter
  extends PagerAdapter
{
  FontSettingActivity$FontPageAdapter(FontSettingActivity paramFontSettingActivity) {}
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    ((ViewPager)paramView).removeView((View)this.a.d.get(paramInt));
  }
  
  public int getCount()
  {
    return this.a.d.size();
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    ((ViewPager)paramView).addView((View)this.a.d.get(paramInt), 0);
    return this.a.d.get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FontSettingActivity.FontPageAdapter
 * JD-Core Version:    0.7.0.1
 */