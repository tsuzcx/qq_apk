package com.tencent.biz.qqstory.playvideo;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;

class MyVideoVisibilityDialog$MyPagerAdapter
  extends PagerAdapter
{
  private List<View> b;
  
  public MyVideoVisibilityDialog$MyPagerAdapter(List<View> paramList)
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
    paramViewGroup.addView((View)this.b.get(paramInt));
    return this.b.get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.MyVideoVisibilityDialog.MyPagerAdapter
 * JD-Core Version:    0.7.0.1
 */