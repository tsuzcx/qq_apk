package com.tencent.mobileqq.activity.aio.panel;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class PokeEmoPageAdapter
  extends PagerAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<View> jdField_a_of_type_JavaUtilList;
  
  public PokeEmoPageAdapter(Context paramContext, List<View> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    super.finishUpdate(paramViewGroup);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
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
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    super.setPrimaryItem(paramViewGroup, paramInt, paramObject);
  }
  
  public void startUpdate(ViewGroup paramViewGroup)
  {
    super.startUpdate(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PokeEmoPageAdapter
 * JD-Core Version:    0.7.0.1
 */