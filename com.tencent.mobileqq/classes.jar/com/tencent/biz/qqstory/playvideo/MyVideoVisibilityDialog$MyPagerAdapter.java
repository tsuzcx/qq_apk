package com.tencent.biz.qqstory.playvideo;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;

class MyVideoVisibilityDialog$MyPagerAdapter
  extends PagerAdapter
{
  private List<View> jdField_a_of_type_JavaUtilList;
  
  public MyVideoVisibilityDialog$MyPagerAdapter(List<View> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.addView((View)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.MyVideoVisibilityDialog.MyPagerAdapter
 * JD-Core Version:    0.7.0.1
 */