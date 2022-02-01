package com.tencent.biz.qqstory.view.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;

public class SlideTabViewPager$TabViewAdapter
  extends PagerAdapter
{
  private ArrayList<View> b = new ArrayList();
  
  public SlideTabViewPager$TabViewAdapter(ArrayList<View> paramArrayList)
  {
    Object localObject;
    this.b = localObject;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.b.get(paramInt));
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = (View)this.b.get(paramInt);
    paramViewGroup.addView(localView);
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.SlideTabViewPager.TabViewAdapter
 * JD-Core Version:    0.7.0.1
 */