package com.tencent.biz.qqstory.view.widget;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class SlideTabViewPager$TabViewAdapter
  extends PagerAdapter
{
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public SlideTabViewPager$TabViewAdapter(SlideTabViewPager paramSlideTabViewPager, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = (View)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramViewGroup.addView(localView);
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.SlideTabViewPager.TabViewAdapter
 * JD-Core Version:    0.7.0.1
 */